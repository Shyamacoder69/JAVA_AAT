package history;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Generates overall and game-wise statistics using collections.
 */
public class StatsManager {

    public String generateStatisticsReport(Vector<GameHistory> gameHistoryList) {
        StringBuilder report = new StringBuilder();

        int totalGames = gameHistoryList.size();
        int totalWins = 0;
        int totalLosses = 0;
        int totalDraws = 0;

        Map<String, Integer> gameCountMap = new HashMap<String, Integer>();
        Map<String, Integer> gameWinsMap = new HashMap<String, Integer>();
        Map<String, Integer> gameLossesMap = new HashMap<String, Integer>();
        Map<String, Integer> gameDrawsMap = new HashMap<String, Integer>();

        for (GameHistory history : gameHistoryList) {
            String gameName = history.getGameName();
            gameCountMap.put(gameName, gameCountMap.getOrDefault(gameName, 0) + 1);

            switch (history.getResult()) {
                case WIN:
                    totalWins++;
                    gameWinsMap.put(gameName, gameWinsMap.getOrDefault(gameName, 0) + 1);
                    break;
                case LOSS:
                    totalLosses++;
                    gameLossesMap.put(gameName, gameLossesMap.getOrDefault(gameName, 0) + 1);
                    break;
                case DRAW:
                    totalDraws++;
                    gameDrawsMap.put(gameName, gameDrawsMap.getOrDefault(gameName, 0) + 1);
                    break;
                default:
                    break;
            }
        }

        report.append("\n===== STATISTICS REPORT =====\n");
        report.append("Total Games Played : ").append(totalGames).append("\n");
        report.append("Total Wins         : ").append(totalWins).append("\n");
        report.append("Total Losses       : ").append(totalLosses).append("\n");
        report.append("Total Draws        : ").append(totalDraws).append("\n");

        report.append("\n--- Game-wise Statistics ---\n");
        for (String gameName : gameCountMap.keySet()) {
            report.append("Game Name          : ").append(gameName).append("\n");
            report.append("Played             : ")
                  .append(gameCountMap.getOrDefault(gameName, 0)).append("\n");
            report.append("Wins               : ")
                  .append(gameWinsMap.getOrDefault(gameName, 0)).append("\n");
            report.append("Losses             : ")
                  .append(gameLossesMap.getOrDefault(gameName, 0)).append("\n");
            report.append("Draws              : ")
                  .append(gameDrawsMap.getOrDefault(gameName, 0)).append("\n\n");
        }

        if (totalGames == 0) {
            report.append("No games have been played yet.\n");
        }

        return report.toString();
    }
}