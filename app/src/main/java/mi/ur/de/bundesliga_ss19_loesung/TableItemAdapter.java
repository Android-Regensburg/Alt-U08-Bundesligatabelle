package mi.ur.de.bundesliga_ss19_loesung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class TableItemAdapter extends ArrayAdapter<TableItem> {

    private List<TableItem> table;
    private Context context;

    public TableItemAdapter(Context context, List<TableItem> objects) {
        super(context, R.layout.table_item, objects);
        this.context = context;
        table = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.table_item, null);
        }

        TextView rank = v.findViewById(R.id.rank);
        TextView team = v.findViewById(R.id.team);
        TextView points = v.findViewById(R.id.points);
        TextView playedGames = v.findViewById(R.id.played_games);
        TextView goalDifference = v.findViewById(R.id.goals);

        TableItem p = table.get(position);
        v.setBackgroundResource(getColorForRank(p.getRank()));
        rank.setText(String.valueOf(p.getRank()));
        team.setText(p.getTeam());
        playedGames.setText(String.valueOf(p.getPlayedGames()));
        points.setText(String.valueOf(p.getPoints()));
        goalDifference.setText(p.getGoals() + ":" + p.getGoalsAgainst());


        return v;
    }

    public int getColorForRank(int rank) {

        if (rank <= 3) {
            return android.R.color.holo_green_dark;
        } else if (rank <= 6) {
            return android.R.color.holo_green_light;
        } else if (rank == 16) {
            return android.R.color.holo_red_light;
        } else if (rank > 16) {
            return android.R.color.holo_red_dark;
        } else {
            return android.R.color.darker_gray;
        }
    }

}