
package hangman;

import java.util.Random;
import java.util.Scanner;


public class HangMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declare string array 'word' to hold the game words
        String[] words = {"write", "that","house", "banana", "dog", "school"};
        int triesCount = 0;
        
        //use random to select a random word from words array
        Random rand = new Random();
        int  randWord = rand.nextInt(3);
        
        //declare char array to hold the random word letters
        char[] wordLetters = new char[words[randWord].length()];
        
        boolean wordIsGuessed = false;
        
    }           
}