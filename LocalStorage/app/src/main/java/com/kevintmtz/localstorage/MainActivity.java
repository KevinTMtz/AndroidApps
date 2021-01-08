package com.kevintmtz.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText id, name, studentID;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.PlainTextID);
        name = findViewById(R.id.PlainTextName);
        studentID = findViewById(R.id.PlainTextStudentID);

        dbHelper = new DatabaseHelper(this);
    }

    public void add(View v) {
        dbHelper.save(name.getText().toString(), studentID.getText().toString());
        Toast.makeText(this, "Saved records!", Toast.LENGTH_SHORT).show();
    }

    public void search(View v) {
        int idQuery = dbHelper.search(name.getText().toString());
        id.setText("" + idQuery);
    }

    public void delete(View v) {
        int affected = dbHelper.delete(name.getText().toString());
        Toast.makeText(this, "Deleted " + affected + " records", Toast.LENGTH_SHORT).show();
    }

    public void loadPrefsActivity(View v) {
        Intent intent = new Intent(this, SharedPrefsActivity.class);
        startActivity(intent);
    }
}