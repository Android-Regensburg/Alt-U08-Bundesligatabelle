package de.ur.mi.android.bundesligatabelle.download;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import de.ur.mi.android.bundesligatabelle.table.TableItem;

public class TableJSONDataParser {

    private static final String TEAM = "TeamName";
    private static final String GAMES = "Matches";
    private static final String POINTS = "Points";
    private static final String GOALS = "Goals";
    private static final String GOALS_AGAINST = "OpponentGoals";

    public static ArrayList<TableItem> parseTableJSONData (String jsonDataString) {
        ArrayList<TableItem> table = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonDataString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int rank = i + 1;
                String team = jsonObject.getString(TEAM);
                int playedGames = jsonObject.getInt(GAMES);
                int points = jsonObject.getInt(POINTS);
                int goals = jsonObject.getInt(GOALS);
                int goalsAgainst = jsonObject.getInt(GOALS_AGAINST);
                TableItem item = new TableItem(rank, team, playedGames, goals, goalsAgainst, points);
                table.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return table;
    }
}
