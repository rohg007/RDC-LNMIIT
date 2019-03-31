package com.example.rdc_lnmiit;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    RecyclerView rv;
    DatabaseReference mDatabase;
    ArrayList<String> categories;
    MyAdpater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        //getSupportActionBar().setTitle("Select Categories");
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.category_collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Select Category");
        setSupportActionBar((Toolbar) findViewById(R.id.category_toolbar));

        ImageView imageView = findViewById(R.id.category_logo_image_view);

        Glide.with(this).load(R.drawable.rdc_logo).placeholder(R.drawable.placeholder).into(imageView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoriesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

       /* mDatabase = FirebaseDatabase.getInstance().getReference().child("Data");
        mDatabase.keepSynced(true);*/
       categories = new ArrayList<String>();
        categories.add("Ministry of housing and urban poverty alleviation");
        categories.add("Ministry of finance");
        categories.add("Ministry of human resource and development");
        categories.add("Ministry of rural development");
        categories.add("Ministry of urban development");
        categories.add("Ministry of social justice and empowerment");
        categories.add("Ministry of women and child development");
        categories.add("Ministry of health and family welfare");
        categories.add("Ministry of agriculture and farmers welfare");
        categories.add("Ministry of power");
        categories.add("Ministry of commerce");
        categories.add("Ministry of skill development and entrepreneurship");
        categories.add("Ministry of water resources, river development and ganga rejuvenation");
        categories.add("Ministry of labour and employment");
        categories.add("Ministry of electronics and IT");
        categories.add("Ministry of road transport and waterways");
        categories.add("Miscellaneous schemes");

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        adapter = new MyAdpater(categories, this);
        rv.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

       /* FirebaseRecyclerAdapter<CategoryModel, Holder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<CategoryModel, Holder>
                (CategoryModel.class, R.layout.card_view, Holder.class, mDatabase) {
            @Override
            protected void populateViewHolder(Holder holder, CategoryModel model, int position) {

                holder.txtCategory.setText(model.getCategory());
            }
        };

        rv.setAdapter(firebaseRecyclerAdapter);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.add_data_menu :
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
