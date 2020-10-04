package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ImageriePatientActivity extends AppCompatActivity {
    //~-------------------------------------------------
    //~ Global Variables (intent)
    //~-------------------------------------------------
    String NUMSECU;
    String EMAIL;
    Intent intent;
    Button buttonCommentPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagerie_patient);

        buttonCommentPatients = findViewById(R.id.buttonCommentsPatient);

        intent = getIntent();
        NUMSECU = intent.getExtras().getString("NUMSECU");
        EMAIL = intent.getExtras().getString("EMAIL");

        //~--------------------------
        //~ click on comments section
        //~--------------------------
        buttonCommentPatients.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(ImageriePatientActivity.this);
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
    //~ to Patient account activity
    //~-------------------------------------------------
    public void toPatientAccount(View view) {
        Intent intent = new Intent(this, ComptePatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ to Patient Home activity
    //~-------------------------------------------------
    public void toAccueilPatient(View view) {
        Intent intent = new Intent(this, AccueilPatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        startActivity(intent);
    }

    public void toComments() {
        Intent intent = new Intent(this, CommentairesPatientsActivity.class);
        startActivity(intent);
    }
}