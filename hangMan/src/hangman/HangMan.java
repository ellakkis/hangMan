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
        

    }
    
}
