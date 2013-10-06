package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: Dmytro Vynokurov
 * Date: 9/29/13
 * Time: 7:52 PM
 */
public class Crossword {
    private Cell[][] field;
    private List<String> words;

    public Crossword(Cell[][] field, List<String> words) {
        this.field = field;
        this.words = words;
    }

    public Crossword(Crossword other) {
        this.words = new ArrayList<>(other.words.size());
        for(String word: other.words){
            this.words.add(word);
        }

        this.field = new Cell[other.field.length][];
        for (int i = 0; i < other.field.length; i++) {
            this.field[i] = new Cell[other.field[i].length];
        }

        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                if (other.getCell(i, j) != null) {
                    this.field[i][j] = new Cell(other.getCell(i, j));
                } else {
                    this.field[i][j] = null;
                }
            }
        }
    }

    public Crossword(Crossword other,String withoutWord){
        this(other);
        words.remove(withoutWord);
    }

    public Cell getCell(int i, int j) {
        return field[i][j];
    }

    public void setCell(Cell cell, int i, int j) {
        field[i][j] = cell;
    }

    public List<String> getWords() {
        return words;
    }

    public int getHeight() {
        return field.length;
    }

    public int getWidth() {
        return field[0].length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Crossword\n");
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (field[i][j] == null) sb.append("\u25a0");
                else if (field[i][j].isEmpty()) sb.append("\u25a1");
                else sb.append(field[i][j].getValue());

                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
