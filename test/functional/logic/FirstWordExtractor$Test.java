package functional.logic;

import logic.declaration.Direction;
import logic.declaration.WordPosition;
import model.Cell;
import model.Crossword;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import functional.logic.FirstWordExtractor.*;


/**
 * User: Dmytro Vynokurov
 * Date: 12/9/13
 * Time: 9:52 PM
 */
public class FirstWordExtractor$Test {
    @Test
    public void testExtractStartWordWhenLetterOnTopSquareEdge(){
        Cell[][] field = new Cell[][]{
                {new Cell(), new Cell(), new Cell('к'), new Cell(), new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
        };
        List<String> words = new ArrayList<>();
        words.add("ампер");
        words.add("аркан");
        words.add("накос");
        words.add("редис");
        Crossword crossword = new Crossword(field,words);

        WordPosition expected = new WordPosition(field[0],0,0, Direction.HORIZONTAL);

        WordPosition actual = FirstWordExtractor.extractStartWord(crossword);

        assertEquals(expected,actual);
    }

    @Test
    public void testExtractStartWordWhenLetterOnBottomSquareEdge(){
        Cell[][] field = new Cell[][]{
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), new Cell(), new Cell('к'), new Cell(), new Cell()},
        };
        List<String> words = new ArrayList<>();
        words.add("ампер");
        words.add("аркан");
        words.add("накос");
        words.add("редис");
        Crossword crossword = new Crossword(field,words);

        WordPosition expected = new WordPosition(field[4],4,0, Direction.HORIZONTAL);

        WordPosition actual = FirstWordExtractor.extractStartWord(crossword);

        assertEquals(expected,actual);
    }

    @Test
    public void testExtractStartWordWhenLetterOnLeftSquareEdge(){
        Cell[][] field = new Cell[][]{
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell('к'), null, null, null, new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
        };
        List<String> words = new ArrayList<>();
        words.add("ампер");
        words.add("аркан");
        words.add("накос");
        words.add("редис");
        Crossword crossword = new Crossword(field,words);

        Cell[] cells = new Cell[5];
        cells[0] = field[0][0];
        cells[1] = field[1][0];
        cells[2] = field[2][0];
        cells[3] = field[3][0];
        cells[4] = field[4][0];

        WordPosition expected = new WordPosition(cells,0,0, Direction.VERTICAL);

        WordPosition actual = FirstWordExtractor.extractStartWord(crossword);

        assertEquals(expected,actual);
    }

    @Test
    public void testExtractStartWordWhenLetterOnRightSquareEdge(){
        Cell[][] field = new Cell[][]{
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), null, null, null, new Cell('к')},
                {new Cell(), null, null, null, new Cell()},
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
        };
        List<String> words = new ArrayList<>();
        words.add("ампер");
        words.add("аркан");
        words.add("накос");
        words.add("редис");
        Crossword crossword = new Crossword(field,words);

        Cell[] cells = new Cell[5];
        cells[0] = field[0][4];
        cells[1] = field[1][4];
        cells[2] = field[2][4];
        cells[3] = field[3][4];
        cells[4] = field[4][4];

        WordPosition expected = new WordPosition(cells,0,4, Direction.VERTICAL);

        WordPosition actual = FirstWordExtractor.extractStartWord(crossword);

        assertEquals(expected,actual);
    }

    @Test
    public void testExtractStartWordWhen2WordsFilled(){
        Cell[][] field = new Cell[][]{
                {new Cell('а'), new Cell('м'), new Cell('п'), new Cell('е'), new Cell('р')},
                {new Cell('р'), null, null, null, new Cell()},
                {new Cell('к'), null, null, null, new Cell()},
                {new Cell('а'), null, null, null, new Cell()},
                {new Cell('н'), new Cell(), new Cell(), new Cell(), new Cell()},
        };
        List<String> words = new ArrayList<>();
        words.add("накос");
        words.add("редис");
        Crossword crossword = new Crossword(field,words);

        Cell[] cells = new Cell[5];
        cells[0] = field[0][4];
        cells[1] = field[1][4];
        cells[2] = field[2][4];
        cells[3] = field[3][4];
        cells[4] = field[4][4];

        WordPosition expected = new WordPosition(cells,0,4, Direction.VERTICAL);

        WordPosition actual = FirstWordExtractor.extractStartWord(crossword);

        assertEquals(expected,actual);
    }

}
