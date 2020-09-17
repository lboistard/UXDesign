package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView toMedecin, patientTextView;
    ImageView logoPatient;
    EditText emailPatient, passwordPatient;
    Button buttonConnexionPatient, buttonCreationComptePatient;

    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    public void patientComponents(){
        toMedecin = findViewById(R.id.toMedecin);
        patientTextView = findViewById(R.id.patientTextView);
        logoPatient = findViewById(R.id.logoPatient);
        emailPatient = findViewById(R.id.emailPatient);
        passwordPatient = findViewById(R.id.passwordPatient);
        buttonConnexionPatient = findViewById(R.id.buttonConnexionPatient);
        buttonCreationComptePatient = findViewById(R.id.buttonCreationComptePatient);

    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        patientComponents();
    }

    //~-------------------------------------------------
    //~ Method that link to the "Medecin login page"
    //~-------------------------------------------------
    public void toMedecin(View view) {
        Intent intent = new Intent(MainActivity.this, LoginMedecin.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Method that link to the "Create account page"
    //~-------------------------------------------------
    public void toCreateAccount(View view){
        Intent intent = new Intent(MainActivity.this, CreateAccountPatient.class);
        startActivity(intent);
    }
}
