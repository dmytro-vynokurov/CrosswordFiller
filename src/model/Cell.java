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
    public String toString() {
        return "{"+value+"}";
    }
}