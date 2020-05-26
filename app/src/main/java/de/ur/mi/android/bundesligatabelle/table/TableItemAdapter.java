package de.ur.mi.android.bundesligatabelle.table;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import de.ur.mi.android.bundesligatabelle.R;

public class TableItemAdapter extends ArrayAdapter<TableItem> {

    private ArrayList<TableItem> table;
    private Context context;

    public TableItemAdapter(Context context, ArrayList<TableItem> table) {
        super(context, R.layout.bl_table_item, table);
        this.context = context;
        this.table = table;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.bl_table_item, null);
        }

        //TODO: Referenzieren und Befüllen der TextView-Elemente und Anpassung der Farbe abhängig von der Platzierung

        return v;
    }
}
