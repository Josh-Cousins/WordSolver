package wordsolver;

/**
 *
 * @author Josh
 */
public class WordSolver {

    public static perms perm = new perms();
    public static dictionary dict = new dictionary();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       dict.printValid(dict.getValidWords(perm.getChars(), dict.listFromDict()));
    }
    
}

