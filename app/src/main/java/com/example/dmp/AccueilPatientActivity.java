package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AccueilPatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_patient);

        TextView TextNumeroS = findViewById(R.id.TextNumeroS);
        Intent intent = getIntent();
        String var =  intent.getStringExtra("numSecu");

        TextNumeroS.setText(var);
    }
}