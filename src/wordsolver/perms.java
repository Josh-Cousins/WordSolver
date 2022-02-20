package wordsolver;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class perms {
    
    public ArrayList<String> strings = new ArrayList<>();
    public Scanner in = new Scanner(System.in);
    
    //Gets the characters from the user
    public ArrayList<String> getChars()
    {
        System.out.println("Please enter characters:");
        return launchPerms(in.next());
    }
    
    //Takes in a String of characters and returns all permutations of those characters
    public ArrayList<String> launchPerms(String in)
    {
        //Creating arraylist
        ArrayList<String> perms = new ArrayList<>();
        
        //Printing prestring
        System.out.println("Generating "+calcPerms(in)+" permutations of String "+in);
        //
        for (int i = 0; i < in.length(); i++) {
            perms.addAll(generatePerms(in, "", i, strings));
        }
        
        return perms;
    }
    
    //Takes in a String and prints its total permutations
    public static int calcPerms(String in){
        int lastY = 0;
        int currentY = 0;
        for (int i = 1; i < in.length()+1; i++) {
            currentY = (lastY*i)+i;
            lastY = currentY;
        }
        return currentY;
    }
    
    static ArrayList<String> generatePerms(String str, String ans, int size, ArrayList<String> addTo)
    {
        // If string is empty
        if (str.length() == size) {
            System.out.println(ans);
            addTo.add(ans);
        }
  
        for (int i = 0; i < str.length(); i++) {
  
            // ith character of str
            char ch = str.charAt(i);
  
            // Rest of the string after excluding 
            // the ith character
            String ros = str.substring(0, i) + 
                         str.substring(i + 1);
  
            // Recurvise call
            generatePerms(ros, ans + ch, size, addTo);
        }
        return addTo;
    }
    
    public void printStrings(){
        for (String str: strings) {
            System.out.println(str);
        }
    }
}
