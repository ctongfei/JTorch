package jtorch.codegen

import scala.io._

/**
 * @author Tongfei Chen
 */
object Generate extends App {

  trait CDef

  case class CArgument(
                      cType: String,
                      name: String
                      )

  case class CFunction(
                        returnCType: String,
                        structName: String,
                        functionName: String,
                        args: Seq[CArgument]
                      ) extends CDef

  case class CConst(
                   cType: String,
                   name: String
                   ) extends CDef

  val rxDef = "extern (.*)((TH|_TH)\\w*) ?(\\(.*\\)|$)".r
  val rxArgs = "(const \\w* |\\w* \\*|\\w*\\* |\\w* |\\.\\.\\.|\\w*)(.*)".r

  def parse(s: String): CDef = {
    val rxDef(returnType, thName, _, argsDef) = s.replace('\n', ' ')

    if (argsDef == "")
      CConst(returnType.trim, thName.trim)

    else {
      val nameTokens = thName.split("_")
      val structName = if (nameTokens.length == 1) "" else nameTokens(0)
      val functionName = if (nameTokens.length == 1) nameTokens(0) else nameTokens.tail.mkString("_")
      val argDefs = argsDef.substring(1, argsDef.length - 1).trim.split(",").map(_.trim)
      val args = argDefs map { argDef =>
        val rxArgs(argType, argName) = argDef
        CArgument(argType.trim, argName.trim)
      }
      CFunction(returnType.trim, structName.trim, functionName.trim, args)
    }
  }

  def functionsFromHeader(fn: String) = {
    val contents = Source.fromFile(fn).mkString
    val funcDefs = contents.split(";").map(_.trim).filter(_.startsWith("extern"))
    funcDefs map parse
  }

  // maps C types to Java types
  val primitiveTypeMap = Map(
    "void" -> "void",
    "char" -> "byte",
    "int8_t" -> "byte",
    "uint8_t" -> "short", //TODO: ?
    "char *" -> "String",
    "short" -> "short",
    "int16_t" -> "short",
    "int" -> "int",
    "int32_t" -> "int",
    "long" -> "long",
    "int64_t" -> "long",
    "size_t" -> "long",
    "ptrdiff_t" -> "long",
    "bool" -> "boolean",
    "float" -> "float",
    "double" -> "double"
  )

  val functions = functionsFromHeader("include-swig/torch-preprocessed.h")

  val types = functions.view.flatMap {
    case CConst(t, _) => Seq(t)
    case CFunction(rt, _, _, args) => rt +: args.map(_.cType)
  }.toSet.toSeq.sorted

  val bp = 0

}
