import model.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Dmytro Vynokurov
 * Date: 9/29/13
 * Time: 7:55 PM
 */
public class Util {
    public static final Cell[][] DEFAULT_FIELD_1 = new Cell[][]{
            {new Cell(), new Cell(), new Cell('к'), new Cell(), new Cell()},
            {new Cell(), null, null, null, new Cell()},
            {new Cell(), null, null, null, new Cell()},
            {new Cell(), null, null, null, new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
    };
    public static final List<String> DEFAULT_WORDS_1 = new ArrayList<>();
    static{
        DEFAULT_WORDS_1.add("ампер");
        DEFAULT_WORDS_1.add("аркан");
        DEFAULT_WORDS_1.add("накос");
        DEFAULT_WORDS_1.add("редис");
    }
}
