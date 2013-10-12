package model;

/**
 * User: Dmytro Vynokurov
 * Date: 9/29/13
 * Time: 7:52 PM
 */
public class Cell {
    private char value;
    private boolean empty;

    public Cell() {
        empty=true;
    }

    public Cell(char value) {
        this.value = value;
        empty=false;
    }

    public Cell(Cell other){
        this.value = other.value;
        this.empty = other.empty;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.empty=false;
        this.value = value;
    }

    public boolean isEmpty(){
        return empty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (empty != cell.empty) return false;
        if (value != cell.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result + (empty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{"+value+"}";
    }
}