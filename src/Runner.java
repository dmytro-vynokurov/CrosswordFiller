import logic.CrosswordFiller;
import model.Crossword;

import java.util.List;

/**
 * User: Dmytro Vynokurov
 * Date: 10/5/13
 * Time: 10:40 PM
 */
public class Runner {
    public static void main(String[] args) {
        Crossword crossword = new Crossword(Util.DEFAULT_FIELD_1,Util.DEFAULT_WORDS_1);
        CrosswordFiller filler = new CrosswordFiller(crossword);

        List<Crossword> result = filler.fillCrossword();

        System.out.println(result.size());


    }
}
