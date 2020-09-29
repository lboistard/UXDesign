package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AccueilMedecinActivity extends AppCompatActivity {

    TextView TextNumeroS;

    private void initComponents(){

        TextNumeroS = (TextView)findViewById(R.id.numCPS);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_medecin);
        initComponents();




        Intent intent = getIntent();
        String var =  intent.getStringExtra("numCps");
        TextNumeroS.setText(var);


    }

    public void toMedecinAccount(View view) {
        Intent intent = new Intent(this, CompteMedecinActivity.class);

        startActivity(intent);

    }
}