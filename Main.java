import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import games.Game;
import games.GuessNumber;
import games.StonePaperScissors;
import history.GameHistory;
import history.StatsManager;
import player.Player;

/**
 * Entry point for the Game Management System project.
 */
public class Main {

    private static Player player;
    private static final Vector<GameHistory> gameHistoryList = new Vector<GameHistory>();
    private static final StatsManager statsManager = new StatsManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game[] games = {
            new StonePaperScissors(),
            new GuessNumber()
        };

        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        registerPlayer(scanner);
                        break;
                    case 2:
                        playGameInLoop(games[0], scanner);
                        break;
                    case 3:
                        playGameInLoop(games[1], scanner);
                        break;
                    case 4:
                        viewPlayerProfile();
                        break;
                    case 5:
                        viewMatchHistory();
                        break;
                    case 6:
                        viewStatistics();
                        break;
                    case 7:
                        running = false;
                        System.out.println("Thank you for using Game Management System.");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid menu choice. Please select between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter only numeric menu choices.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== GAME MANAGEMENT SYSTEM =====");
        System.out.println("1. Register Player");
        System.out.println("2. Play Stone Paper Scissors");
        System.out.println("3. Play Guess Number");
        System.out.println("4. View Player Profile");
        System.out.println("5. View Match History");
        System.out.println("6. View Statistics");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void registerPlayer(Scanner scanner) {
        System.out.println("\n--- Register Player ---");

        try {
            System.out.print("Enter Player ID: ");
            Integer id = Integer.valueOf(scanner.nextLine());

            System.out.print("Enter Player Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            Integer age = Integer.valueOf(scanner.nextLine());

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            player = new Player(id, name, age, city);
            System.out.println("Player registered successfully.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Player ID and Age must be valid numbers.");
        }
    }

    private static void playGameInLoop(Game game, Scanner scanner) {
        if (player == null) {
            System.out.println("Please register a player first.");
            return;
        }

        boolean playAgain = true;

        while (playAgain) {
            try {
                GameHistory history = game.play(player, scanner);
                gameHistoryList.add(history);
                System.out.println("Game recorded in history successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }

            playAgain = askToContinue(scanner, game.getGameName());
        }
    }

    private static boolean askToContinue(Scanner scanner, String gameName) {
        while (true) {
            System.out.print("Do you want to play " + gameName + " again? (Y/N): ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("Y")) {
                return true;
            }
            if (choice.equals("N")) {
                return false;
            }

            System.out.println("Invalid choice. Please enter Y or N.");
        }
    }

    private static void viewPlayerProfile() {
        if (player == null) {
            System.out.println("No player registered yet.");
            return;
        }

        System.out.println("\n===== PLAYER PROFILE =====");
        System.out.println(player);
    }

    private static void viewMatchHistory() {
        System.out.println("\n===== MATCH HISTORY =====");

        if (gameHistoryList.isEmpty()) {
            System.out.println("No match history available.");
            return;
        }

        for (GameHistory history : gameHistoryList) {
            System.out.println(history);
        }
    }

    private static void viewStatistics() {
        System.out.println(statsManager.generateStatisticsReport(gameHistoryList));
    }

    public static void showAvailableGames(Game[] games) {
        System.out.println("Available Games: " + Arrays.toString(
                Arrays.stream(games).map(Game::getGameName).toArray()));
    }
}