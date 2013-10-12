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
    public static final String[] DEFAULT_FIELD_2 = new String[]{
            "11211",
            "10001",
            "10001",
            "10001",
            "11111"
    };
    public static final List<String> DEFAULT_WORDS_2 = new ArrayList<>();
    static{
        DEFAULT_WORDS_2.add("ампер");
        DEFAULT_WORDS_2.add("аркан");
        DEFAULT_WORDS_2.add("накос");
        DEFAULT_WORDS_2.add("редис");
    }
    public static final String[] DEFAULT_FIELD_3 = new String[]{
            "11211011111011111",
            "10001010001010001",
            "10001010001010001",
            "10011111011111001",
            "11111011111011111",
            "00010001010001000",
            "11111011111011111",
            "10011111011111001",
            "10001010001010001",
            "10001010001010001",
            "11111011111011111"
    };
    public static final List<String> DEFAULT_WORDS_3 = new ArrayList<>();
    static{
        DEFAULT_WORDS_3.add("аванс");
        DEFAULT_WORDS_3.add("ловец");
        DEFAULT_WORDS_3.add("вклад");
        DEFAULT_WORDS_3.add("сычуг");
        DEFAULT_WORDS_3.add("аршин");
        DEFAULT_WORDS_3.add("недуг");
        DEFAULT_WORDS_3.add("гидра");
        DEFAULT_WORDS_3.add("танец");
        DEFAULT_WORDS_3.add("асана");
        DEFAULT_WORDS_3.add("непал");
        DEFAULT_WORDS_3.add("дичок");
        DEFAULT_WORDS_3.add("финал");
        DEFAULT_WORDS_3.add("аскет");
        DEFAULT_WORDS_3.add("норит");
        DEFAULT_WORDS_3.add("дозор");
        DEFAULT_WORDS_3.add("фронт");
        DEFAULT_WORDS_3.add("астра");
        DEFAULT_WORDS_3.add("норма");
        DEFAULT_WORDS_3.add("дофин");
        DEFAULT_WORDS_3.add("шатун");
        DEFAULT_WORDS_3.add("багаж");
        DEFAULT_WORDS_3.add("омега");
        DEFAULT_WORDS_3.add("жилка");
        DEFAULT_WORDS_3.add("шишка");
        DEFAULT_WORDS_3.add("батог");
        DEFAULT_WORDS_3.add("оникс");
        DEFAULT_WORDS_3.add("инжир");
        DEFAULT_WORDS_3.add("экран");
        DEFAULT_WORDS_3.add("валки");
        DEFAULT_WORDS_3.add("слеза");
        DEFAULT_WORDS_3.add("кизил");
        DEFAULT_WORDS_3.add("эрика");
    }
    public static final List<String> DEFAULT_WORDS_4 = new ArrayList<>();
    static{
        DEFAULT_WORDS_4.add("аршин");
        DEFAULT_WORDS_4.add("асана");
        DEFAULT_WORDS_4.add("аскет");
        DEFAULT_WORDS_4.add("афина");
        DEFAULT_WORDS_4.add("голос");
        DEFAULT_WORDS_4.add("грамм");
        DEFAULT_WORDS_4.add("земля");
        DEFAULT_WORDS_4.add("знамя");
        DEFAULT_WORDS_4.add("игрок");
        DEFAULT_WORDS_4.add("камея");
        DEFAULT_WORDS_4.add("кларк");
        DEFAULT_WORDS_4.add("кнехт");
        DEFAULT_WORDS_4.add("ковка");
        DEFAULT_WORDS_4.add("кредо");
        DEFAULT_WORDS_4.add("милок");
        DEFAULT_WORDS_4.add("намин");
        DEFAULT_WORDS_4.add("огрех");
        DEFAULT_WORDS_4.add("опора");
        DEFAULT_WORDS_4.add("сваха");
        DEFAULT_WORDS_4.add("свора");
        DEFAULT_WORDS_4.add("склон");
        DEFAULT_WORDS_4.add("сырок");
        DEFAULT_WORDS_4.add("треух");
        DEFAULT_WORDS_4.add("хиляк");
        DEFAULT_WORDS_4.add("хинди");
        DEFAULT_WORDS_4.add("шевро");
        DEFAULT_WORDS_4.add("шуйца");
        DEFAULT_WORDS_4.add("юкола");
        DEFAULT_WORDS_4.add("юферс");
        DEFAULT_WORDS_4.add("яичко");
        DEFAULT_WORDS_4.add("яство");
        DEFAULT_WORDS_4.add("яхонт");
    }
}
