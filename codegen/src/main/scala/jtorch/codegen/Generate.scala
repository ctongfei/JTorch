package jtorch.codegen

import scala.collection._

/**
 * @author Tongfei Chen
 */
object Generate extends App {

  val defs = ParseJNI.defs.filter(_.name.startsWith("TH"))

  def tokenize(s: String) = {
    val is = (0 until s.length).filter(s(_).isUpper) :+ s.length
    val ts = (0 until is.length - 1).map(i => s.substring(is(i), is(i + 1)))
    ts
  }

  val classes = mutable.HashMap[String, JClass]()

  classes += "Torch" -> JClass(
    name = "Torch",
    packageName = "jtorch",
    baseClass = "",
    interfaces = mutable.ArrayBuffer(),
    doc = "",
    methods = mutable.ArrayBuffer()
  )

  for (d <- defs) {
    d.name match {
      case sm"${jniStructName}_${name}" =>
        val tm = TypeMap.get(jniStructName)
        if (!(classes contains jniStructName))
          classes += jniStructName -> JClass(
            name = tm.javaType,
            packageName = "jtorch",
            baseClass = tm.jniType,
            interfaces = mutable.ArrayBuffer(),
            doc = "",
            methods = mutable.ArrayBuffer()
          )
        val cls = classes(jniStructName)
        cls.methods += CodeGenerator.method(d)


      case sm"TH$name" =>

    }
  }



  val bp = 0

}
