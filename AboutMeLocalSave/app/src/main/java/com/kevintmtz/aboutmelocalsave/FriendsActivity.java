package com.kevintmtz.aboutmelocalsave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private EditText name, hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        dbHelper = new DatabaseHelper(this);

        name = findViewById(R.id.PlainTextName);
        hobby = findViewById(R.id.PlainTextHobby);
    }

    public void save(View v) {
        if (name.getText().toString().matches("") || hobby.getText().toString().matches("")) {
            Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_SHORT).show();
        } else {
            dbHelper.save(name.getText().toString(), hobby.getText().toString());

            Toast.makeText(this, "Saved record!", Toast.LENGTH_SHORT).show();
        }
    }

    public void search(View v) {
        String answer = dbHelper.search(name.getText().toString());

        if (answer.matches("CODE: IT DOES NOT EXIST")) {
            Toast.makeText(this, "That name does not exist!", Toast.LENGTH_SHORT).show();
            hobby.setText("");
        } else {
            hobby.setText(answer);
        }
    }

    public void delete(View v) {
        int affected = dbHelper.delete(name.getText().toString());
        Toast.makeText(this, "Deleted " + affected + " records", Toast.LENGTH_SHORT).show();
    }
}