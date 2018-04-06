package kalva.learnings.ads.recursion

import scala.collection.mutable.ListBuffer

object WordBreak extends App {

  def printDictionaryWord(input: String, dictionary: List[String], result: ListBuffer[String]): String = {
    if (0 == input.length) {
      return null
    }
    for (i <- 0 until input.length) {
      var prefix = input.substring(0, i + 1)
      if (dictionary.contains(prefix) && !result.contains(prefix)) {
        result += prefix
      }
    }
    printDictionaryWord(input.substring(1, input.length), dictionary, result)
  }

  var buffer = ListBuffer[String]()
  printDictionaryWord("ilikesamsungmobile", List(
    "i", "like", "sam", "sung", "samsung", "mobile", "ice",
    "cream", "icecream", "man", "go", "mango"), buffer)
  println(buffer + "\n--------------------")
  buffer = ListBuffer[String]()

  printDictionaryWord("ilikeicecreamandmango", List(
    "i", "like", "sam", "sung", "samsung", "mobile", "ice",
    "cream", "icecream", "man", "go", "mango"), buffer)
  println(buffer + "\n--------------------")
}

