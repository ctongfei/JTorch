package jtorch.codegen

import jtorch.codegen.classes._

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

  for (d <- defs) {
    d.name match {
      case sm"${jniClass}_${n}" =>
        val tm = TypeMap.get(jniClass)
        if (!(classes contains jniClass))
          classes += jniClass -> JClass(
            name = tm.javaType,
            packageName = "jtorch",
            baseClass = tm.jniType,
            interfaces = mutable.ArraySeq(),
            doc = "",
            methods = mutable.ArraySeq()
          )

      case sm"TH$n" =>

    }
  }

  val groups = defs groupBy {
    case d if !d.name.contains("_") => ""
    case d => d.name.substring(0, d.name.indexOf("_"))
  }

  for ((k, defs) <- groups) {
    val ks = tokenize(k)
    if (ks.size == 0) {

    }
    else if (ks(0) != "C" && ks(0) != "Cuda" && ks.last == "Storage")
      Storage.generate(k, defs)
    else {

    }
  }

  val bp = 0

}
