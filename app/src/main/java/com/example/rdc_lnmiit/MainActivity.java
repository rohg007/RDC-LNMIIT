package com.example.rdc_lnmiit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText gov_scheme_editText;
    EditText year_editText;
    EditText motive_editText;
    EditText bene_editText;
    EditText mile_editText;
    Button btn_submit;
    RadioGroup radioGroup;
    Spinner category_spinner;

    DatabaseReference databaseReference1; /*databaseReference2*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        databaseReference1 = FirebaseDatabase.getInstance().getReference("Data");

        gov_scheme_editText = (EditText) findViewById(R.id.gov_scheme_editText);
        year_editText = (EditText) findViewById(R.id.year_editText);
        motive_editText = (EditText) findViewById(R.id.motive_editText);
        bene_editText = (EditText) findViewById(R.id.bene_editText);
        mile_editText = (EditText) findViewById(R.id.mile_editText);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        category_spinner = (Spinner) findViewById(R.id.category_spinner);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    private void addData(){
        String category = category_spinner.getSelectedItem().toString();
        String scheme = gov_scheme_editText.getText().toString();
        String year = year_editText.getText().toString();
        String motive = motive_editText.getText().toString();
        String bene = bene_editText.getText().toString();
        String mile = mile_editText.getText().toString();
        String rg_value = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

       // String id = databaseReference.push().getKey();

        CategoryModel categoryModel = new CategoryModel(category);

       // databaseReference2 = FirebaseDatabase.getInstance().getReference(category);

        Data data = new Data(/*id, */scheme, year, motive, bene, mile, rg_value);

        databaseReference1.child(/*id*/category).push().setValue(categoryModel);
        databaseReference1.child(category).child(scheme).setValue(data);

        Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.show_data_menu:
                Intent intent = new Intent(this, CategoriesActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
