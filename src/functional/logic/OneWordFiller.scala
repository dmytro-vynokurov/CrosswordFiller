package functional.logic

import model.{Cell, Crossword}
import logic.declaration.{Direction, WordPosition}
import FirstWordExtractor._

/**
 * User: Dmytro Vynokurov
 * Date: 12/8/13
 * Time: 11:37 PM
 */
object OneWordFiller {
  def matchAllWordsForCrossword(crossword:Crossword):List[Crossword] = {
    val wordPosition = extractStartWord(crossword)
    val firstLetterCoordinates = (wordPosition.getStartRow,wordPosition.getStartColumn)
    val dir = wordPosition.getDirection

    for(
      word <- crossword.getWords.toArray(new Array[String](0)).toList
      if wordMatches(wordPosition,word)
    ) yield {
      val variant = new Crossword(crossword,word)
      fillCrossWordWithSingleWord(variant,firstLetterCoordinates,dir,word.toCharArray.toList)
      variant
    }
  }
  
  private def wordMatches(wordPosition:WordPosition,word:String):Boolean = {
    if(wordPosition.getLength!=word.length)return false
    
    val cells = wordPosition.getCells.toList
    val letters = word.toCharArray.toList

    cells.zip(letters).forall((zip:(Cell,Char)) => {val (cell,char)=zip; cell.isEmpty || cell.getValue == char})
  }
  
  private def fillCrossWordWithSingleWord(crossword:Crossword,cell:(Int,Int),direction:Direction,letters:List[Char]):Unit = {
    if(!letters.isEmpty){
      val newCell = new Cell(letters.head)
      val (row,col) = cell
      crossword.setCell(newCell,row,col)

      fillCrossWordWithSingleWord(crossword,nextCell(cell,direction),direction,letters.tail)
    }
  }
  
  private def nextCell(a:(Int,Int),direction:Direction):(Int,Int) ={
    if(direction==Direction.VERTICAL) (a._1+1,a._2)
    else (a._1,a._2+1)
  }
}
