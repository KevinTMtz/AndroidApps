package com.kevintmtz.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    EditText entrada;
    Button boton1, boton2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto =  findViewById(R.id.textView);
        entrada = findViewById(R.id.editTextTextPersonName);
        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);

        texto.setText("First Android App");
        entrada.setText("UwU");

        Log.i("OnCreate", "Info Log");

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, entrada.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void interaction1(View v) {
        Toast.makeText(this, "I'm a button", Toast.LENGTH_SHORT).show();
    }
}