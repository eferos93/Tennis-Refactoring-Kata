import java.util.Optional;

public class Player {
    private String name;
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

    public Optional<Player> playerInAdvantageAgainst(Player otherPlayer) {
        if (score - otherPlayer.getScore() == 1) {
            return Optional.of(this);
        } else if (score - otherPlayer.getScore() == -1){
            return Optional.of(otherPlayer);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Player> playerWinningAgainst(Player otherPlayer) {
        if (score - otherPlayer.getScore() >= 2) {
            return Optional.of(this);
        } else if (score - otherPlayer.getScore() <= -2) {
            return Optional.of(otherPlayer);
        } else {
            return Optional.empty();
        }
    }

    public boolean isPlayerScoreEqualTo(Player otherPlayer) {
        return score == otherPlayer.getScore();
    }
}