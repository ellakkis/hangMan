/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ellakkis
 */
public class HangMan {
    public static String[] words;
    public static int triesCount = 0;
    public static boolean wordIsGuessed = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int wordGroupSelected = menu();
        switch (wordGroupSelected) {
                case 1: //fruits
                    words = new String[] {"Apple", "Banana", "Orange", "cherry", "grapes"};
                    break;
                case 2: //sports
                    words = new String[] {"tennis", "soccer", "football", "swimming", "vollyball"};
                    break;
                case 3: //animals
                    words = new String[] {"cat", "dog", "butterfly", "snake", "wolf"};
                    break;
                case 4: //food
                    
                    break;
                default:
                    break;
            }
        
        
        Random rand = new Random(System.currentTimeMillis());
        int  randWord = rand.nextInt(5);
        
        char[] wordLetters = new char[words[randWord].length()];
        
        
        

        do {
            switch (guessLetter(words[randWord], wordLetters)) {
                case 0: 
                    triesCount++;
                    System.out.println("number of tirals: " + triesCount + "\n");
                    break;
                case 1: 
                    System.out.println("number of tirals: " + triesCount + "\n");
                    break;
                case 2: 
                    System.out.println("number of tirals: " + triesCount + "\n");
                    break;
                case 3: 
                    wordIsGuessed = true;
                    System.out.println("\nBravoo...The word is \"" + words[randWord] + "\" You missed " 
                + (triesCount) + " time(s)");
                    System.exit(0);
            }
        } while (! wordIsGuessed);
  
    }

    public static int guessLetter(String word, char[] guessedLetters) {
        if(wordIsGuessed == false) {
            System.out.print("Enter a letter in word ");
        }
        
        if (! printWord(word, guessedLetters)) {
            return 3;  //returns 3 if all letters were guessed
        } 

        
        System.out.print(" > ");

        int emptyPosition = findEmptyPosition(guessedLetters);

        Scanner input = new Scanner(System.in);
        char userInput = input.nextLine().charAt(0);

        if (inGuessedLetters(userInput, guessedLetters)) {
            System.out.println(userInput + " is already in the word.");
            return 2; //returns 2 if already guessed letter was re-entered
        } else if (word.contains(String.valueOf(userInput))) {
            guessedLetters[emptyPosition] = userInput;
            return 1; //returns 1 if letter were entered 1st time  (don't count for a try)
        } else {
            System.out.println(userInput + " is not in the word.");
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
    
    /**
     * to print the word with the needed astrix
     * @param word
     * @param enteredLetters
     * @return 
     */
    public static boolean printWord(String word, char[] enteredLetters) {

        boolean starsPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (inGuessedLetters(letter, enteredLetters)){
                System.out.print(letter); 
            } else {
                System.out.print('*');
                starsPrinted = true;
            }
        }
        return starsPrinted;
    }
    
    /**
     * 
     * @param letter
     * @param enteredLetters
     * @return 
     */
    public static boolean inGuessedLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }    

    private static int menu() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("-- Word Group --");
        System.out.println(
            "  1) Fruits\n" +
            "  2) Sports\n" +
            "  3) Animals \n" +
            "  4) Food\n "
        );

        System.out.print("Select an option: ");
        int selection = input.nextInt();
        input.nextLine();
        return selection;
    }
}
