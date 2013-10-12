package logic;

import model.Crossword;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Dmytro Vynokurov
 * Date: 9/29/13
 * Time: 8:20 PM
 */
public class CrosswordFiller {
    private List<Crossword> variants;
    private int numberOfWords;

    public CrosswordFiller(Crossword crossword) {
        this.variants = new ArrayList<>();
        this.variants.add(crossword);
        this.numberOfWords = crossword.getWords().size();
    }

    public List<Crossword> fillCrossword(){
        for(int i=0;i<numberOfWords;i++){
            matchAllWordsForAllCrosswords();
        }

        return variants;
    }

    private void matchAllWordsForAllCrosswords(){
        OneWordFiller oneWordFiller = new OneWordFiller();
        List<Crossword> newVariants = new ArrayList<>();

        for(Crossword crossword: variants){
            oneWordFiller.matchAllWordsForCrossword(crossword,newVariants);
        }

        for(Crossword c:variants){
            System.out.println(c);
        }
        System.out.println("**********************************************");


        variants = newVariants;
    }


}
