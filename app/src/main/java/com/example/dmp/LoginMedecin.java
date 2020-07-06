package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginMedecin extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView toPatient, medecinTextView;
    ImageView logoMedecin;
    EditText emailMedecin, passwordMedecin;
    Button buttonConnexionMedecin, buttonCreationCompteMedecin;

    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    public void medicalComponents(){
        toPatient = findViewById(R.id.toPatient);
        medecinTextView = findViewById(R.id.medecinTextView);
        logoMedecin = findViewById(R.id.logoMedecin);
        emailMedecin = findViewById(R.id.emailMedecin);
        passwordMedecin = findViewById(R.id.passwordMedecin);
        buttonConnexionMedecin = findViewById(R.id.buttonConnexionMedecin);
        buttonCreationCompteMedecin = findViewById(R.id.buttonCreationCompteMedecin);
    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_medecin);

        medicalComponents();
    }

    //~-------------------------------------------------
    //~ Method that link to the "User login page"
    //~-------------------------------------------------
    public void toPatient(View view) {
        Intent intent = new Intent(LoginMedecin.this, MainActivity.class);
        startActivity(intent);
    }



}
