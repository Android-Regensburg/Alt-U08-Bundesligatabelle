package de.ur.mi.android.bundesligatabelle.download;

import android.app.Activity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import de.ur.mi.android.bundesligatabelle.table.TableItem;

public class TableDownloadTask implements Runnable {

    private Activity context;
    private String tableDataUrl;
    private OnDownloadListener listener;

    public TableDownloadTask(Activity context, String tableDataUrl, OnDownloadListener listener) {
        this.context = context;
        this.tableDataUrl = tableDataUrl;
        this.listener = listener;
    }

    @Override
    public void run() {
        String jsonDataString = fetchOnlineData();
        final ArrayList<TableItem> table = TableJSONDataParser.parseTableJSONData(jsonDataString);
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listener.onDownloadFinished(table);
            }
        });
    }

    private String fetchOnlineData() {
        StringBuilder jsonString = new StringBuilder();
        try {
            URL url = new URL(tableDataUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    jsonString.append(line);
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
        return jsonString.toString();
    }
}


