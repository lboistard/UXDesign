package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

import com.example.dmp.Database.DBManagerInfosPatient;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class BiologiePatientActivity extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Database elements declaration
    //~-------------------------------------------------
    private DBManagerInfosPatient dbManagerInfosPatient;
    private SimpleCursorAdapter adpater;

    //~-------------------------------------------------
    //~ Global Variables (intent)
    //~-------------------------------------------------
    String NUMSECU;
    String EMAIL;
    Intent intent;
    Button buttonCommentPatients;


    //~-------------------------------------------------
    //~ Window init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biologie_patient);

        buttonCommentPatients = findViewById(R.id.buttonCommentsPatient);

        //db
        dbManagerInfosPatient = new DBManagerInfosPatient(this);
        dbManagerInfosPatient.openDBInfosPatient();
        Cursor cursor = dbManagerInfosPatient.fetch();

        //get NUMSECU
        intent = getIntent();
        NUMSECU = intent.getExtras().getString("NUMSECU");
        EMAIL = intent.getExtras().getString("EMAIL");

        //get patient data
        getBiologiePatientData();

        //~--------------------------
        //~ click on comments section
        //~--------------------------
        buttonCommentPatients.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(BiologiePatientActivity.this);
                builder.setTitle("Un commentaire ?");
                builder.setMessage("Vous êtes sur le point d'être redirigé vers notre page commentaires, "+"" +
                        "cliquez sui 'oui' si vous souhaitez être redirigé");

                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toComments();
                    }
                });

                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
    }

    //~-------------------------------------------------
    //~ Go to patient account management activity
    //~-------------------------------------------------
    public void getBiologiePatientData(){


    }


    //~-------------------------------------------------
    //~ Go to patient account management activity
    //~-------------------------------------------------
    public void toPatientAccount(View view) {
        Intent intent = new Intent(getApplicationContext(), ComptePatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);
        startActivity(intent);
    }

    public void toComments(){
        Intent intent = new Intent(this, CommentairesPatientsActivity.class);
        startActivity(intent);
    }

    public void toHomePatient(View view) {
        Intent intent = new Intent(getApplicationContext(), AccueilPatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        startActivity(intent);
    }
}