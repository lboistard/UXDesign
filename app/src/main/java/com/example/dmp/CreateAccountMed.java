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

public class CreateAccountMed extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Class/Object declaration
    //~-------------------------------------------------
    private DBManagerMedecin dbManagerMedecin;
    private SimpleCursorAdapter adapter;

    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView createMedAccountTextView,confirmPasswordTextView, toSignInMedecin;
    ImageView logoCreateMedAccount;
    EditText emailMedecin, passwordMedecin,passwordAgainMedecin, numCPSMed;
    Button createMedAccountButton;

    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    public void createAccountComponents(){
        createMedAccountTextView = findViewById(R.id.createMedAccountTextView);
        confirmPasswordTextView = findViewById(R.id.confirmPasswordTextView);
        logoCreateMedAccount = findViewById(R.id.logoCreateMedAccount);
        emailMedecin = findViewById(R.id.emailMedecin);
        passwordMedecin = findViewById(R.id.passwordMedecin);
        passwordAgainMedecin = findViewById(R.id.passwordAgainMedecin);
        numCPSMed = findViewById(R.id.numCPSMed);
        createMedAccountButton = findViewById(R.id.createMedAccountButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_account_med);
        createAccountComponents();

        dbManagerMedecin = new DBManagerMedecin(this);
        dbManagerMedecin.openDBMedecin();
        Cursor cursor = dbManagerMedecin.fetch();


    }

    //~-------------------------------------------------
    //~ Account Creation, connect to database
    //~-------------------------------------------------
    public void createMedAccount(View view) {

        String emailMed = emailMedecin.getText().toString();
        String passwordMed = passwordMedecin.getText().toString();
        String numCPS = numCPSMed.getText().toString();

        System.out.println("email : " + emailMed + " password : " +  passwordMed + " numsecu : " +  numCPS);

        dbManagerMedecin.insertMedecin(emailMed, passwordMed, numCPS);

        Intent intent = new Intent(getApplicationContext(), LoginMedecin.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Method that link to the "Medecin login page"
    //~-------------------------------------------------
    public void toMedecin(View view) {
        Intent intent = new Intent(CreateAccountMed.this, LoginMedecin.class);
        startActivity(intent);
    }
}