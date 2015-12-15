
object Implicits {
  implicit class AugmentedString(val s: String) extends AnyVal {
    def compact(): String = {
      s.trim.replaceAll("(\t|\\ |\n)+", " ")
    }
  }
}
