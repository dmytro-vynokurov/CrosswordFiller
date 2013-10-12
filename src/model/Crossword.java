package model;

import java.util.ArrayList;
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

    public Crossword(String[] field,List<String> words,char symbol){
        this.field = new Cell[field.length][];
        for(int i=0;i<field.length;i++){
            this.field[i]=new Cell[field[0].length()];
        }

        for(int i=0;i<this.field.length;i++){
            for(int j=0;j<this.field[0].length;j++){
                char code = field[i].charAt(j);
                if(code=='0'){
                    this.field[i][j]=null;
                }else if(code=='1'){
                    this.field[i][j]=new Cell();
                }else{
                    this.field[i][j]=new Cell(symbol);
                }
            }
        }

        this.words=words;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Crossword crossword = (Crossword) o;

        if (words != null ? !words.equals(crossword.words) : crossword.words != null) return false;
        if(this.field==null && crossword.field==null) return true;
        if(this.field!=null && crossword.field==null) return false;
        if(this.field==null && crossword.field!=null) return false;
        if(this.getHeight()!=crossword.getHeight())return false;
        if(this.getWidth()!=crossword.getWidth())return false;

        Cell thisCell,otherCell;
        for(int i=0;i<this.getHeight();i++){
            for(int j=0;j<this.getWidth();j++){
                thisCell=this.field[i][j];
                otherCell=crossword.field[i][j];
                if((thisCell != otherCell) && (!thisCell.equals(otherCell)))return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return words != null ? words.hashCode() : 0;
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
        for(String word: words) {
            sb.append(word);
            sb.append("\n");
        }
        return sb.toString();
    }
}
