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

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Spinner categoriespinner=findViewById(R.id.spinnercategories);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.secteurs,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        categoriespinner.setAdapter(adapter);
        Spinner spinnersecteur=findViewById(R.id.spinnersecteur);
        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this,R.array.categories,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnersecteur.setAdapter(adapter2);
        Spinner spinnersviles=findViewById(R.id.spinnerVille);
        ArrayAdapter<CharSequence> adapter3= ArrayAdapter.createFromResource(this,R.array.villes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnersviles.setAdapter(adapter3);



    }
    public void insererannonce(View view){
        EditText titregrand = findViewById(R.id.editTextEmail);
        String titre1 = titregrand.getText().toString();

        Spinner spinnerVille = findViewById(R.id.spinnerVille);
        String ville = spinnerVille.getSelectedItem().toString();

        Spinner spinnercategories = findViewById(R.id.spinnercategories);
        String categorie = spinnercategories.getSelectedItem().toString();

        Spinner spinnersecteur = findViewById(R.id.spinnersecteur);
        String secteur = spinnersecteur.getSelectedItem().toString();



        EditText typegrand = findViewById(R.id.editTextContrat);
        String type = typegrand.getText().toString();
        EditText descriptiongrand = findViewById(R.id.editTextDescription);
        String desc= descriptiongrand.getText().toString();


        base2 db=new base2(this);
        db.insertnewannonce(titre1,ville,secteur,categorie,type,desc);
        Intent myintent=new Intent(this, MainActivity5.class);
        startActivity(myintent);
         int a=db.countAnnoncesByVille(ville);
        Bundle b=new Bundle();
        b.putInt("nombre",a);
        b.putString("ville1",ville);
        Intent myintent1=new Intent(this, MainActivity5.class);
        myintent1.putExtras(b);
        startActivity(myintent1);




    }


}