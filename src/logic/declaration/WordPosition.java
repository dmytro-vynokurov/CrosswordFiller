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

    public WordPosition(Cell[] cells, int startRow, int startColumn, Direction direction) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordPosition that = (WordPosition) o;

        if (startColumn != that.startColumn) return false;
        if (startRow != that.startRow) return false;
        if (!Arrays.equals(cells, that.cells)) return false;
        if (direction != that.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cells != null ? Arrays.hashCode(cells) : 0;
        result = 31 * result + startColumn;
        result = 31 * result + startRow;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
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

