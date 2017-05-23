package lab4;

/* Anum Bhamani
 * CSC 2720
 */

/* This program is designed to find anagrams of words.
 * An anagram of a word is a permutation of its letters. So, two words that have the same letters would be anagrams.
 * The program reads the words from a user specified input file.
 * The output of the program prints out the words from the input file, here all the anagrams from the file are printed on the same line.
 * Also, they are stored in output.txt file which is built-in into the program.
 * Arrays and Vectors will be the primary data structures used for this program.
 */

/* This program invokes the class that finds the anagrams. 
 * The main method asks for the file name to be used.
 * It checks to make sure that the file is not empty and that there are no more than 50 words in the file.
 * It also ignores words that have more than 15 characters.
 * It then invokes the anagramConparasion class to check for anagrams and print out the output.
 * 
 */
import java.util.*;
import java.io.*;

public class Lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.println("Input file name: ");
		File input = new File(console.nextLine());
		Vector v = new Vector();
		try {
			console = new Scanner(input);
			int counter = 0;
			while(console.hasNextLine()) {
				String word = console.nextLine();
				String[] words = word.split(" ");
				for(int i = 0; i < words.length; i++) {
                    if(words[i].length() > 15){
                    	continue;
                    }
                    v.add(words[i]);
                    counter++;
                }
			}
			if(counter == 0 || counter > 50) {
	        	System.out.println("The input file cannot be empty or have more than 50 words.");
	            System.exit(0);
	        }
			 String temp = v.toString();
		     String [] a = temp.split(" ");
		     String [] b = temp.split(" ");
		     anagramComparasion.Signature(b);
		     anagramComparasion.ignorePunc(a);    
		     anagramComparasion.Compare(b, a);
		     System.out.println("These are anagrams:");
		     anagramComparasion.output(b, a);      
		     console.close();
		} catch(FileNotFoundException e) {   
		            System.out.println("The file cannot be found");   
		}

	}

}
