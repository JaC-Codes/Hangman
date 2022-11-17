package net.jack.hangman;

import java.util.Scanner;

public class HangmanHandler {


    public boolean checkGuess(String answerWord, char userGuess, char[] replacer, int lives, Scanner scan) {
        boolean found = false;
        for (int i = 0; i < answerWord.length(); i++) {
            if (userGuess == answerWord.charAt(i)) {
                replacer[i] = userGuess;
                found = true;
            }
        }
        return found;
    }

    public void printDash(char[] replacer) {
        for (int i = 0; i < replacer.length; i++) {
            System.out.print(" " + replacer[i]);
        }
    }

    public void wrongAnswer(String answerWord, char userGuess, int lives) {
        if (userGuess != answerWord.charAt(0)) {
            lives--;
            System.out.println("Wrong! " + lives + " lives remain.");
        }
    }
}




