package com.kevintmtz.firebasestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText email, password, value;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.PTEmail);
        password = findViewById(R.id.PTPassword);
        value = findViewById(R.id.PTValue);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            Toast.makeText(this, "Current user: " + user.getEmail(), Toast.LENGTH_SHORT).show();
        }

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, String.format("Added value (%s) successfully!", value), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error connecting to database!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void login(View view) {
        if (email.getText().toString().matches("") || password.getText().toString().matches("")) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
        } else {
            firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(
                                        MainActivity.this,
                                        "Login was successful!",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, String.format("Error: %s", task.getException().getMessage()), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            Toast.makeText(this, "Current user: " + user.getEmail(), Toast.LENGTH_SHORT).show();
        }
    }

    public void signUp(View view) {
        if (email.getText().toString().matches("") || password.getText().toString().matches("")) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
        } else {
            firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(
                                        MainActivity.this,
                                        "Sign up was successful!",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, String.format("Error: %s", task.getException().getMessage()), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void addValue(View view) {
        if (value.getText().toString().matches("")) {
            Toast.makeText(this, "Value can not be empty!", Toast.LENGTH_SHORT).show();
        } else {
            databaseReference.setValue(value.getText().toString());
        }
    }
}