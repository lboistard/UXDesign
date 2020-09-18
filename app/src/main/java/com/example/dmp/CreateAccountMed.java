package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccountMed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_med);
    }


    //~-------------------------------------------------
    //~ Method that link to the "Medecin login page"
    //~-------------------------------------------------
    public void toPatient(View view) {
        Intent intent = new Intent(CreateAccountMed.this, LoginMedecin.class);
        startActivity(intent);
    }
}