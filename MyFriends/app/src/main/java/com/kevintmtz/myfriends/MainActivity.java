package com.kevintmtz.myfriends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadFriends(View view) {
        json = "{'friends': [" +
                "{'name': 'Kevin', 'hobby': 'Coding', 'age': '20' , 'phone': '1234567890', 'address': 'Earth'}," +
                "{'name': 'Nat', 'hobby': 'Sleeping', 'age': '21' , 'phone': '0987654321', 'address': 'Moon'}," +
                "{'name': 'Mario', 'hobby': 'Twerking', 'age': '20' , 'phone': '6789054321', 'address': 'Mars'}" +
                "]}";

        setFragment();
    }

    public void setFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        FriendsRecyclerviewFragment friendsRecyclerviewFragment = new FriendsRecyclerviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("json_string", json);
        friendsRecyclerviewFragment.setArguments(bundle);

        transaction.replace(R.id.layoutContainer, friendsRecyclerviewFragment);
        transaction.commit();
    }
}