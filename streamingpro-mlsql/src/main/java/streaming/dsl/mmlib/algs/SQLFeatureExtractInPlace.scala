package streaming.dsl.mmlib.algs

import java.util.regex.Pattern

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession, functions => F}
import org.apache.spark.sql.expressions.UserDefinedFunction
import streaming.dsl.mmlib.SQLAlg
import streaming.dsl.mmlib.algs.MetaConst.getMetaPath

/**
  * Created by wuheyi on 2018/8/19.
  */
class SQLFeatureExtractInPlace extends SQLAlg with Functions {

  /**
    * Boolean型特征提取
    *
    * @return
    */
  def featureExisted = (regex_array: Array[String], feature: String) => {
    regex_array.map(regex => {
      val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
      val matcher = pattern.matcher(feature)
      matcher.find()
    }).contains(true)
  }

  /**
    * 是否含有电话
    *
    * @return
    */
  def phoneExisted = F.udf((doc: String) => {
    featureExisted(SQLFeatureExtractInPlace.EXISTED_PHONE_REGEX, doc)
  })

  /**
    * 是否含有邮箱地址
    *
    * @return
    */
  def emailExisted = F.udf((doc: String) => {
    featureExisted(SQLFeatureExtractInPlace.EXISTED_EMAIL_REGEX, doc)
  })

  /**
    * 是否还有qq微信号
    *
    * @return
    */
  def qqwechatExisted = F.udf((doc: String) => {
    featureExisted(SQLFeatureExtractInPlace.EXISTED_QQWECHAT_REGEX, doc)
  })

  /**
    * 数字型特征提取
    *
    * @return
    */
  def featureNumber = (regex_array: Array[String], feature: String) => {
    regex_array.map(regex => {
      val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
      val matcher = pattern.matcher(feature)
      if (matcher != null && matcher.find()) {
        matcher.groupCount()
      } else {
        0
      }
    })
  }

  /**
    * url数量
    *
    * @return
    */
  def urlNumber = F.udf((doc: String) => {
    featureNumber(SQLFeatureExtractInPlace.URL_NUMBER_REGEX, doc)
  })

  /**
    * 图片数量
    *
    * @return
    */
  def picNumber = F.udf((doc: String) => {
    featureNumber(SQLFeatureExtractInPlace.PIC_NUMBER_REGEX, doc)
  })


  def internal_train(df: DataFrame, params: Map[String, String]) = {
    val path = params("path")
    val metaPath = getMetaPath(path)
    saveTraningParams(df.sparkSession, params, metaPath)
    val featureCol = params.getOrElse(SQLFeatureExtractInPlace.INPUTCOL, SQLFeatureExtractInPlace.FEATUREC_COL)
    val featureExtractResult = df.withColumn("phone", phoneExisted(F.col(featureCol)))
      .withColumn("email", emailExisted(F.col(featureCol)))
      .withColumn("qqwechat", qqwechatExisted(F.col(featureCol)))
      .withColumn("url", urlNumber(F.col(featureCol)))
      .withColumn("pic", picNumber(F.col(featureCol)))
    featureExtractResult.write.mode(SaveMode.Overwrite).parquet(MetaConst.getDataPath(path))
  }


  override def train(df: DataFrame, path: String, params: Map[String, String]): Unit = {
    internal_train(df, params + ("path" -> path))
  }

  override def load(sparkSession: SparkSession, path: String, params: Map[String, String]): Any = ???

  override def predict(sparkSession: SparkSession, _model: Any, name: String, params: Map[String, String]): UserDefinedFunction = ???
}

object SQLFeatureExtractInPlace {
  /**
    * 输入列名
    */
  val INPUTCOL = "inputCol"
  /**
    * 待提取字段的文本字段名称
    */
  val FEATUREC_COL = "doc"
  /**
    * 参数数组前缀
    */
  val PARAMS_PREFIX = "fitParam"
  /**
    * 是否含有电话的正则表达式规则
    */
  val EXISTED_PHONE_REGEX = Array(
    """[01]{1}\d{2,3}-?\d{8}""",
    """(热线|电话|TEL|来电|短信|手机).{,3}\d{3,}""",
    """400-?\d{3}-?\d{3}""",
    """\D1\d{2}[\- ]?\d{4}[\- ]??\d{4}""",
    """(热线|电话|TEL|来电|手机).{,3}\d{3,}[- ]?\d{3,}[- ]?\d{3,}""",
    """\D1\d{2}\s*\D?\s*\d{4}\s*\D?\s*\d{4}""",
    """\D1\d{3}\s*\D?\s*\d{4}\s*\D?\s*\d{3}""")
  /**
    * 是否含有邮箱地址的正则表达式规则
    */
  val EXISTED_EMAIL_REGEX =
    Array("""[\*a-zA-Z0-9-_]+@[a-zA-Z0-9]+\.[a-zA-Z]+""")
  /**
    * 是否还有qq微信号的正则表达式规则
    */
  val EXISTED_QQWECHAT_REGEX = Array(
    """(加|Q|群|加我|扣扣)[^\w]{,10}\d{5,}""",
    """(Q|群|加我|扣扣)[^\w]{,10}(\d[\- ]?){5,}""",
    """(微信|v信|V)[^\w]{,8}[a-zA-Z0-9]{5,}""")
  /**
    * url数量的正则表达式规则
    */
  val URL_NUMBER_REGEX = Array("""[^@](\w[\w\-_]+\.){1,3}(com|cn|net|jp[^\w])/?""")
  /**
    * 图片数量的正则表达式规则
    */
  val PIC_NUMBER_REGEX = Array("""这个规则待定""")
  /**
    * 空格百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
    */

  /**
    * 中文百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
    */

  /**
    * 英文百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
    */

  /**
    * 数字百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
    */

  /**
    * 标点百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
    */

  /**
    * 出现最多字符百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
    */

  /**
    * 文本长度的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
    */
}
