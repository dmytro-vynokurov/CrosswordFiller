package logic;

import logic.declaration.Direction;
import logic.declaration.WordPosition;
import model.Cell;
import model.Crossword;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: Dmytro Vynokurov
 * Date: 10/12/13
 * Time: 11:07 AM
 */
public class OneWordFillerTest {
    @Test
    public void testFillCrosswordWithSingleWordWhen2WordsFilled() throws Exception {
        Cell[][] fieldBefore = new Cell[][]{
                {new Cell('а'), new Cell('м'), new Cell('п'), new Cell('е'), new Cell('р')},
                {new Cell('р'), null, null, null, new Cell()},
                {new Cell('к'), null, null, null, new Cell()},
                {new Cell('а'), null, null, null, new Cell()},
                {new Cell('н'), new Cell(), new Cell(), new Cell(), new Cell()},
        };
        Cell[][] fieldAfter = new Cell[][]{
                {new Cell('а'), new Cell('м'), new Cell('п'), new Cell('е'), new Cell('р')},
                {new Cell('р'), null, null, null, new Cell('е')},
                {new Cell('к'), null, null, null, new Cell('д')},
                {new Cell('а'), null, null, null, new Cell('и')},
                {new Cell('н'), new Cell(), new Cell(), new Cell(), new Cell('с')},
        };
        List<String> wordsBefore = new ArrayList<>();
        wordsBefore.add("накос");
        wordsBefore.add("редис");
        List<String> wordsAfter= new ArrayList<>();
        wordsAfter.add("накос");

        Crossword crosswordBefore = new Crossword(fieldBefore, wordsBefore);
        Crossword crosswordExpected = new Crossword(fieldAfter,wordsAfter);

        Cell[] cells = new Cell[5];
        cells[0] = fieldBefore[0][4];
        cells[1] = fieldBefore[1][4];
        cells[2] = fieldBefore[2][4];
        cells[3] = fieldBefore[3][4];
        cells[4] = fieldBefore[4][4];

        WordPosition wordPosition = new WordPosition(cells,0,4,Direction.VERTICAL);

        Crossword actual = new OneWordFiller().fillCrosswordWithSingleWord(crosswordBefore,wordPosition,"редис");

        assertEquals(crosswordExpected, actual);
    }
}
