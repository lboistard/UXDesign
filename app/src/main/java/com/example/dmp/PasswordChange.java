package com.example.dmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordChange extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Global Variables (intent)
    //~-------------------------------------------------
    String NUMSECU;
    String EMAIL;
    Intent intent;

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change_patient);

        intent = getIntent();
        NUMSECU = intent.getExtras().getString("NUMSECU");
        EMAIL = intent.getExtras().getString("EMAIL");
    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    public void toAccountUser(View view) {
        Intent intent = new Intent(this, ComptePatientActivity.class);

        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);

        startActivity(intent);
    }
}
