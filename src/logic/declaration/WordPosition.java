package logic.declaration;

import model.Cell;

import java.util.Arrays;

/**
 * User: Dmytro Vynokurov
 * Date: 9/29/13
 * Time: 8:36 PM
 */
public class WordPosition {
    private final Cell[] cells;
    private final int startColumn;
    private final int startRow;
    private final Direction direction;

    public WordPosition(Cell[] cells, int startColumn, int startRow, Direction direction) {
        this.cells = cells;
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.direction = direction;
    }

    public Cell[] getCells() {
        return cells;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getStartRow() {
        return startRow;
    }

    public Direction getDirection() {
        return direction;
    }

    public Cell getCell(int index){
        return cells[index];
    }

    public int getLength(){
        return cells.length;
    }

    @Override
    public String toString() {
        return "WordPosition{" +
                "cells=" + Arrays.toString(cells) +
                ", startColumn=" + startColumn +
                ", startRow=" + startRow +
                ", direction=" + direction +
                '}';
    }
}

