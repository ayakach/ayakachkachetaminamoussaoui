package com.example.kachkach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main5);
        Bundle b=getIntent().getExtras();
        int nb=b.getInt("nombre");
        String ville=b.getString("ville1");
        TextView txt=findViewById(R.id.textaffich);
        String s="Il y a Actuellement";
        String s2="sur";

        txt.setText(s+nb+s2+ville);
    }
    public void backClick(View view)
    {
        Intent myintent2=new Intent(this, MainActivity2.class);
        startActivity(myintent2);
    }

}