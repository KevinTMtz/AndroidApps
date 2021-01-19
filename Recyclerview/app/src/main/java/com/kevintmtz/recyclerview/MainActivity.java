package com.kevintmtz.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextFragment.CallBack {

    private static final int ACTIVITY_CODE_RECYCLERVIEW = 0;

    private static ImageFragment imageFragment;
    private static TextFragment textFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("firstName", "Green");
        bundle.putString("lastName", "Droid");
        imageFragment.setArguments(bundle);

        textFragment = new TextFragment();
        changeFragment(imageFragment);
    }

    public void changeFragment(Fragment newFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.container, newFragment);
        transaction.commit();
    }

    public void greetFragment(View v) {
        try {
            imageFragment.greet("Hello, I'm a fragment");
        } catch(Exception e) {
            Toast.makeText(this, "Image fragment is not mounted", Toast.LENGTH_SHORT).show();
        }
    }

    public void fragmentA(View v) {
        changeFragment(imageFragment);
    }

    public void fragmentB(View v) {
        changeFragment(textFragment);
    }

    public void changeToRecyclerviewActivity(View v) {
        Intent intentToRecyclerviewActivity = new Intent(this, RecyclerviewActivity.class);

        startActivityForResult(intentToRecyclerviewActivity, ACTIVITY_CODE_RECYCLERVIEW);
    }

    public void changeToHttpRequestActivity(View v) {
        Intent intentToHttpRequestActivity = new Intent(this, HttpRequestActivity.class);

        startActivityForResult(intentToHttpRequestActivity, ACTIVITY_CODE_RECYCLERVIEW);
    }

    @Override
    public void greetingOnActivity(String greeting) {
        Toast.makeText(this, "Received greeting: " + greeting, Toast.LENGTH_SHORT).show();
    }
}