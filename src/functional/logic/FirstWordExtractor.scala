package functional.logic

import model.{Cell, Crossword}
import logic.declaration.WordPosition
import scala.Option

/**
 * User: Dmytro Vynokurov
 * Date: 12/8/13
 * Time: 5:03 PM
 */
object FirstWordExtractor {

  private object Side extends Enumeration{
    type Side = Value
    val LEFT,UP,RIGHT,DOWN = Value
  }
  import Side._

  def extractStartWord(crossword: Crossword): Option[WordPosition]= {
    tryCell(crossword,0,0)
  }

  def tryCell(crossword: Crossword,row: Int,col: Int):Option[WordPosition] = {
    getSideWhereEmptyNeighbour(crossword,row,col,LEFT) match {
      case Some(side) =>
      case None => None
    }
  }
  
  private def getSideWhereEmptyNeighbour(crossword:Crossword,row:Int,col:Int,side:Side):Option[Side] = {
      val isCellEmpty = getNeighbourCoordinates(crossword,(row,col),side) match {
        case Some((x,y)) =>  {
          val cellValue:Cell = crossword.getCell(x,y)
          if(cellValue==null || cellValue.isEmpty) false
          else true
        }
        case None => false
      }
      if (isCellEmpty) Some(side)
      else next(side) match {
        case Some(nextSide:Side) => getSideWhereEmptyNeighbour(crossword,row,col,nextSide)
        case None => None
      }
  }

  private def getWordPosition(crossword:Crossword,row:Int,col:Int,side:Side) = {

  }

  private def next(side: Side):Option[Side] = side match {
    case LEFT => Some(UP)
    case UP => Some(RIGHT)
    case RIGHT => Some(DOWN)
    case _ => None
  }

  private def getNeighbourCoordinates(crossword:Crossword,coordinates:(Int,Int),side:Side):Option[(Int,Int)] = {
    val r = crossword.getHeight-1
    val c = crossword.getWidth-1
    side match {
      case LEFT => if(coordinates._2>0) Some((coordinates._1,coordinates._2-1)) else None
      case UP   => if(coordinates._1>0) Some((coordinates._1-1,coordinates._2)) else None
      case RIGHT=> if(coordinates._2<c) Some((coordinates._1,coordinates._2+1)) else None
      case DOWN => if(coordinates._1<r) Some((coordinates._1+1,coordinates._2)) else None
    }
  }
}
