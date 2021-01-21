package com.kevintmtz.myfriends;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

public class FriendsRecyclerviewFragment extends Fragment implements Serializable {

    private String json;

    public FriendsRecyclerviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            json = getArguments().getString("json_string");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends_recyclerview, container, false);

        RecyclerView friendsRecyclerview = view.findViewById(R.id.recyclerviewFriends);

        RowAdapter rowAdapter = new RowAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        friendsRecyclerview.setLayoutManager(linearLayoutManager);
        friendsRecyclerview.setAdapter(rowAdapter);

        return view;
    }

    public String getJson() {
        return json;
    }
}