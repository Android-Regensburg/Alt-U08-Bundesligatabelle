package de.ur.mi.android.bundesligatabelle.download;

import java.util.ArrayList;

import de.ur.mi.android.bundesligatabelle.table.TableItem;

public interface OnDownloadListener {
    void onDownloadFinished(ArrayList<TableItem> table);
}
