package com.guessnum;
import java.util.*;


public class NumberGuessGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int attempts = 0;
        int maxAttempts = 5;

        // Generate a random number
        int randomNumber = random.nextInt(max - min + 1) + min;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between " + min + " and " + max + ". Let's see if you can guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear invalid input
                continue;
            }

            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        System.out.println("Game over! You've used all your attempts.");
        System.out.println("The correct number was: " + randomNumber);
    }
}
