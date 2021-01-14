package com.kevintmtz.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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

    public void fragmentA(View v) {
        changeFragment(imageFragment);
    }

    public void fragmentB(View v) {
        changeFragment(textFragment);
    }
}