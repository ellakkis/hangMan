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
        
        System.out.println("\nThe word is " + words[randWord] + " You missed " 
                + (triesCount - findEmptyPosition(wordLetters)) + " time(s)");
  
    }

        public static int guessLetter(String word, char[] guessedLetters) {
        System.out.print("(Guess) Enter a letter in word ");
        
        if (! printWord(word, guessedLetters)) {
            return 3;  //returns 3 if all letters were guessed
        } 
        
        System.out.print(" > ");
        
        int emptyPosition = findEmptyPosition(guessedLetters);
        
        Scanner input = new Scanner(System.in);
        char userInput = input.nextLine().charAt(0);
        
        if (inGuessedLetters(userInput, guessedLetters)) { // a repeat guess
            System.out.println(userInput + " is already in the word");
            return 2; //returns 2 if already guessed letter was re-entered
        } else if (word.contains(String.valueOf(userInput))) {
            guessedLetters[emptyPosition] = userInput;
            return 1; //returns 1 if letter were entered 1st time (counts as try)
        } else {
            System.out.println(userInput + " is not in the word");
            return 0; //returns 0 if letter entered is not in the word (counts as try)
        }
    }

    /**
     * 
     * @param enteredLetters
     * @return 
     */
    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000'){
            i++;
        }
        return i;
    }
        
}
