package com.kevintmtz.myfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private Handler handler;
    private static String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler =  new Handler(Looper.getMainLooper(), this);
    }

    public void loadFriends(View view) {
        /*
        JSON location:
        https://github.com/KevinTMtz/AndroidApps/blob/main/Friends.json
        */

        HttpRequest request = new HttpRequest("https://raw.githubusercontent.com/KevinTMtz/AndroidApps/master/Friends.json", handler);
        request.start();
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

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        json = (String) msg.obj;
        setFragment();

        return true;
    }
}