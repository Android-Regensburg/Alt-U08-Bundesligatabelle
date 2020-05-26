package de.ur.mi.android.bundesligatabelle.download;

import android.app.Activity;

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

    }
}
