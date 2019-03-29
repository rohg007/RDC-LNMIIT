package com.example.rdc_lnmiit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SchemesDetails extends AppCompatActivity {

    TextView year, centralorstate, bene, motive, mile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes_details);

        Intent i = getIntent();

        Data data = i.getParcelableExtra("SchemesData");

        getSupportActionBar().setTitle(data.getScheme());

        year = (TextView) findViewById(R.id.year);
        centralorstate = (TextView) findViewById(R.id.centralorstate);
        bene = (TextView) findViewById(R.id.bene);
        motive = (TextView) findViewById(R.id.motive);
        mile = (TextView) findViewById(R.id.mile);



        year.setText(data.getYear());
        centralorstate.setText(data.getRg_value());
        bene.setText(data.getBene());
        motive.setText(data.getMotive());
        mile.setText(data.getMile());
    }
}
