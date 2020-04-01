package mi.ur.de.bundesliga_ss19_loesung;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TableActivity extends Activity implements DownloadListener {

    private ArrayList<TableItem> table;
    private TableItemAdapter adapter;
    private final static String ADDRESS = "https://www.openligadb.de/api/getbltable/bl1/2018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        prepareListView();
        new TableDownloadTask(this, table).execute(ADDRESS);
    }

    private void prepareListView() {
        table = new ArrayList<>();
        adapter = new TableItemAdapter(TableActivity.this, table);
        ListView list = findViewById(R.id.tabelle);
        View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.table_item, null);
        list.addHeaderView(v);
        list.setAdapter(adapter);
    }

    @Override
    public void onDownloadFinished() {
        adapter.notifyDataSetChanged();
    }
}
