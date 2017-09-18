
package hangman;

import java.util.Random;
import java.util.Scanner;


public class HangMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] words = {"house", "banana", "dog", "school"};
        int triesCount = 0;
        Random rand = new Random();
        int  randWord = rand.nextInt(3);
        
        char[] wordLetters = new char[words[randWord].length()];
        
        boolean wordIsGuessed = false;
        do {
            switch (guessLetter(words[randWord], wordLetters)) {
                case 0: 
                    triesCount++;
                    break;
                case 1: 
                    triesCount++;
                    break;
                case 2: 
                    break;
                case 3: 
                    wordIsGuessed = true;
                    break;
            }
        } while (! wordIsGuessed);
        
        System.out.println("\nThe word is " + words[randWord] +
            " You missed " + (triesCount -findEmptyPosition(wordLetters)) +
            " time(s)");
    }

    
        
        
}
