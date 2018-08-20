package streaming.dsl.mmlib.algs

import java.util.regex.Pattern

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession, functions => F}
import org.apache.spark.sql.expressions.UserDefinedFunction
import streaming.dsl.mmlib.SQLAlg
import streaming.dsl.mmlib.algs.MetaConst.getMetaPath

/**
 * Created by dxy_why on 2018/8/20.
 */
class SQLFeatureExtractInPlace extends SQLAlg with Functions {

  /**
   * 是否含有电话
   *
   * @return
   */
  def phoneExisted = F.udf((doc: String) => {
    SQLFeatureExtractInPlace.EXISTED_PHONE_REGEX.map(regex => {
      val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
      val matcher = pattern.matcher(doc)
      matcher.find()
    }).contains(true)
  })

  /**
   * 是否含有邮箱地址
   *
   * @return
   */
  def emailExisted = F.udf((doc: String) => {
    SQLFeatureExtractInPlace.EXISTED_EMAIL_REGEX.map(regex => {
      val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
      val matcher = pattern.matcher(doc)
      matcher.find()
    }).contains(true)
  })

  /**
   * 是否还有qq微信号
   *
   * @return
   */
  def qqwechatExisted = F.udf((doc: String) => {
    SQLFeatureExtractInPlace.EXISTED_QQWECHAT_REGEX.map(regex => {
      val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
      val matcher = pattern.matcher(doc)
      matcher.find()
    }).contains(true)
  })

  /**
   * url数量
   *
   * @return
   */
  def urlNumber = F.udf((doc: String) => {
    SQLFeatureExtractInPlace.URL_NUMBER_REGEX.map(regex => {
      val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
      val matcher = pattern.matcher(doc)
      var count = 0
      while (matcher.find()) {
        count += 1
      }
      count
    }).head
  })

  /**
   * 图片数量
   *
   * @return
   */
  def picNumber = F.udf((doc: String) => {
    SQLFeatureExtractInPlace.PIC_NUMBER_REGEX.map(regex => {
      val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
      val matcher = pattern.matcher(doc)
      var count = 0
      while (matcher.find()) {
        count += 1
      }
      count
    }).head
  })

  def cleanDoc = F.udf((doc: String) => {
    /**
     * 去除html标签
     */
    var cleanedDoc = doc.replaceAll("<[^>]*>", "").replaceAll("&nbsp", "")

    /**
     * 去除url
     */
    val urlPattern = Pattern.compile(SQLFeatureExtractInPlace.URL_NUMBER_REGEX(0),
      Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
    val urlMatcher = urlPattern.matcher(cleanedDoc)
    cleanedDoc = urlMatcher.replaceAll("")

    /**
     * 去除邮箱
     */
    val emailPattern = Pattern.compile(SQLFeatureExtractInPlace.EXISTED_EMAIL_REGEX(0),
      Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
    val emailMatcher = emailPattern.matcher(cleanedDoc)
    cleanedDoc = emailMatcher.replaceAll("")

    /**
     * 去除图片链接
     */
    val picPattern = Pattern.compile(SQLFeatureExtractInPlace.PIC_NUMBER_REGEX(0),
      Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
    val picMatcher = picPattern.matcher(cleanedDoc)
    cleanedDoc = picMatcher.replaceAll("")

    cleanedDoc

  })

  /**
   * 文本长度
   *
   * @return
   */
  def docLength = F.udf((doc: String) => {
    doc.length
  })


  /**
   * 空格百分比
   *
   * @return
   */
  def blankPercent = F.udf((doc: String) => {
    if (doc.length != 0) {
      (doc.split(" ").length - 1) * 100 / doc.length
    } else {
      0
    }
  })

  /**
   * 中文百分比
   *
   * @return
   */
  def chinesePercent = F.udf((doc: String) => {
    val pattern = Pattern.compile(SQLFeatureExtractInPlace.CHINESE_PERCENT_REGEX(0),
      Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
    val matcher = pattern.matcher(doc)
    var count = 0
    while (matcher.find()) {
      count += 1
    }
    if (doc.length != 0) {
      count * 100 / doc.length
    } else {
      0
    }
  })

  /**
   * 英文百分比
   *
   * @return
   */
  def englishPercent = F.udf((doc: String) => {
    val pattern = Pattern.compile(SQLFeatureExtractInPlace.ENGLISH_PERCENT_REGEX(0),
      Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
    val matcher = pattern.matcher(doc)
    var count = 0
    while (matcher.find()) {
      count += 1
    }
    if (doc.length != 0) {
      count * 100 / doc.length
    } else {
      0
    }
  })

  /**
   * 数字百分比
   *
   * @return
   */
  def numberPercent = F.udf((doc: String) => {
    val pattern = Pattern.compile(SQLFeatureExtractInPlace.NUMBER_PERCENT_REGEX(0),
      Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
    val matcher = pattern.matcher(doc)
    var count = 0
    while (matcher.find()) {
      count += 1
    }
    if (doc.length != 0) {
      count * 100 / doc.length
    } else {
      0
    }
  })

  /**
   * 标点百分比
   *
   * @return
   */
  def punctuationPercent = F.udf((doc: String) => {
    val pattern = Pattern.compile(SQLFeatureExtractInPlace.PUNCTUATION_PERCENT_REGEX(0),
      Pattern.CASE_INSENSITIVE & Pattern.DOTALL)
    val matcher = pattern.matcher(doc)
    var count = 0
    while (matcher.find()) {
      count += 1
    }
    if (doc.length != 0) {
      count * 100 / doc.length
    } else {
      0
    }
  })

  /**
   * 出现最多字符百分比
   *
   * @return
   */
  def mostcharPercent = F.udf((doc: String) => {
    doc.split("").map((_, 1)).groupBy(_._1).map(t => (t._1, t._2.size)).maxBy(_._2)._2
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
      .withColumn("cleanedDoc", cleanDoc(F.col(featureCol)))
      .withColumn("black", blankPercent(F.col("cleanedDoc")))
      .withColumn("chinese", chinesePercent(F.col("cleanedDoc")))
      .withColumn("english", englishPercent(F.col("cleanedDoc")))
      .withColumn("number", numberPercent(F.col("cleanedDoc")))
      .withColumn("punctuation", punctuationPercent(F.col("cleanedDoc")))
      .withColumn("mostchar", mostcharPercent(F.col("cleanedDoc")))
      .withColumn("length", docLength(F.col("cleanedDoc")))
    featureExtractResult.write.mode(SaveMode.Overwrite).parquet(MetaConst.getDataPath(path))
  }


  override def train(df: DataFrame, path: String, params: Map[String, String]): Unit = {
    internal_train(df, params + ("path" -> path))
  }

  override def load(sparkSession: SparkSession, path: String, params: Map[String, String]): Any = {
    AnyRef
  }

  override def predict(sparkSession: SparkSession, _model: Any, name: String, params: Map[String, String]): UserDefinedFunction = {
    sparkSession.udf.register(name + "_phone", phoneExisted.f.asInstanceOf[String => Boolean])
    sparkSession.udf.register(name + "_email", emailExisted.f.asInstanceOf[String => Boolean])
    sparkSession.udf.register(name + "_qqwechat", qqwechatExisted.f.asInstanceOf[String => Boolean])
    sparkSession.udf.register(name + "_url", urlNumber.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_pic", picNumber.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_blank", blankPercent.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_chinese", chinesePercent.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_english", englishPercent.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_number", numberPercent.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_punctuation", punctuationPercent.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_mostchar", mostcharPercent.f.asInstanceOf[String => Int])
    sparkSession.udf.register(name + "_length", docLength.f.asInstanceOf[String => Int])
    phoneExisted
  }
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
  val EXISTED_PHONE_REGEX = Seq(
    """[01]{1}\d{2,3}-?\d{8}""",
    """(热线|电话|TEL|来电|短信|手机).{0,3}\d{3,}""",
    """400-?\d{3}-?\d{3}""",
    """\D1\d{2}[\- ]?\d{4}[\- ]??\d{4}""",
    """(热线|电话|TEL|来电|手机).{0,3}\d{3,}[- ]?\d{3,}[- ]?\d{3,}""",
    """\D1\d{2}\s*\D?\s*\d{4}\s*\D?\s*\d{4}""",
    """\D1\d{3}\s*\D?\s*\d{4}\s*\D?\s*\d{3}""")
  /**
   * 是否含有邮箱地址的正则表达式规则
   */
  val EXISTED_EMAIL_REGEX =
    Seq("""[\*a-zA-Z0-9-_]+@[a-zA-Z0-9]+\.[a-zA-Z]+""")
  /**
   * 是否还有qq微信号的正则表达式规则
   */
  val EXISTED_QQWECHAT_REGEX = Seq(
    """(加|Q|群|加我|扣扣)[^\w]{0,10}\d{5,}""",
    """(Q|群|加我|扣扣)[^\w]{0,10}(\d[\- ]?){5,}""",
    """(微信|v信|V)[^\w]{0,8}[a-zA-Z0-9]{5,}""")
  /**
   * url数量的正则表达式规则
   */
  val URL_NUMBER_REGEX = Seq("""[^@](\w[\w\-_]+\.){1,3}(com|cn|net|jp[^\w])/?""")
  /**
   * 图片数量的正则表达式规则
   */
  val PIC_NUMBER_REGEX = Seq("""img.dxycdn.com""")

  /**
   * 中文百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
   */
  val CHINESE_PERCENT_REGEX = Seq("""[\u4e00-\u9fa5]""")

  /**
   * 英文百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
   */
  val ENGLISH_PERCENT_REGEX = Seq("""[a-zA-Z]""")

  /**
   * 数字百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
   */
  val NUMBER_PERCENT_REGEX = Seq("""[0-9]""")

  /**
   * 标点百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
   */
  val PUNCTUATION_PERCENT_REGEX = Seq("""\p{P}""")

  /**
   * 出现最多字符百分比的正则表达式规则（去除html标签, 邮箱, url, 图片链接后）
   */
  val MOSTCHAR_PERCENT_REGEX = Seq("""\w+""")
}