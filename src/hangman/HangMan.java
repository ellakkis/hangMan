
package hangman;

import java.util.Random;
import java.util.Scanner;


public class HangMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declare string array 'word' to hold the game words
        String[] words = {"house", "banana", "dog", "school"};
        int triesCount = 0;
        
        //use random to select a random word from words array
        Random rand = new Random();
        int  randWord = rand.nextInt(3);
        
        //declare char array to hold the random word letters
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
        } while (!wordIsGuessed);
        
        System.out.println("The word is " + words[randWord] +
            " You missed " + (triesCount -findEmptyPosition(wordLetters)) +
            " time(s)");
    }

    /**
     * guessLetter method to evaluate the guessed letter and return a case value 
     * to switch statement
     * @param word
     * @param guessedLetters
     * @return 
     */
    public static int guessLetter(String word, char[] guessedLetters)    {
        System.out.print("(Guess) Enter a letter in word ");
        
        if (! printWord(word, guessedLetters)) {
            return 3;  //returns 3 if all letters were guessed
        } 
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(guessedLetters);
        char userInput = input.nextLine().charAt(0);
        
        if (inGuessedLetters(userInput, guessedLetters)) {
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

        
        
}
