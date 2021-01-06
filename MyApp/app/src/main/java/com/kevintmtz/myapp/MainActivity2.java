package com.kevintmtz.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);

        Intent intent = getIntent();
        String nombreStr = intent.getStringExtra("nombre");
        String apellidoStr = intent.getStringExtra("apellido");

        nombre.setText(nombreStr);
        apellido.setText(apellidoStr);
    }

    public void returnToActivity1(View v) {
        Intent retorno = new Intent();
        retorno.putExtra("result", 1);
        retorno.putExtra("saludo", "Hola!");

        setResult(Activity.RESULT_OK, retorno);

        finish();
    }
}