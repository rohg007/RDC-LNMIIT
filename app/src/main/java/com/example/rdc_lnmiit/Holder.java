package com.example.rdc_lnmiit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class Holder extends RecyclerView.ViewHolder {

    TextView scheme_name;

    public Holder(@NonNull final View itemView) {
        super(itemView);

        scheme_name = (TextView) itemView.findViewById(R.id.scheme_name);

    }

    public void setScheme_name(TextView scheme_name) {
        this.scheme_name = scheme_name;
    }


}
