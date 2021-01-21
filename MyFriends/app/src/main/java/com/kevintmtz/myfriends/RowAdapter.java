package com.kevintmtz.myfriends;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.RowViewHolder> {
    public class RowViewHolder extends RecyclerView.ViewHolder {

        public final TextView textViewName;
        public final TextView textViewHobby;

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewRowName);
            textViewHobby = itemView.findViewById(R.id.textViewRowHobby);
        }
    }

    private final String json;
    private JSONArray jsonArray;
    private final Context context;

    public RowAdapter(String json, Context context) {
        this.json = json;
        this.context = context;

        try {
            this.jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_friend, parent, false);
        RowViewHolder rvh = new RowViewHolder(view);

        view.setOnClickListener(v -> {
            FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            FriendInfoFragment friendInfoFragment = new FriendInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("json_string", json);
            bundle.putInt("object_index", rvh.getAdapterPosition());

            friendInfoFragment.setArguments(bundle);

            transaction.replace(R.id.layoutContainer, friendInfoFragment);
            transaction.commit();
        });

        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        try {
            holder.textViewName.setText(jsonArray.getJSONObject(position).getString("name"));
            holder.textViewHobby.setText(String.format("Hobby: %s", jsonArray.getJSONObject(position).getString("hobby")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }
}
