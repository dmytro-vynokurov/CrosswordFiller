package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: Dmytro Vynokurov
 * Date: 10/6/13
 * Time: 2:00 PM
 */
public class CellTest {

    @Test
    public void testIsEmptyWhenEmpty(){
        Cell cell = new Cell();
        assertTrue(cell.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty(){
        Cell cell = new Cell('f');
        assertFalse(cell.isEmpty());
    }


}
