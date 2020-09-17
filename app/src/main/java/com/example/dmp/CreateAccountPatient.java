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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dmp.Database.DBManager;
import com.example.dmp.Database.DatabasePatient;
import com.example.dmp.PopMessages.AccountCreated;
import com.google.android.material.snackbar.Snackbar;

public class CreateAccountPatient extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Class/Object declaration
    //~-------------------------------------------------
    private DBManager dbManager;
    private SimpleCursorAdapter adapter;
    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView createAccountTextView,confirmPasswordTextView;
    ImageView logoCreateAccount;
    EditText emailUser, passwordUser,passwordAgainUser, numSecuPatient;
    Button createAccountButton;


    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    public void createAccountComponents(){
        createAccountTextView = findViewById(R.id.createAccountTextView);
		confirmPasswordTextView = findViewById(R.id.confirmPasswordTextView);
		logoCreateAccount = findViewById(R.id.logoCreateAccount);
		emailUser = findViewById(R.id.emailUser);
		passwordUser = findViewById(R.id.passwordUser);
		passwordAgainUser = findViewById(R.id.passwordAgainUser);
        numSecuPatient = findViewById(R.id.numSecuPatient);
		createAccountButton = findViewById(R.id.createAccountButton);
    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_account_patient);
        createAccountComponents();

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();
    }

    //~-------------------------------------------------
    //~ Account Creation, connect to database
    //~-------------------------------------------------
    public void createAccount(View view) {

        String email = emailUser.getText().toString();
        String password = passwordUser.getText().toString();
        String numSecu = numSecuPatient.getText().toString();

        System.out.println("email : " + email + " password : " +  password + " numsecu : " +  numSecu);

        dbManager.insert(email, password, numSecu);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}


