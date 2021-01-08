package com.kevintmtz.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;

    private static  final int ACTIVITY_CODE_MENU = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.MainPlainTextName);
    }

    public void goToMenu(View v) {
        if (!name.getText().toString().matches("")) {
            Toast.makeText(this, "Going to menu!", Toast.LENGTH_SHORT).show();

            Intent intentToMenu = new Intent(this, MenuActivity.class);
            intentToMenu.putExtra("name", name.getText().toString());

            startActivityForResult(intentToMenu, ACTIVITY_CODE_MENU);
        } else {
            Toast.makeText(this, "Insert your name!", Toast.LENGTH_SHORT).show();
        }
    }
}