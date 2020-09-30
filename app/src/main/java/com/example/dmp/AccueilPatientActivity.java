package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dmp.Database.DBManagerPatient;

import java.util.HashMap;

public class AccueilPatientActivity extends AppCompatActivity {

    
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_patient);

       
        Intent intent = getIntent();



    }

    //~-------------------------------------------------
    //~ Go to patient account management activity
    //~-------------------------------------------------
    public void toPatientAccount(View view) {

        Intent intent = new Intent(this, ComptePatientActivity.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Go to patient "Traitements et Soins" activity
    //~-------------------------------------------------
    public void toSoins(View view) {
        Intent intent = new Intent(this, SoinsPatientsActivity.class);
        startActivity(intent);

    }

    public void toBiologie(View view) {
        Intent intent = new Intent(this, BiologiePatientActivity.class);
        startActivity(intent);

    }

    public void toCompteRendus(View view) {
        Intent intent = new Intent(this, CompteRenduPatient.class );
    }
}