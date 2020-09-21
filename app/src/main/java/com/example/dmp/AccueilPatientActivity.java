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

    //~-------------------------------------------------
    //~ Class/Object declaration
    //~-------------------------------------------------
    private DBManagerPatient dbManagerPatient;
    private SimpleCursorAdapter adapter;


    //Variables
    private String numeroSecu;

    //
    TextView e;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_patient);

        TextView TextNumeroS = findViewById(R.id.TextNumeroS);
        Intent intent = getIntent();

        numeroSecu =  intent.getStringExtra("numSecu");

        TextNumeroS.setText(numeroSecu);

        dbManagerPatient = new DBManagerPatient(this);
        dbManagerPatient.openDBPatient();
        Cursor cursor = dbManagerPatient.fetch();
    }

    public void toPatientAccount(View view) {

        System.out.println("TESSSSSSSSSST");

        String de = dbManagerPatient.getPatientInfos(numeroSecu);
        System.out.println(de);

    }
}