package games;

import java.util.Random;
import java.util.Scanner;

import history.GameHistory;
import player.Player;

/**
 * Guess the Number game where player guesses a randomly generated number.
 */
public class GuessNumber implements Game {

    private final Random random;
    private final int minNumber;
    private final int maxNumber;
    private final int maxAttempts;

    public GuessNumber() {
        this.random = new Random();
        this.minNumber = 1;
        this.maxNumber = 10;
        this.maxAttempts = 3;
    }

    @Override
    public String getGameName() {
        return "Guess the Number";
    }

    @Override
    public GameHistory play(Player player, Scanner scanner) {
        int targetNumber = random.nextInt(maxNumber) + minNumber;
        int attemptsUsed = 0;
        boolean isGuessed = false;

        System.out.println("\n--- Guess the Number ---");
        System.out.println("Guess a number between " + minNumber + " and " + maxNumber + ".");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attemptsUsed < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = readInteger(scanner);
            attemptsUsed++;

            if (guess == targetNumber) {
                isGuessed = true;
                System.out.println("Correct! You guessed the number.");
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        GameHistory.Result result = isGuessed ? GameHistory.Result.WIN : GameHistory.Result.LOSS;

        if (!isGuessed) {
            System.out.println("You lost! The correct number was: " + targetNumber);
        }

        StringBuilder details = new StringBuilder();
        details.append("Target Number: ").append(targetNumber)
               .append(", Attempts Used: ").append(attemptsUsed)
               .append(", Result: ").append(result);

        return new GameHistory(getGameName(), result, details.toString());
    }

    private int readInteger(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid integer number.");
        }
    }
}