package mi.ur.de.uebung8_bundesliga_starter;

import android.app.Activity;
import android.os.Bundle;

public class TableActivity extends Activity {

    private final static String ADDRESS = "https://www.openligadb.de/api/getbltable/bl1/2018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }

}
