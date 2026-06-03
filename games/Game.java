package games;

import java.util.Scanner;
import player.Player;
import history.GameHistory;

/**
 * Common contract for all games in the project.
 * Demonstrates abstraction through an interface.
 */
public interface Game {
    String getGameName();
    GameHistory play(Player player, Scanner scanner);
}