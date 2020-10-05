package com.example.dmp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dmp.Database.DBManagerInfosPatient;
import com.example.dmp.Database.DBManagerPatient;
import com.google.android.material.snackbar.Snackbar;

public class PasswordChange extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Global Variables (intent)
    //~-------------------------------------------------
    String NUMSECU, EMAIL;
    Intent intent;
    String password, newPassword;

    //~-------------------------------------------------
    //~ Database elements declaration
    //~-------------------------------------------------
    private DBManagerPatient dbManagerPatient;
    private SimpleCursorAdapter adpater;


    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    EditText inputPassword, inputNewPasswordAgain;

    //~-------------------------------------------------
    //~ components attribution
    //~-------------------------------------------------
    public void initComponents(){
        inputNewPasswordAgain = findViewById(R.id.inputNewPasswordAgain);
        inputPassword = findViewById(R.id.inputPassword);
    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change_patient);

        initComponents();

        intent = getIntent();
        NUMSECU = intent.getExtras().getString("NUMSECU");
        EMAIL = intent.getExtras().getString("EMAIL");


        //db
        dbManagerPatient = new DBManagerPatient(this);
        dbManagerPatient.openDBPatient();
        Cursor cursor = dbManagerPatient.fetch();
    }

    //~-------------------------------------------------
    //~ on "annulé" click
    //~-------------------------------------------------
    public void toAccountUser(View view) {
        Intent intent = new Intent(this, ComptePatientActivity.class);

        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);

        startActivity(intent);
    }

    String response;
    //~-------------------------------------------------
    //~ on "annulé" click
    //~-------------------------------------------------
    public void toChangePassword(View view) {

        password = inputPassword.getText().toString();
        newPassword = inputNewPasswordAgain.getText().toString();

       response = dbManagerPatient.passwordUpdate(password, newPassword, NUMSECU);

        if(response  == "false"){
            Snackbar snackbar = Snackbar.make(view,"Le mot de passe actuel saisi est eronné, veuillez recommmencer ",Snackbar.LENGTH_SHORT);
            snackbar.show();
        }else{
            //if password guud
            Intent intent = new Intent(this, ComptePatientActivity.class);
            intent.putExtra("NUMSECU", NUMSECU);
            intent.putExtra("EMAIL", EMAIL);
            intent.putExtra("RESPONSE", "true");
            startActivity(intent);
        }

    }


}
