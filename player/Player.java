package player;

/**
 * Stores player information and demonstrates encapsulation.
 */
public class Player {
    private Integer playerId;
    private String playerName;
    private Integer age;
    private String city;

    public Player() {
    }

    public Player(Integer playerId, String playerName, Integer age, String city) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.age = age;
        this.city = city;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Player ID      : " + playerId + System.lineSeparator()
             + "Player Name    : " + playerName + System.lineSeparator()
             + "Age            : " + age + System.lineSeparator()
             + "City           : " + city;
    }
}