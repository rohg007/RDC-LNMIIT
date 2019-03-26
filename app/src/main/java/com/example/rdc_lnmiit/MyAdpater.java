package com.example.rdc_lnmiit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdpater extends RecyclerView.Adapter<MyAdpater.ViewHolder> {

    ArrayList<String> categories;

    public MyAdpater(ArrayList<String> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public MyAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdpater.ViewHolder viewHolder, int i) {
        viewHolder.category.setText(categories.get(i));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category = (TextView) itemView.findViewById(R.id.txtCategory);
        }
    }
}
