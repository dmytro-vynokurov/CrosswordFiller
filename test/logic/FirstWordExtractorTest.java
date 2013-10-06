package logic;

import model.Cell;
import model.Crossword;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * User: Dmytro Vynokurov
 * Date: 10/6/13
 * Time: 1:55 PM
 */
public class FirstWordExtractorTest {

    @Test
    public void testIsFilledWhenNull(){
        Cell cell = null;
        FirstWordExtractor extractor = new FirstWordExtractor();

        assertFalse(extractor.isFilled(cell));
    }

    @Test
    public void testIsFilledWhenEmpty(){
        Cell cell = new Cell();
        FirstWordExtractor extractor = new FirstWordExtractor();

        assertFalse(extractor.isFilled(cell));
    }


    @Test
    public void testIsFilledWhenFilled(){
        Cell cell = new Cell('f');
        FirstWordExtractor extractor = new FirstWordExtractor();

        assertTrue(extractor.isFilled(cell));
    }

    @Test
    public void testIsNotFilledWhenNull(){
        Cell cell = null;
        FirstWordExtractor extractor = new FirstWordExtractor();

        assertFalse(extractor.isNotFilled(cell));
    }

    @Test
    public void testIsNotFilledWhenEmpty(){
        Cell cell = new Cell();
        FirstWordExtractor extractor = new FirstWordExtractor();

        assertTrue(extractor.isNotFilled(cell));
    }

    @Test
    public void testIsNotFilledWhenFilled(){
        Cell cell = new Cell('f');
        FirstWordExtractor extractor = new FirstWordExtractor();

        assertFalse(extractor.isNotFilled(cell));
    }


}
