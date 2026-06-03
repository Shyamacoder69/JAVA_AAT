package history;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Stores details of a single game played by the player.
 */
public class GameHistory {

    public enum Result {
        WIN, LOSS, DRAW
    }

    private String gameName;
    private Result result;
    private String details;
    private LocalDateTime playedAt;

    public GameHistory(String gameName, Result result, String details) {
        this.gameName = gameName;
        this.result = result;
        this.details = details;
        this.playedAt = LocalDateTime.now();
    }

    public String getGameName() {
        return gameName;
    }

    public Result getResult() {
        return result;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Game: " + gameName
                + " | Result: " + result
                + " | Time: " + playedAt.format(formatter)
                + " | Details: " + details;
    }
}