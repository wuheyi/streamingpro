package streaming.dsl.mmlib.algs

import java.io.File
import java.util
import java.util.UUID

import org.apache.commons.io.FileUtils
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.ml.clustering.BisectingKMeansModel
import org.apache.spark.ml.linalg.SQLDataTypes._
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SaveMode, SparkSession}
import org.apache.spark.util.ExternalCommandRunner
import streaming.dsl.mmlib.SQLAlg
import streaming.dsl.mmlib.algs.MetaConst.getDataPath

import scala.collection.JavaConverters._
import scala.io.Source

/**
 * Created by dxy_why on 2018/6/24.
 */
class SQLModelExplainInPlace extends SQLAlg with Functions {

  def sparkmllibTrain(df: DataFrame, path: String, params: Map[String, String]): Unit = {
    val modelPath = params.getOrElse("modelPath", "")
    val model = BisectingKMeansModel.load(modelPath)
    val model_info = "clusterCenters \n" + model.clusterCenters.mkString("\n") + model.explainParams()
    import df.sparkSession.sqlContext.implicits._
    Seq(model_info).toDF("sparkmllib_model_expalin_params")
      .write.mode(SaveMode.Overwrite).parquet(getDataPath(path))
  }

  def sklearnTrain(df: DataFrame, path: String, params: Map[String, String]): Unit = {
    val systemParam = mapParams("systemParam", params)
    val pythonPath = systemParam.getOrElse("pythonPath", "python")

    import df.sparkSession.sqlContext.implicits._
    val ExternalCommandRunnerDataframe = Seq("").toDF("model_expalin_inplace_field")
    ExternalCommandRunnerDataframe.rdd.map(f => {
      val fs = FileSystem.get(new Configuration())
      val paramMap = new util.HashMap[String, Object]()
      paramMap.put("systemParam", systemParam.asJava)
      val modelPath = params.getOrElse("modelPath", "")
      val tempModelPath = s"/tmp/${UUID.randomUUID().toString}.pkl"
      fs.copyToLocalFile(new Path(modelPath), new Path(tempModelPath))
      paramMap.put("modelPath", tempModelPath)
      val tempModelLocalPath = s"${SQLPythonFunc.getLocalBasePath}/${UUID.randomUUID().toString}/0"
      FileUtils.forceMkdir(new File(tempModelLocalPath))

      paramMap.put("internalSystemParam", Map(
        "tempModelLocalPath" -> tempModelLocalPath
      ).asJava)
      val tfName = "mlsql_sk_attributes.py"
      val filePath = s"/python/${tfName}"
      val tfSource = Source.fromInputStream(ExternalCommandRunner.getClass.getResourceAsStream(filePath)).
        getLines().mkString("\n")
      val pythonScript = PythonScript(tfName, tfSource, filePath)

      val res = ExternalCommandRunner.run(Seq(pythonPath, pythonScript.fileName),
        paramMap,
        MapType(StringType, MapType(StringType, StringType)),
        pythonScript.fileContent,
        pythonScript.fileName, modelPath = null, kafkaParam = Map[String, String](),
        validateData = null
      )
      res.foreach(f => f)
      //模型保存到hdfs上
      val modelHDFSPath = SQLPythonFunc.getAlgModelPath(path) + "/0"
      fs.delete(new Path(modelHDFSPath), true)
      fs.copyFromLocalFile(new Path(tempModelLocalPath),
        new Path(modelHDFSPath))
      // delete local model
      FileUtils.deleteDirectory(new File(tempModelLocalPath))
      f
    }).count()
    val modelHDFSPath = SQLPythonFunc.getAlgModelPath(path) + "/0"
    df.sparkSession.read.json(modelHDFSPath + "/attributes.json")
      .write.mode(SaveMode.Overwrite).parquet(getDataPath(path))
  }

  override def train(df: DataFrame, path: String, params: Map[String, String]): Unit = {
    val modelType = params.getOrElse("modelType", "sklearn")
    modelType match {
      case "sklearn" => sklearnTrain(df, path, params)
      case "sparkmllib" => sparkmllibTrain(df, path, params)
      case _ =>
    }
  }

  override def load(sparkSession: SparkSession, path: String, params: Map[String, String]): Any = {
    throw new RuntimeException("register is not supported by this module now")
  }

  override def predict(sparkSession: SparkSession, _model: Any, name: String, params: Map[String, String]): UserDefinedFunction = {
    UserDefinedFunction(null, VectorType, Some(Seq(VectorType)))
  }
}