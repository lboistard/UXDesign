package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class CreateAccountMed extends AppCompatActivity {

    Button patientButton;
    String YOURCOLOR = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_med);


        patientButton = findViewById(R.id.PatientButton);

        int TEXTcolor = Integer.parseInt("000000", 16)+0xFF000000;
        int BORDERcolor = Integer.parseInt("8FD80A12", 16)+0xFF000000;
        patientButton.setTextColor(TEXTcolor);


    }
}