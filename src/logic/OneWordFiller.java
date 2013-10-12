package logic;

import logic.declaration.Direction;
import logic.declaration.WordPosition;
import model.Cell;
import model.Crossword;

import java.util.List;

/**
 * User: Dmytro Vynokurov
 * Date: 10/6/13
 * Time: 12:12 PM
 */
public class OneWordFiller {

    public void matchAllWordsForCrossword(Crossword crossword, List<Crossword> newVariants) {
        WordPosition wordPosition = new FirstWordExtractor().extractStartWord(crossword);

        for(String word: crossword.getWords()){
            if (wordMatches(wordPosition,word)){
                newVariants.add(fillCrosswordWithSingleWord(crossword, wordPosition, word));
            }
        }
    }

    boolean wordMatches(WordPosition wordPosition, String word) {
        if (word.length() != wordPosition.getLength()) return false;

        Cell currentCell;
        for (int i = 0; i < word.length(); i++) {
            currentCell = wordPosition.getCell(i);
            if (currentCell == null) throw new IllegalStateException("Cell of a word cannot be null");
            if ((!currentCell.isEmpty()) && (currentCell.getValue() != word.charAt(i))) return false;
        }

        return true;
    }

    Crossword fillCrosswordWithSingleWord(Crossword crossword, WordPosition wordPosition, String word){
        Crossword copy = new Crossword(crossword,word);

        int currentRow = wordPosition.getStartRow();
        int currentColumn = wordPosition.getStartColumn();
        Direction direction = wordPosition.getDirection();
        Cell newCell;

        for(int i=0;i<wordPosition.getLength();i++){
            if(copy.getCell(currentRow,currentColumn).isEmpty()){
                newCell = new Cell(word.charAt(i));
                copy.setCell(newCell,currentRow,currentColumn);
            }
            currentRow = nextRow(currentRow, direction);
            currentColumn = nextColumn(currentColumn, direction);
        }
        return copy;
    }

    int nextColumn(int position, Direction direction){
        if(direction==Direction.HORIZONTAL) return position+1;
        else return position;
    }

    int nextRow(int position, Direction direction){
        if(direction==Direction.VERTICAL) return position+1;
        else return position;
    }
}
