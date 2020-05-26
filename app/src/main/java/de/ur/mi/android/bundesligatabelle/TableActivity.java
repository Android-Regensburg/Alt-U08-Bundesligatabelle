package de.ur.mi.android.bundesligatabelle;

import androidx.appcompat.app.AppCompatActivity;
import de.ur.mi.android.bundesligatabelle.download.OnDownloadListener;
import de.ur.mi.android.bundesligatabelle.table.TableItem;

import android.os.Bundle;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity implements OnDownloadListener {

    private static final String TABLE_DATA_URL = "https://www.openligadb.de/api/getbltable/bl1/2019";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }

    @Override
    public void onDownloadFinished(ArrayList<TableItem> table) {

    }
}
