package wordsolver;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class dictionary {
    
    public static File dict = new File("words.txt");
    
    //Reads the text file and return an ArrayList<String> of all words
    public ArrayList<String> listFromDict(){
        try{
            ArrayList<String> readStrings = new ArrayList<>();
            Scanner in = new Scanner(dict);
            while(in.hasNextLine()){
                readStrings.add(in.nextLine());
            }
            in.close();
            return readStrings;
        }
        catch(Exception e){System.out.println(e.toString());}
        return null;
    }
    
    //Takes in two ArrayLists and checks if an item is present in both,
    //if so it adds that item to a new arraylist and returns it
    public ArrayList<String> getValidWords(ArrayList<String> perms, ArrayList<String> dict){
        ArrayList<String> validWords = new ArrayList<>();
        for (int i = 0; i < perms.size(); i++) {
            if (dict.contains(perms.get(i))) {
                if (!validWords.contains(perms.get(i))) {
                    validWords.add(perms.get(i));
                }
            }
        }
        return validWords;
    }
    
    //Prints the valid words to console based on their size
    public void printValid(ArrayList<String> valid){
        System.out.println("Found "+valid.size()+" Valid Words");
        for (String str: valid) {
            System.out.println(str);
        }
    }
    
    //Turns all text in the dictionary file to lowercase for easier matching
    public void allLower(){
        ArrayList<String> list = listFromDict();
        ArrayList<String> newList = new ArrayList<>();
        for (String str: list) {
            newList.add(str.toLowerCase());
        }
        try{
            FileWriter writer = new FileWriter(dict, false);
            for (String str: newList) {
                writer.write(str+"\n");
            }
            writer.close();
        }
        catch(Exception e){System.out.println(e.toString());}
    }
}
