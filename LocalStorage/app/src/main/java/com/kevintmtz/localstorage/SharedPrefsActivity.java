package com.kevintmtz.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefsActivity extends AppCompatActivity {

    private static final String FILE_PREFS = "MyPrefs";
    private static final String KEY_FIRSTNAME = "first name";
    private static final String KEY_LASTNAME = "last Name";

    private SharedPreferences sharedPrefs;
    private EditText firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);

        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);

        sharedPrefs = getSharedPreferences(FILE_PREFS, MODE_PRIVATE);
    }

    public void print(View v) {
        Toast.makeText(this,
                    "Values: " +
                        sharedPrefs.getString(KEY_FIRSTNAME, "No first name") +
                        " " +
                        sharedPrefs.getString(KEY_LASTNAME, "No last name"),
                        Toast.LENGTH_SHORT).show();
    }

    public void save(View v) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(KEY_FIRSTNAME, firstName.getText().toString());
        editor.putString(KEY_LASTNAME, lastName.getText().toString());
        editor.commit();

        Toast.makeText(this, "Saved info", Toast.LENGTH_SHORT).show();
    }

    public void deleteName(View v) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove(KEY_FIRSTNAME);
        editor.commit();

        Toast.makeText(this, "Deleted name", Toast.LENGTH_SHORT).show();
    }

    public void deleteAll(View v) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove(KEY_FIRSTNAME);
        editor.remove(KEY_LASTNAME);
        editor.commit();

        Toast.makeText(this, "Deleted all", Toast.LENGTH_SHORT).show();
    }
}