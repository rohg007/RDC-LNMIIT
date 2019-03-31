package com.example.rdc_lnmiit;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

public class SchemesActivity extends AppCompatActivity {

    RecyclerView recycler_scheme;
    DatabaseReference databaseRef, databaseRefDialog;
    String categorySelected;
    ArrayList<Data> data_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes);

        //getSupportActionBar().setTitle("Select Schemes");

        data_list = new ArrayList<>();

        categorySelected = getIntent().getStringExtra("categorySelected");

        recycler_scheme = (RecyclerView) findViewById(R.id.recycler_scheme);
        recycler_scheme.setHasFixedSize(true);
        recycler_scheme.setLayoutManager(new LinearLayoutManager(this));

        databaseRef = FirebaseDatabase.getInstance().getReference("/Data/" + categorySelected);
        databaseRef.keepSynced(true);

        databaseRefDialog = FirebaseDatabase.getInstance().getReference("/Data/" + categorySelected/* + "/" + schemeName*/);
        databaseRefDialog.keepSynced(true);


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseRefDialog.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    Data d = ds.getValue(Data.class);
                    data_list.add(d);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SchemesActivity.this, "Enable to fetch data", Toast.LENGTH_SHORT).show();
            }
        });

       FirebaseRecyclerAdapter<Data, Holder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Data, Holder>
                (Data.class, R.layout.scheme_list, Holder.class, databaseRef) {
            @Override
            protected void populateViewHolder(final Holder holder, Data model, final int position) {

                holder.scheme_name.setText(model.getScheme());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //showDialog(data_list.get(position));

                        Intent intent = new Intent(SchemesActivity.this, SchemesDetails.class);
                        intent.putExtra("SchemesData", data_list.get(position));
                        startActivity(intent);

                    }
                });
            }
        };

       recycler_scheme.setAdapter(firebaseRecyclerAdapter);
    }

    public void showDialog(Data d){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = new SchemeDialog();

        ((SchemeDialog) dialogFragment).dialog_year.setText(d.getYear());
        ((SchemeDialog) dialogFragment).dialog_centralorstate.setText(d.getRg_value());
        ((SchemeDialog) dialogFragment).dialog_bene.setText(d.getBene());
        ((SchemeDialog) dialogFragment).dialog_motive.setText(d.getMotive());
        ((SchemeDialog) dialogFragment).dialog_mile.setText(d.getMile());

        dialogFragment.show(ft, "dialog");

    }

}
