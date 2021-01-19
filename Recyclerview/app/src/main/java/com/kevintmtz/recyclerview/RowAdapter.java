package com.kevintmtz.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.RowViewHolder> {
    public class RowViewHolder extends RecyclerView.ViewHolder {

        public TextView textView1, textView2;

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textViewRow1);
            textView2 = itemView.findViewById(R.id.textViewRow2);
        }
    }

    private ArrayList<String> rowsList;
    private View.OnClickListener clickListener;

    public RowAdapter(ArrayList<String> rowsList, View.OnClickListener clickListener) {
        this.rowsList = rowsList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        Button button = view.findViewById(R.id.btnRecyclerview);
        RowViewHolder rvh = new RowViewHolder(view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), String.format("I am row %d!", rvh.getAdapterPosition() + 1), Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(clickListener);

        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        holder.textView1.setText(String.format("1 - %s", rowsList.get(position)));
        holder.textView2.setText(String.format("2 - %s", rowsList.get(position)));
    }

    @Override
    public int getItemCount() {
        return rowsList.size();
    }
}
