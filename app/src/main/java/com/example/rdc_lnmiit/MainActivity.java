package com.example.rdc_lnmiit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        databaseReference = FirebaseDatabase.getInstance().getReference("Data");

        gov_scheme_editText = (EditText) findViewById(R.id.gov_scheme_editText);
        year_editText = (EditText) findViewById(R.id.year_editText);
        motive_editText = (EditText) findViewById(R.id.motive_editText);
        bene_editText = (EditText) findViewById(R.id.bene_editText);
        mile_editText = (EditText) findViewById(R.id.mile_editText);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    private void addData(){
        String scheme = gov_scheme_editText.getText().toString();
        String year = year_editText.getText().toString();
        String motive = motive_editText.getText().toString();
        String bene = bene_editText.getText().toString();
        String mile = mile_editText.getText().toString();
        String rg_value = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

        String id = databaseReference.push().getKey();

        Data data = new Data(id, scheme, year, motive, bene, mile, rg_value);

        databaseReference.child(id).setValue(data);

        Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
    }
}
