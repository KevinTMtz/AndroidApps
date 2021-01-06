package com.kevintmtz.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    TextView texto;
    EditText entrada;
    Button boton1, boton2;

    private static  final int ACTIVITY2_CODE = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

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
                Toast.makeText(MainActivity1.this, entrada.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void interaction1(View v) {
        Toast.makeText(this, "Going to activity 2!", Toast.LENGTH_SHORT).show();

        Intent intentToActivity2 = new Intent(this, MainActivity2.class);
        intentToActivity2.putExtra("nombre", "Kevin");
        intentToActivity2.putExtra("apellido", entrada.getText().toString());

        startActivityForResult(intentToActivity2, ACTIVITY2_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY2_CODE && resultCode == Activity.RESULT_OK && data != null) {
            int resultado = data.getIntExtra("result", 0);
            String saludo = data.getStringExtra("saludo");

            Toast.makeText(MainActivity1.this, "Saludos: " + saludo + " " + resultado, Toast.LENGTH_SHORT).show();
        }
    }
}