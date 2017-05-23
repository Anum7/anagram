package lab4;

/*package anagram;

public class anagramComparasion {

}*/

/* Anum Bhamani
 * CSC 2720
 */

/* This reads the input file and checks for anagrams.
 * extends the anagram class.
 */
import java.util.*;
import java.io.*;

public class anagramComparasion extends Lab4{
	/* Algorithm:
	 * This method takes in a string array.
	 * It checks to make sure that each word is not longer than 15 characters.
	 * It makes sure that for the output file the punctuation stays the same (replaceAll).
	 * It then creates a char array for each word and sorts it to create a "signature" for the word.
	 * This would help determine if it is an anagram.
	 */
	public static void Signature(String [] a){
        for(int i = 0; i < a.length; i++){
        	if(a[i].length() > 15){
        		continue;
            }
            a[i] = a[i].replaceAll("\\p{Punct}+", "");
            a[i] = a[i].replaceAll("\\d", "");
            a[i] = a[i].toLowerCase();
            char[] word = a[i].toCharArray();
            Arrays.sort(word);
            String result = new String (word);
            a[i] = result;
        }
    }
	/* The words of the input array are sorted by letter.*/
    
	/* This method takes in a string and ignores the punctuation and uppercase and lowercase for each word to make sure that the anagram can be found.*/
	public static void ignorePunc(String [] a){
        for(int i = 0; i < a.length; i++){
        	a[i] = a[i].replace(",", "");
        	a[i] = a[i].replace("[", "");
        	a[i] = a[i].replace("]", "");
        }
    }
	/*The array then has the same words without the punctuation.*/
	
	/*This method takes in two arrays to compare them for anagrams.
	 * sets them equal and sorts them by their signatures
	 */
    public static void Compare(String [] a, String [] b){
    	for(int i = 0; i < a.length -1; i++){
    		for(int j = 1; j < a.length; j++){
    			if(a[i].equals(a[j])){
                    if(i == j){
                        continue;
                    }
                    String s = a[i + 1];
                    a[i + 1] = a[j];
                    a[j] = s;
                    s = b[i + 1];
                    b[i + 1] = b[j];
                    b[j] = s;
                }
            }
        }
    }
    
    /* This method outputs the anagrams from the input file on the same line and also stores them as a output.txt.
     * creates the file and checks for exceptions
     */
    public static void output(String [] a, String [] b){
       try{
            FileWriter file = new FileWriter("output.txt");
            PrintWriter print = new PrintWriter(file);
            int i = 0;
            for(i = 0; i < a.length - 1; i++){
                if(!a[i].matches(a[i + 1])){
                    print.println(b[i]);
                    System.out.println(b[i]);
                    continue;
                }
                print.print(b[i] + " ");
                System.out.print(b[i] + " ");
            }
            print.println(b[i]);
            System.out.println(b[i]);
            print.close();
        }    
        catch(IOException e){
        	System.out.println(e);
        }
    }
    
    /*prints the output*/
    public static void Print(String [] a){
    	for(int i = 0; i < a.length; i++){
    		System.out.print(a[i] + " ");
            }        
        System.out.println();
    }


}



