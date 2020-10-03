package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmp.Database.DBManagerPatient;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.HashMap;

public class AccueilPatientActivity extends AppCompatActivity {


    //~-------------------------------------------------
    //~ Components Declaration
    //~-------------------------------------------------
    Button buttonDecoPatient, buttonBiologie, buttonImagerieMedical, buttonCompteRendu, buttonTraitement, buttonCommentsPatient;
    TextView textPatient, textNumSecu, inputNumSecu;
    ImageView logoAccueilPatient;

    //~-------------------------------------------------
    //~ Components init method
    //~-------------------------------------------------
    public void initComponents(){

        buttonDecoPatient = findViewById(R.id.buttonDecoPatient);
        buttonBiologie = findViewById(R.id.buttonBiologie);
        buttonImagerieMedical = findViewById(R.id.buttonImagerieMedical);
        buttonCompteRendu = findViewById(R.id.buttonCompteRendu);
        buttonTraitement = findViewById(R.id.buttonTraitement);
        textPatient = findViewById(R.id.textPatient);
        textNumSecu = findViewById(R.id.textNumSecu);
        inputNumSecu = findViewById(R.id.inputNumSecu);
        logoAccueilPatient = findViewById(R.id.logoAccueilPatient);
        buttonCommentsPatient = findViewById(R.id.buttonCommentsPatient);
    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_patient);

        initComponents();

        buttonCommentsPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AccueilPatientActivity.this);
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




        //~-----------------
        //~To deconnect user
        //~-----------------
        buttonDecoPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AccueilPatientActivity.this);
                builder.setTitle("Vous nous quittez ?");
                builder.setMessage("Etes-vous sur de vouloir vous déconnecter ?");
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toMainMenu();
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
       
        Intent intent = getIntent();

    }

    //~-------------------------------------------------
    //~ Go to patient Comments Section
    //~-------------------------------------------------
    public void toComments(){
        Intent intent = new Intent(this, CommentairesPatientsActivity.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Go to patient account management activity
    //~-------------------------------------------------
    public void toMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Go to patient account management activity
    //~-------------------------------------------------
    public void toPatientAccount(View view) {

        Intent intent = new Intent(this, ComptePatientActivity.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Go to patient "Traitements et Soins" activity
    //~-------------------------------------------------
    public void toSoins(View view) {
        Intent intent = new Intent(this, SoinsPatientsActivity.class);
        startActivity(intent);

    }

    //~-------------------------------------------------
    //~ Go to patient Soins
    //~-------------------------------------------------
    public void toBiologie(View view) {
        Intent intent = new Intent(this, BiologiePatientActivity.class);
        startActivity(intent);

    }

    //~-------------------------------------------------
    //~ Go to patient Compte rendu activity
    //~-------------------------------------------------
    public void toCompteRendus(View view) {
        Intent intent = new Intent(this, CompteRenduActivity.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Go to patient Imagerie Patient activity
    //~-------------------------------------------------
    public void toImageriePatient(View view) {
        Intent intent = new Intent(this, ImageriePatientActivity.class);
        startActivity(intent);
    }
}