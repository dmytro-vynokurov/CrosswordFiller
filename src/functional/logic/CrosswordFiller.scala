package functional.logic

import model.Crossword
import OneWordFiller._

/**
 * User: Dmytro Vynokurov
 * Date: 12/9/13
 * Time: 12:15 AM
 */
object CrosswordFiller {

  def fillCrossword(crossword:Crossword):List[Crossword] = {
    nextGeneration(crossword::Nil,crossword.getWords.size)
  }

  private def nextGeneration(variants: List[Crossword],generationsLeft:Int):List[Crossword] = {
    if(generationsLeft==0) variants
    else {
      val newVariants = matchAllWordsForAllVariants(variants)
      for(variant<-variants)println(variant)
      println("*************************************")
      nextGeneration(newVariants,generationsLeft-1)
    }
  }

  private def matchAllWordsForAllVariants(variants:List[Crossword]):List[Crossword] = variants match {
    case x::xs => matchAllWordsForCrossword(x):::matchAllWordsForAllVariants(xs)
    case Nil => Nil
  }

}
