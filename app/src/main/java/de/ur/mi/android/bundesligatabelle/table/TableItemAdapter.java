package de.ur.mi.android.bundesligatabelle.table;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

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

        TextView place = v.findViewById(R.id.place);
        TextView team =  v.findViewById(R.id.team);
        TextView playedGames =  v.findViewById(R.id.played_games);
        TextView points =  v.findViewById(R.id.points);
        TextView goalDifference =  v.findViewById(R.id.goals);

        TableItem p = table.get(position);
        v.setBackgroundResource(getColorForPlace(p.getPlace()));
        place.setText(String.valueOf(p.getPlace()));
        team.setText(p.getTeam());
        playedGames.setText(String.valueOf(p.getPlayedGames()));
        points.setText(String.valueOf(p.getPoints()));
        goalDifference.setText(String.format(Locale.getDefault(),"%d:%d", p.getGoals(), p.getGoalsAgainst()));

        return v;
    }

    private int getColorForPlace(int place) {

        if (place <= 4) {
            return android.R.color.holo_green_dark;
        } else if (place <= 6) {
            return android.R.color.holo_green_light;
        } else if (place == 16) {
            return android.R.color.holo_red_light;
        } else if (place > 16) {
            return android.R.color.holo_red_dark;
        } else {
            return android.R.color.darker_gray;
        }
    }
}
