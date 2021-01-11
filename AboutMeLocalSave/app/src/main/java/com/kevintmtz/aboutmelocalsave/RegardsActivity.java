package com.kevintmtz.aboutmelocalsave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegardsActivity extends AppCompatActivity {

    private SharedPrefsHelper sharedPrefsHelper;
    private EditText regardOne, regardTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regards);

        sharedPrefsHelper = new SharedPrefsHelper(this);
        String[] savedPrefs = sharedPrefsHelper.read();

        regardOne = findViewById(R.id.EditTextRegardOne);
        regardTwo = findViewById(R.id.EditTextRegardTwo);

        regardOne.setText(savedPrefs[0]);
        regardTwo.setText(savedPrefs[1]);
    }

    public void saveOnClick(View v) {
        if (regardOne.getText().toString().matches("") || regardTwo.getText().toString().matches("")) {
            Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_SHORT).show();
        } else {
            sharedPrefsHelper.save(regardOne.getText().toString(), regardTwo.getText().toString());

            Toast.makeText(this, "Saved regards!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void deleteOnClick(View v) {
        sharedPrefsHelper.deleteRegards();

        Toast.makeText(this, "Deleted regards", Toast.LENGTH_SHORT).show();
    }
}