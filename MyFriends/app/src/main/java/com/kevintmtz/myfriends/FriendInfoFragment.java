package com.kevintmtz.myfriends;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "object_index";
    private static final String ARG_PARAM2 = "json_string";

    private String json;
    private JSONObject jsonObject;

    public FriendInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            int objectIndex = getArguments().getInt(ARG_PARAM1);
            json = getArguments().getString(ARG_PARAM2);

            try {
                JSONArray jsonArray = new JSONArray(json);
                jsonObject = jsonArray.getJSONObject(objectIndex);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_info, container, false);

        try {
            ((TextView) view.findViewById(R.id.textViewName)).setText(String.format("Name: %s", jsonObject.getString("name")));
            ((TextView) view.findViewById(R.id.textViewHobby)).setText(String.format("Hobby: %s", jsonObject.getString("hobby")));
            ((TextView) view.findViewById(R.id.textViewAge)).setText(String.format("Age: %s", jsonObject.getString("age")));
            ((TextView) view.findViewById(R.id.textViewPhone)).setText(String.format("Phone: %s", jsonObject.getString("phone")));
            ((TextView) view.findViewById(R.id.textViewAddress)).setText(String.format("Address: %s", jsonObject.getString("address")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        view.findViewById(R.id.buttonBack).setOnClickListener(v -> {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            FriendsRecyclerviewFragment friendsRecyclerviewFragment = new FriendsRecyclerviewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("json_string", json);
            friendsRecyclerviewFragment.setArguments(bundle);

            transaction.replace(R.id.layoutContainer, friendsRecyclerviewFragment);
            transaction.commit();
        });

        return view;
    }
}