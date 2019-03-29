package com.example.rdc_lnmiit;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SchemeDialog extends DialogFragment {

    TextView dialog_year, dialog_centralorstate, dialog_bene, dialog_motive, dialog_mile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_scheme, container, false);

        dialog_year = (TextView) container.findViewById(R.id.dialog_year);
        dialog_centralorstate = (TextView) container.findViewById(R.id.dialog_centralorstate);
        dialog_bene = (TextView) container.findViewById(R.id.dialog_bene);
        dialog_motive = (TextView) container.findViewById(R.id.dialog_motive);
        dialog_mile = (TextView) container.findViewById(R.id.dialog_mile);

        return v;
    }
}
