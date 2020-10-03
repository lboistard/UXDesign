package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CommentairesPatientsActivity extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Go to patient Comments Section
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentaires_patients);
    }

    //~-------------------------------------------------
    //~ Go to patient Home
    //~-------------------------------------------------
    public void toPatientHome(View view) {
        Intent intent = new Intent(this, AccueilPatientActivity.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Go to patient Account
    //~-------------------------------------------------
    public void toAccount(View view) {
        Intent intent = new Intent(this, ComptePatientActivity.class);
        startActivity(intent);

    }
}