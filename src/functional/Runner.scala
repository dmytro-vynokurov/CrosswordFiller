package functional

import model.Crossword
import util.Util
import functional.logic.CrosswordFiller._

/**
 * User: Dmytro Vynokurov
 * Date: 12/8/13
 * Time: 5:02 PM
 */
object Runner {
  def main(args: Array[String]) {
//    val crossword: Crossword = new Crossword(Util.DEFAULT_FIELD_1, Util.DEFAULT_WORDS_1)
//    val crossword: Crossword = new Crossword(Util.DEFAULT_FIELD_3, Util.DEFAULT_WORDS_3, 'л')
    val crossword: Crossword = new Crossword(Util.DEFAULT_FIELD_3, Util.DEFAULT_WORDS_4, 'в')

    val result: List[Crossword] = fillCrossword(crossword)


    if (result.size > 0) {
      println(result.head)
    }
    else {
      println("Cannot fill the crossword")
    }
  }
}
