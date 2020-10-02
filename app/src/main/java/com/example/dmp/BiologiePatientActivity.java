package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

import com.example.dmp.Database.DBManagerInfosPatient;

public class BiologiePatientActivity extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Database elements declaration
    //~-------------------------------------------------
    private DBManagerInfosPatient dbManagerInfosPatient;
    private SimpleCursorAdapter adpater;


    Button buttonInfosPatients;


    //~-------------------------------------------------
    //~ Window init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biologie_patient);

        buttonInfosPatients = findViewById(R.id.buttonInfosPatients);

        //db
        dbManagerInfosPatient = new DBManagerInfosPatient(this);
        dbManagerInfosPatient.openDBInfosPatient();
        Cursor cursor = dbManagerInfosPatient.fetch();

        //get patient data
        getBiologiePatientData();
    }

    //~-------------------------------------------------
    //~ Go to patient account management activity
    //~-------------------------------------------------
    public void getBiologiePatientData(){


    }


    //~-------------------------------------------------
    //~ Go to patient account management activity
    //~-------------------------------------------------
    public void toPatientAccount(View view) {
        Intent intent = new Intent(getApplicationContext(), AccueilPatientActivity.class);
        startActivity(intent);
    }

    public void showDataBase_elements(View view) {


    }
}