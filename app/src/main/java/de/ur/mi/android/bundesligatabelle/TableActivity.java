package de.ur.mi.android.bundesligatabelle;

import androidx.appcompat.app.AppCompatActivity;
import de.ur.mi.android.bundesligatabelle.download.OnDownloadListener;
import de.ur.mi.android.bundesligatabelle.download.TableDownloadTask;
import de.ur.mi.android.bundesligatabelle.table.TableItem;
import de.ur.mi.android.bundesligatabelle.table.TableItemAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.Executors;

public class TableActivity extends AppCompatActivity implements OnDownloadListener {

    private static final String TABLE_DATA_URL = "https://www.openligadb.de/api/getbltable/bl1/2019";
    private ArrayList<TableItem> table;
    private TableItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        prepareListView();
        fetchData();
    }

    private void prepareListView() {
        table = new ArrayList<>();
        adapter = new TableItemAdapter(TableActivity.this, table);
        ListView list = findViewById(R.id.bundesliga_table);
        View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.bl_table_item, null);
        list.addHeaderView(v);
        list.setAdapter(adapter);
    }

    private void fetchData() {
        TableDownloadTask task = new TableDownloadTask(this, TABLE_DATA_URL, this);
        Executors.newSingleThreadExecutor().submit(task);
    }

    @Override
    public void onDownloadFinished(ArrayList<TableItem> table) {
        this.table.addAll(table);
        adapter.notifyDataSetChanged();
    }
}
