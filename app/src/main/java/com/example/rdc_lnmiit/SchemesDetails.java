package com.example.rdc_lnmiit;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SchemesDetails extends AppCompatActivity {

    TextView year, centralorstate, bene, motive, mile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes_details);

        Intent i = getIntent();

        Data data = i.getParcelableExtra("SchemesData");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.detail_collapsing_toolbar);
        collapsingToolbarLayout.setTitle(data.getScheme());
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        setSupportActionBar((Toolbar) findViewById(R.id.detail_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView logoImageView = findViewById(R.id.detail_logo_image_view);
        Glide.with(this).load(R.drawable.placeholder).placeholder(R.drawable.placeholder).into(logoImageView);

        //getSupportActionBar().setTitle(data.getScheme());

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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
