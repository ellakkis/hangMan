/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Random;

/**
 *
 * @author ellakkis
 */
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
            " You missed " + (triesCount - findEmptyPosition(wordLetters)) +
            " time(s)");
  
    }

    private static int guessLetter(String word, char[] wordLetters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int findEmptyPosition(char[] wordLetters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
