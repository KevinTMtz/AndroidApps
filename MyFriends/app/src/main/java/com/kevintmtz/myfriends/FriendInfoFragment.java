package com.kevintmtz.myfriends;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class FriendInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "json_object";
    private static final String ARG_PARAM2 = "json_string";

    private static final String JSON_KEY1 = "name";
    private static final String JSON_KEY2 = "hobby";
    private static final String JSON_KEY3 = "age";
    private static final String JSON_KEY4 = "phone";
    private static final String JSON_KEY5 = "address";

    private String name;
    private String hobby;
    private String age;
    private String phone;
    private String address;
    private String json;

    public FriendInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            json = getArguments().getString(ARG_PARAM2);

            try {
                JSONObject object = new JSONObject(getArguments().getString(ARG_PARAM1));

                name = object.getString(JSON_KEY1);
                hobby = object.getString(JSON_KEY2);
                age = object.getString(JSON_KEY3);
                phone = object.getString(JSON_KEY4);
                address = object.getString(JSON_KEY5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_info, container, false);

        ((TextView) view.findViewById(R.id.textViewName)).setText(String.format("Name: %s", name));
        ((TextView) view.findViewById(R.id.textViewHobby)).setText(String.format("Hobby: %s", hobby));
        ((TextView) view.findViewById(R.id.textViewAge)).setText(String.format("Age: %s", age));
        ((TextView) view.findViewById(R.id.textViewPhone)).setText(String.format("Phone: %s", phone));
        ((TextView) view.findViewById(R.id.textViewAddress)).setText(String.format("Address: %s", address));

        view.findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                FriendsRecyclerviewFragment friendsRecyclerviewFragment = new FriendsRecyclerviewFragment();
                Bundle bundle = new Bundle();
                bundle.putString("json_string", json);
                friendsRecyclerviewFragment.setArguments(bundle);

                transaction.replace(R.id.layoutContainer, friendsRecyclerviewFragment);
                transaction.commit();
            }
        });

        return view;
    }
}