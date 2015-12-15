

import org.scalatest.FlatSpec
import org.scalatest.OptionValues
import org.scalatest.Inside
import org.scalatest.Inspectors
import com.softdesign.query.UserDAOQuery._
import org.aspectj.weaver.ast.Test
/**
 * 
 */
object UserDAOQueryTest extends FlatSpec with OptionValues with Inside with Inspectors {
  
//  @Test
  def testSqlStrict(): Unit ={
    val s = sqlStrict"""/*fdfsdfksdllfsd */ no comment """
    assert(s==" no comment ")
  }
  
}