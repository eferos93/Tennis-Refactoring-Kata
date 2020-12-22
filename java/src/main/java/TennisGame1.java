
public class TennisGame1 implements TennisGame {

    public static class Outputs {
        private final static String DEUCE = "Deuce";
        private final static String ALL = "All";
        private final static String ADVANTAGE = "Advantage for #playerName";
        private final static String WIN = "Win for #playerName";
        private final static String[] defaults = {"Love", "Fifteen", "Thirty", "Fourty"};

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
        String score = "";
        int tempScore=0;
        if (arePlayerScoresEven(player1.getScore(), player2.getScore()))
        {
            return finalResultEvenScores(player1.getScore());
        }
        else if (player1.getScore() >= 4 || player2.getScore() >= 4)
        {
            int minusResult = player1.getScore() - player2.getScore();
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1.getScore();
                else { score+="-"; tempScore = player2.getScore();}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private String finalResultEvenScores(int playersScore) {
        if (playersScore >= 3) {
            return Outputs.DEUCE;
        }

        return Outputs.defaults[playersScore] + "-" + Outputs.ALL;
    }

    private boolean arePlayerScoresEven(int score, int score2) {
        return score == score2;
    }
}
