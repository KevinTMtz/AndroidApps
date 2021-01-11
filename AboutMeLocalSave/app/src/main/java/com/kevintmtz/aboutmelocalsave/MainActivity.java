package com.kevintmtz.aboutmelocalsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY_CODE_MAIN = 0;

    private SharedPrefsHelper sharedPrefsHelper;
    private TextView regardOneText, regardTwoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefsHelper = new SharedPrefsHelper(this);

        regardOneText = findViewById(R.id.TextViewRegardOne);
        regardTwoText = findViewById(R.id.TextViewRegardTwo);

        updateTextViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        updateTextViews();
    }

    public void updateTextViews() {
        String[] savedPrefs = sharedPrefsHelper.read();
        regardOneText.setText(savedPrefs[0]);
        regardTwoText.setText(savedPrefs[1]);
    }

    public void goToRegards(View v) {
        Toast.makeText(this, "Going to regards!", Toast.LENGTH_SHORT).show();

        Intent intentToRegards = new Intent(this, RegardsActivity.class);

        startActivityForResult(intentToRegards, ACTIVITY_CODE_MAIN);
    }

    public void goToFriends(View v) {
        Toast.makeText(this, "Going to friends!", Toast.LENGTH_SHORT).show();

        Intent intentToFriends = new Intent(this, FriendsActivity.class);

        startActivityForResult(intentToFriends, ACTIVITY_CODE_MAIN);
    }
}