package games;

import java.util.Random;
import java.util.Scanner;

import history.GameHistory;
import player.Player;

/**
 * Stone Paper Scissors game played between player and computer.
 */
public class StonePaperScissors implements Game {

    private final Random random;

    public StonePaperScissors() {
        this.random = new Random();
    }

    public enum Move {
        STONE, PAPER, SCISSORS;

        public static Move fromChoice(int choice) {
            switch (choice) {
                case 1:
                    return STONE;
                case 2:
                    return PAPER;
                case 3:
                    return SCISSORS;
                default:
                    throw new IllegalArgumentException("Invalid choice for move.");
            }
        }
    }

    @Override
    public String getGameName() {
        return "Stone Paper Scissors";
    }

    @Override
    public GameHistory play(Player player, Scanner scanner) {
        System.out.println("\n--- Stone Paper Scissors ---");
        System.out.println("1. Stone");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.print("Enter your choice: ");

        int choice = readInteger(scanner);
        Move playerMove = Move.fromChoice(choice);
        Move computerMove = Move.values()[random.nextInt(Move.values().length)];
        GameHistory.Result result = decideResult(playerMove, computerMove);

        StringBuilder details = new StringBuilder();
        details.append("Player Move: ").append(playerMove)
               .append(", Computer Move: ").append(computerMove)
               .append(", Result: ").append(result);

        System.out.println("You chose: " + playerMove);
        System.out.println("Computer chose: " + computerMove);
        System.out.println("Result: " + result);

        return new GameHistory(getGameName(), result, details.toString());
    }

    private int readInteger(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid numeric choice.");
        }
    }

    private GameHistory.Result decideResult(Move playerMove, Move computerMove) {
        if (playerMove == computerMove) {
            return GameHistory.Result.DRAW;
        }

        switch (playerMove) {
            case STONE:
                return (computerMove == Move.SCISSORS) ? GameHistory.Result.WIN : GameHistory.Result.LOSS;
            case PAPER:
                return (computerMove == Move.STONE) ? GameHistory.Result.WIN : GameHistory.Result.LOSS;
            case SCISSORS:
                return (computerMove == Move.PAPER) ? GameHistory.Result.WIN : GameHistory.Result.LOSS;
            default:
                return GameHistory.Result.DRAW;
        }
    }
}