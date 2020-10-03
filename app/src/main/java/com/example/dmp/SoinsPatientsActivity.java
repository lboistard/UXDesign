package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SoinsPatientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soins_patients);
    }

    //~-------------------------------------------------
    //~ to Patient account activity
    //~-------------------------------------------------
    public void toPatientAccount(View view) {
        Intent intent = new Intent(this, ComptePatientActivity.class);
        startActivity(intent);
    }

    public void toAccueilPatient(View view) {
        Intent intent = new Intent(this, AccueilPatientActivity.class);
        startActivity(intent);
    }
}