package com.example.kachkach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

    }
    public void chercher(View view) {
        EditText txtusername = findViewById(R.id.editTextText);
        EditText txtpassword = findViewById(R.id.editTextTextPassword);


        based db = new based(this);
        String email = txtusername.getText().toString();
        String password = txtpassword.getText().toString();

        if (db.verifier(email)) {

            Intent myintent = new Intent(this, MainActivity3.class);

            startActivity(myintent);
        } else {

            Intent myintent2 = new Intent(this, MainActivity2.class);
            startActivity(myintent2);
        }

    }            public void inscrire(View view){
        Intent myintent3 = new Intent(this, MainActivity4.class);
        startActivity(myintent3);
    }
}