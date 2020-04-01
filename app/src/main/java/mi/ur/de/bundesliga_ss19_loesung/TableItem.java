package mi.ur.de.bundesliga_ss19_loesung;

public class TableItem {

    private int rank;
    private String team;
    private int points;
    private int playedGames;
    private int goals;
    private int goalsAgainst;


    public TableItem(int rank, String team, int points, int playedGames, int goals, int goalsAgainst) {
        this.rank = rank;
        this.team = team;
        this.points = points;
        this.playedGames = playedGames;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
    }

    public String getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getRank() {
        return rank;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

}
