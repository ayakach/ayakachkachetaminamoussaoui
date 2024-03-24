package com.example.kachkach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        Spinner cityspinner=findViewById(R.id.spinnerVille);
        String[] cities ={"agadir","casa","Settat"};
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.villes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
cityspinner.setAdapter(adapter);
    }
    public void inscrire(View view){
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        String email = editTextEmail.getText().toString();

        Spinner spinnerVille = findViewById(R.id.spinnerVille);
        String ville = spinnerVille.getSelectedItem().toString();

        EditText editTextPassword = findViewById(R.id.editTextPassword);
        String password = editTextPassword.getText().toString();


        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        String genre = radioButton.getText().toString();
        based db=new based(this);
        db.insertnewone(email,ville,password,genre);
        Intent myintent=new Intent(this, MainActivity.class);
        startActivity(myintent);

    }
}