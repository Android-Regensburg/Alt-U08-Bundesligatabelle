package de.ur.mi.android.bundesligatabelle.table;

public class TableItem {
    private int place;
    private String team;
    private int points;
    private int playedGames;
    private int goals;
    private int goalsAgainst;

    public TableItem(int place, String team, int playedGames, int goals, int goalsAgainst, int points) {
        this.place = place;
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

    public int getPlace() {
        return place;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }
}
