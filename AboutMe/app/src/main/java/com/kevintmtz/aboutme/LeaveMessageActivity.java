package com.kevintmtz.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LeaveMessageActivity extends AppCompatActivity {

    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_message);

        message = findViewById(R.id.LeaveMessagePlainTextMessage);
    }

    public void sendAndReturnToMenu(View v) {
        if (!message.getText().toString().matches("")) {
            Toast.makeText(this, "Sent message: " + message.getText().toString(), Toast.LENGTH_SHORT).show();

            finish();
        } else {
            Toast.makeText(this, "Insert your message!", Toast.LENGTH_SHORT).show();
        }
    }
}