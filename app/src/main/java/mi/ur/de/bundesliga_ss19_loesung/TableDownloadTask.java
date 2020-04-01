package mi.ur.de.bundesliga_ss19_loesung;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class TableDownloadTask extends AsyncTask<String, Integer, String> {

    private static final String TEAM = "TeamName";
    private static final String GAMES = "Matches";
    private static final String POINTS = "Points";
    private static final String GOALS = "Goals";
    private static final String GOALS_AGAINST = "OpponentGoals";

    private ArrayList<TableItem> table;
    private DownloadListener listener;

    public TableDownloadTask(DownloadListener listener, ArrayList<TableItem> table) {
        this.listener = listener;
        this.table = table;
    }

    @Override
    protected String doInBackground(String... params) {
        String jsonString = "";

        try {
            URL url = new URL(params[0]);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String line;

                while ((line = br.readLine()) != null) {
                    jsonString += line;
                }

                br.close();
                is.close();
                conn.disconnect();

            } else {
                throw new IllegalStateException("HTTP response: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        processJson(result);
        listener.onDownloadFinished();
    }

    private void processJson(String text) {
        try {
            JSONArray jsonArray = new JSONArray(text);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int rank = i + 1;
                String team = jsonObject.getString(TEAM);
                int playedGames = jsonObject.getInt(GAMES);
                int points = jsonObject.getInt(POINTS);
                int goals = jsonObject.getInt(GOALS);
                int goalsAgainst = jsonObject.getInt(GOALS_AGAINST);
                TableItem item = new TableItem(rank, team, points, playedGames, goals, goalsAgainst);
                table.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
