package net.jack.hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {


    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String answerWord = words[(int) (Math.random() * words.length)];

        char[] replacer = new char[answerWord.length()];
        for (int i = 0; i < answerWord.length(); i++) {
            replacer[i] = '-';
        }

        HangmanHandler handler = new HangmanHandler();
        int lives = 6;

        System.out.println("The word length is " + answerWord.length());
        while (lives != 0) {
            System.out.println();
            System.out.println(replacer);
            char userGuess = scan.nextLine().charAt(0);
            if (handler.checkGuess(answerWord, userGuess, replacer, lives, scan)) {
                handler.printDash(replacer);
            } else {
                lives--;
                System.out.println("Wrong! " + lives + " lives remain.");
            }
            if (lives == 0) {
                System.out.println("The word was " + answerWord);
                break;
            }
            if (Arrays.equals(replacer, answerWord.toCharArray())) {
                System.out.println();
                System.out.print("Well done you got the word!");
                scan.close();
                System.exit(0);
                break;
            }
        }

    }
}










