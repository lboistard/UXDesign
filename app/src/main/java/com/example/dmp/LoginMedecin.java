package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmp.Database.DBManagerMedecin;
import com.example.dmp.Database.DBManagerPatient;

public class LoginMedecin extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Class/Object declaration
    //~-------------------------------------------------
    private DBManagerMedecin dbManagerMed;
    private SimpleCursorAdapter adapter;
    String numCpsFinal;

    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView toPatient, medecinTextView;
    ImageView logoMedecin;
    EditText emailMedecin, passwordMedecin, numCPS;
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
        numCPS = findViewById(R.id.numCPS);
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

        dbManagerMed = new DBManagerMedecin(this);
        dbManagerMed.openDBMedecin();
        Cursor cursor = dbManagerMed.fetch();
    }

    //~-------------------------------------------------
    //~ Method that link to the "User login page"
    //~-------------------------------------------------
    public void toPatient(View view) {
        Intent intent = new Intent(LoginMedecin.this, MainActivity.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Connect to a med account
    //~-------------------------------------------------
    public void connectMed(View view){

        //Catch data from input
        String email = emailMedecin.getText().toString();
        String password = passwordMedecin.getText().toString();
        String cps = numCPS.getText().toString();

        //ask if user exist
        String numCps = dbManagerMed.checkUserExist(email, password, cps);



        //If user exist, go to next page
        if(numCps != "false"){
            numCpsFinal = cps;

            Intent intent = new Intent(LoginMedecin.this, AccueilMedecinActivity.class);
            intent.putExtra("numCps", numCpsFinal);
            startActivity(intent);

        }

    }

    //~-------------------------------------------------
    //~ Method that link to the "Create Med Acccount"
    //~-------------------------------------------------
    public void createMedAccount(View view) {

        Intent intent = new Intent(LoginMedecin.this, CreateAccountMed.class);
        startActivity(intent);

    }



}
