package com.example.dmp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dmp.Database.DBManagerInfosPatient;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.HashMap;
import java.util.Map;

public class SoinsPatientsActivity extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Global Variables (intent)
    //~-------------------------------------------------
    String NUMSECU, ID_PATIENT;
    String EMAIL;
    Intent intent;
    Button buttonCommentPatients;

    Map<String,String> SOINS_DATAS = new HashMap<>();
    Map<String,String> TRAITEMENTS_DATAS = new HashMap<>();

    //~-------------------------------------------------
    //~ Database elements declaration
    //~-------------------------------------------------
    private DBManagerInfosPatient dbManagerInfosPatient;
    private SimpleCursorAdapter adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soins_patients);

        buttonCommentPatients = findViewById(R.id.buttonCommentsPatient);

        //db
        dbManagerInfosPatient = new DBManagerInfosPatient(this);
        dbManagerInfosPatient.openDBInfosPatient();
        Cursor cursor = dbManagerInfosPatient.fetch();

        intent = getIntent();
        NUMSECU = intent.getExtras().getString("NUMSECU");
        EMAIL = intent.getExtras().getString("EMAIL");

        //Ici j'ai mis idinfo parce que c'est l'id qui permet de récuperer les éléments de la DB
        ID_PATIENT = NUMSECU;

        System.out.println(ID_PATIENT);

        //La je me connecte à la DB pour récuperer les bails
        SOINS_DATAS = dbManagerInfosPatient.getSoinsInfos(ID_PATIENT);
        TRAITEMENTS_DATAS = dbManagerInfosPatient.getTraitementsInfos(ID_PATIENT);

        for (String key : SOINS_DATAS.keySet()) {
            System.out.println(key + "=" + SOINS_DATAS.get(key));
        }

        for (String key : TRAITEMENTS_DATAS.keySet()) {
            System.out.println(key + "=" + TRAITEMENTS_DATAS.get(key));
        }


        //~--------------------------
        //~ click on comments section
        //~--------------------------
        buttonCommentPatients.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SoinsPatientsActivity.this);
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