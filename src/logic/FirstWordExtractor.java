package logic;

import logic.declaration.Direction;
import logic.declaration.WordPosition;
import model.Cell;
import model.Crossword;

/**
 * User: Dmytro Vynokurov
 * Date: 10/6/13
 * Time: 11:13 AM
 */
public class FirstWordExtractor {

    public WordPosition extractStartWord(Crossword crossword) {
        for (int i = 0; i < crossword.getHeight(); i++) {
            for (int j = 0; j < crossword.getWidth(); j++) {
                Cell currentCell = crossword.getCell(i, j);
                if (isFilled(currentCell)) {
                    if (i > 0) {
                        Cell upCell = crossword.getCell(i - 1, j);
                        if (isNotFilled(upCell)) return extractVertical(crossword,i, j);
                    }
                    if (j > 0) {
                        Cell leftCell = crossword.getCell(i, j - 1);
                        if (isNotFilled(leftCell)) return extractHorizontal(crossword,i, j);
                    }
                    if (i < crossword.getHeight() - 1) {
                        Cell downCell = crossword.getCell(i + 1, j);
                        if (isNotFilled(downCell)) return extractVertical(crossword,i, j);
                    }
                    if (j < crossword.getWidth() - 1) {
                        Cell rightCell = crossword.getCell(i, j + 1);
                        if (isNotFilled(rightCell)) return extractHorizontal(crossword,i, j);
                    }
                }
            }
        }
        throw new IllegalStateException("Cannot extract word");
    }

    boolean isNotFilled(Cell currentCell) {
        return (currentCell != null) && (currentCell.isEmpty());
    }

    boolean isFilled(Cell currentCell) {
        return (currentCell != null) && (!currentCell.isEmpty());
    }

    WordPosition extractHorizontal(Crossword crossword,int i, int j) {
        int left = j;
        while ((left>=0)&&(crossword.getCell(i, left) != null)) left--;
        left++;

        int right = j;
        while ((right<=crossword.getWidth()-1)&&(crossword.getCell(i, right) != null)) right++;
        right--;

        return extractHorizontalInRange(crossword,i, left, right);
    }

    WordPosition extractHorizontalInRange(Crossword crossword,int row, int left, int right) {
        int size = right - left + 1;
        Cell[] result = new Cell[size];

        for (int i = 0; i < size; i++) {
            result[i] = crossword.getCell(row, left + i);
        }

        return new WordPosition(result, row, left, Direction.HORIZONTAL);
    }

    WordPosition extractVertical(Crossword crossword,int i, int j) {
        int top = i;
        while ((top>=0)&&(crossword.getCell(top, j) != null)) top--;
        top++;

        int bottom = i;
        while ((bottom<=crossword.getHeight()-1)&&(crossword.getCell(bottom, j) != null)) bottom++;
        bottom--;

        return extractVerticalInRange(crossword,top, bottom, j);
    }

    WordPosition extractVerticalInRange(Crossword crossword,int top, int bottom, int column) {
        int size = bottom - top + 1;
        Cell[] result = new Cell[size];

        for (int i = 0; i < size; i++) {
            result[i] = crossword.getCell(top + i, column);
        }

        return new WordPosition(result, top, column, Direction.VERTICAL);
    }
}
