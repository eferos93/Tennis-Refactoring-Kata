import java.util.Optional;

public class TennisGame1 implements TennisGame {

    public static class Outputs {
        private final static String DEUCE = "Deuce";
        private final static String ALL = "All";
        private final static String ADVANTAGE = "Advantage %s";
        private final static String WIN = "Win for %s";
        private final static String[] defaults = {"Love", "Fifteen", "Thirty", "Forty"};

    }
    private Player player1, player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1.increaseScore();
        else
            player2.increaseScore();
    }

    public String getScore() {

        if (player1.isPlayerScoreEqualTo(player2.getScore())) {
            return finalResultEvenScores(player1.getScore());
        } else if (isWinOrTie()) {
            return player1.getNameOfThePlayerInAdvantage(player2).
                    map(playerName -> String.format(Outputs.ADVANTAGE, playerName)). //get player's name in advantage
                    or(() -> Optional.of(String.format(Outputs.WIN,                  //otherwise, get winner's name
                            player1.getNameOfTheWinningPlayer(player2).get()))).
                    get();
        }


        return Outputs.defaults[player1.getScore()] +
                "-" +
                Outputs.defaults[player2.getScore()];

    }


    private boolean isWinOrTie() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private String finalResultEvenScores(int playersScore) {
        if (playersScore >= 3) {
            return Outputs.DEUCE;
        }

        return Outputs.defaults[playersScore] + "-" + Outputs.ALL;
    }
}
