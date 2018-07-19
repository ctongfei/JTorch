package jtorch

/**
 * @author Tongfei Chen
 */
package object codegen {

  implicit class StringMatch(ctx: StringContext) {

    /** Enables the "sm" string interpolator. */
    object sm {

      def unapplySeq(s: String): Option[List[String]] = {
        val rx = ctx.parts.mkString("(.*)")
        rx.r.unapplySeq(s)
      }

    }

  }

}
