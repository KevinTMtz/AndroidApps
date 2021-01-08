package com.kevintmtz.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyHobbiesActivity extends AppCompatActivity {

    private EditText hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hobbies);

        hobby = findViewById(R.id.MyHobbiesPlainTextHobby);
    }

    public void returnToMenu(View v) {
        if (!hobby.getText().toString().matches("")) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("hobby", hobby.getText().toString());

            setResult(Activity.RESULT_OK, returnIntent);

            finish();
        } else {
            Toast.makeText(this, "Insert your hobby!", Toast.LENGTH_SHORT).show();
        }
    }
}