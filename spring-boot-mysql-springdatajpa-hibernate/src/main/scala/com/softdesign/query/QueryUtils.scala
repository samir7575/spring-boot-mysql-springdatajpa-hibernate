package com.softdesign.query

import StringContext._
import scala.util.matching.Regex

object UserDAOQuery {
  
  def removeCommentReplacer = { m: Regex.Match => "" }

  /**
   * A regexp to match the content of an SQL comment on a multiline string (hence the (?s) flag).
   */
  val SqlCommentRegexp = """(?s)\/\*([^\*]+)\*\/""".r
  
  /**
   * This implicit value class aims to add our custom String interpolator to the StringContext class.
   */
  implicit class QueryHelper(val sc: StringContext) extends AnyVal {

    import StringContext._
    
    private def removeComment(str:String):String=treatEscapes(SqlCommentRegexp.replaceAllIn(str, removeCommentReplacer))
    
    /**
     * A string interpolator that removes SQL comment from the input string
     */
    def sqlStrict(args: Any*): String = sc.standardInterpolator(removeComment, args)
    
    /**
     * A string interpolator that removes SQL comment and parses IFF condition from the input string.
     */
//    def sql(args: Any*): String = parseIff(sc.standardInterpolator(removeComment, args))

    
  }
}