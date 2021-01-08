package com.kevintmtz.aboutme;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView helloUser, hobbyUser;

    private static  final int ACTIVITY_CODE_MY_HOBBIES = 0;
    private static  final int ACTIVITY_CODE_MY_FRIENDS = 0;
    private static  final int ACTIVITY_CODE_LEAVE_MESSAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        helloUser = findViewById(R.id.MenuTextViewHello);
        hobbyUser = findViewById(R.id.MenuTextViewHobby);

        Intent intent = getIntent();
        String nombreStr = intent.getStringExtra("name");

        helloUser.setText("Hello " + nombreStr);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_CODE_MY_HOBBIES && resultCode == Activity.RESULT_OK && data != null) {
            String hobby = data.getStringExtra("hobby");

            hobbyUser.setText("Hobby: " + hobby);
        }
    }

    public void goToMyHobbies(View v) {
        Toast.makeText(this, "Going to my hobbies!", Toast.LENGTH_SHORT).show();

        Intent intentToMyHobbies = new Intent(this, MyHobbiesActivity.class);

        startActivityForResult(intentToMyHobbies, ACTIVITY_CODE_MY_HOBBIES);
    }

    public void goToMyFriends(View v) {
        Toast.makeText(this, "Going to my friends!", Toast.LENGTH_SHORT).show();

        Intent intentToMyFriends = new Intent(this, FriendsActivity.class);

        startActivityForResult(intentToMyFriends, ACTIVITY_CODE_MY_FRIENDS);
    }

    public void goToLeaveMessage(View v) {
        Toast.makeText(this, "Going to leave a message!", Toast.LENGTH_SHORT).show();

        Intent intentToLeaveMessage = new Intent(this, LeaveMessageActivity.class);

        startActivityForResult(intentToLeaveMessage, ACTIVITY_CODE_LEAVE_MESSAGE);
    }
}