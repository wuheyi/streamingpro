package streaming.dsl

import streaming.common.ShellCommand
import _root_.streaming.dsl.parser.DSLSQLParser._
import streaming.dsl.template.TemplateMerge

/**
  * Created by allwefantasy on 27/8/2017.
  */
class DefineAdaptor(scriptSQLExecListener: ScriptSQLExecListener) extends DslAdaptor {
  override def parse(ctx: SqlContext): Unit = {
    var functionName = ""
    var methodBody = ""
    var option = Map[String, String]()
    (0 to ctx.getChildCount() - 1).foreach { tokenIndex =>
      ctx.getChild(tokenIndex) match {
        case s: FunctionNameContext =>
          functionName = s.getText
        case s: MethodBodyContext =>
          methodBody = cleanStr(s.getText)
        case s: ExpressionContext =>
          option += (cleanStr(s.identifier().getText) -> cleanStr(s.STRING().getText))
        case s: BooleanExpressionContext =>
          option += (cleanStr(s.expression().identifier().getText) -> cleanStr(s.expression().STRING().getText))
        case _ =>
      }
    }


    scriptSQLExecListener.sparkSession.sparkContext.parallelize(Seq())

    scriptSQLExecListener.sparkSession.udf.register(functionName, () => {

    })

    println("functionName : " + functionName)
    println("methodBody : " + methodBody)
    println("option : " + option.toString())
  }
}

