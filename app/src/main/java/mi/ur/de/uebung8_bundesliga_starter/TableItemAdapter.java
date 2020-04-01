package mi.ur.de.uebung8_bundesliga_starter;

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

    public TableItemAdapter(Context context, List<TableItem> table) {
        super(context, R.layout.table_item, table);
        this.context = context;
        this.table = table;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.table_item, null);
        }

        TextView rank = v.findViewById(R.id.rank);
        TextView team =  v.findViewById(R.id.team);
        TextView playedGames =  v.findViewById(R.id.played_games);
        TextView points =  v.findViewById(R.id.points);
        TextView goalDifference =  v.findViewById(R.id.goals);

        //set data here


        return v;
    }

}