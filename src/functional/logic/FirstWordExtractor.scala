package functional.logic

import model.{Cell, Crossword}
import logic.declaration.{Direction, WordPosition}
import scala.Option

/**
 * User: Dmytro Vynokurov
 * Date: 12/8/13
 * Time: 5:03 PM
 */
object FirstWordExtractor {
  import Side._

  def extractStartWord(crossword: Crossword): WordPosition= {
    tryCell(crossword,0,0).get
  }

  def tryCell(crossword: Crossword,row: Int,col: Int):Option[WordPosition] = {
    val isFilled = crossword.getCell(row,col)!=null && !crossword.getCell(row,col).isEmpty
    if(!isFilled) return tryNextCell(crossword,row,col)

    getSideWhereEmptyNeighbour(crossword,row,col,LEFT) match {
      case Some(side) if isFilled => Some(getWordPosition(crossword,row,col,side))
      case _ => tryNextCell(crossword,row,col)
    }
  }

  private def tryNextCell(crossword:Crossword,row:Int,col:Int):Option[WordPosition] =
    getNextCellToTry(crossword,row,col) match {
      case Some((x,y)) => tryCell(crossword,x,y)
      case None => None
    }
  
  private def getSideWhereEmptyNeighbour(crossword:Crossword,row:Int,col:Int,side:Side):Option[Side] = {
      val isNeighbourEmpty = getNeighbourCoordinates(crossword,row,col,side) match {
        case Some((x,y)) =>  {
          val neighbourCell = crossword.getCell(x,y)
          if(neighbourCell!=null && neighbourCell.isEmpty) true
          else false
        }
        case None => false
      }
      if (isNeighbourEmpty) Some(side)
      else next(side) match {
        case Some(nextSide:Side) => getSideWhereEmptyNeighbour(crossword,row,col,nextSide)
        case None => None
      }
  }

  private def getWordPosition(crossword:Crossword,row:Int,col:Int,side:Side):WordPosition = {
    val firstEdgeCell = findEdgeCell(crossword,row,col,side)
    val secondEdgeCell = findEdgeCell(crossword,row,col,reverse(side))
    val cells = extractCells(crossword,firstEdgeCell,secondEdgeCell)
    val topCell = getTopCell(firstEdgeCell,secondEdgeCell)

    new WordPosition(cells,topCell._1,topCell._2,toDirection(side))
  }
  
  private def findEdgeCell(crossword: Crossword, row: Int,col:Int,side:Side):(Int,Int)={
    getNeighbourCoordinates(crossword,row,col,side) match {
      case None => (row,col)
      case Some((x,y)) => if(crossword.getCell(x,y)==null) (row,col) else findEdgeCell(crossword,x,y,side)  
    }
  }

  private def getNeighbourCoordinates(crossword:Crossword,row:Int,col:Int,side:Side):Option[(Int,Int)] = {
    val r = crossword.getHeight-1
    val c = crossword.getWidth-1
    side match {
      case LEFT => if(col>0) Some((row,col-1)) else None
      case UP   => if(row>0) Some((row-1,col)) else None
      case RIGHT=> if(col<c) Some((row,col+1)) else None
      case DOWN => if(row<r) Some((row+1,col)) else None
    }
  }

  private def extractCells(crossword:Crossword,a:(Int,Int),b:(Int,Int)):Array[Cell] ={
    val sideFromAToB = getSideFromPointToPoint(a,b)
    val (first,second,side) = if(sideFromAToB==RIGHT || sideFromAToB==DOWN) (a,b,sideFromAToB) else (b,a,reverse(sideFromAToB))

    getCells(crossword,first,second,side).toArray
  }

  private def getCells(crossword:Crossword,a:(Int,Int),b:(Int,Int),side:Side):List[Cell] = {
    val cell =crossword.getCell(a._1,a._2)
    if(a!=b){
      val nextCellCoordinates = getNeighbourCoordinates(crossword,a._1,a._2,side).get
      val otherCells =getCells(crossword,nextCellCoordinates,b,side)
      cell::otherCells
    }else cell::Nil
  }

  private def getSideFromPointToPoint(a:(Int,Int),b:(Int,Int)):Side = {
    if(a._1==b._1) {
      if(a._2<b._2) RIGHT
      else LEFT
    }else{
      if(a._1<b._1) DOWN
      else UP
    }
  }

  private def getTopCell(a:(Int,Int),b:(Int,Int)):(Int,Int) = {
    if(a._1<b._1) a
    else if(a._2<b._2) a
    else b
  }

  def getNextCellToTry(crossword:Crossword,row:Int,col:Int):Option[(Int,Int)] = {
    val nextCol:Int = if(col == crossword.getWidth-1) 0 else col+1
    val nextRow:Int = if(nextCol != 0) row else if(row != crossword.getHeight-1) row+1 else return None

    Some(nextRow,nextCol)
  }
}


object Side extends Enumeration{
  type Side = Value
  val LEFT,UP,RIGHT,DOWN = Value

  def next(side: Side):Option[Side] = side match {
    case LEFT => Some(UP)
    case UP => Some(RIGHT)
    case RIGHT => Some(DOWN)
    case _ => None
  }

  def toDirection(side: Side):Direction = {
    if(side == LEFT || side == RIGHT) Direction.HORIZONTAL
    else Direction.VERTICAL
  }

  def reverse(side: Side)=side match{
    case LEFT=>RIGHT
    case RIGHT=>LEFT
    case UP=>DOWN
    case DOWN=>UP
  }
  
  def isHorizontal(side: Side) = side==LEFT || side==RIGHT
  
  def isVertical(side: Side) = !isHorizontal(side)
}