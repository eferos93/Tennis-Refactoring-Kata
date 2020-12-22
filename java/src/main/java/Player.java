import java.util.Optional;

public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public Optional<String> getNameOfThePlayerInAdvantage(Player otherPlayer) {
        int minScore = score - otherPlayer.getScore();
        if (minScore == 1) {
            return Optional.of(name);
        } else if (minScore == -1){
            return Optional.of(otherPlayer.getName());
        } else {
            return Optional.empty();
        }
    }

    public Optional<String> getNameOfTheWinningPlayer(Player otherPlayer) {
        int minScore = score - otherPlayer.getScore();
        if (minScore >= 2) {
            return Optional.of(name);
        } else if (minScore <= -2) {
            return Optional.of(otherPlayer.getName());
        } else {
            return Optional.empty();
        }
    }

    public boolean isPlayerScoreEqualTo(int otherPlayerScore) {
        return score == otherPlayerScore;
    }
}