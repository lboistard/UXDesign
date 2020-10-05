package com.example.dmp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
    TableLayout table_layout1;
    TableLayout table_layout2;

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
        table_layout1 = findViewById(R.id.tableLayout1);
        table_layout2 = findViewById(R.id.tableLayout2);

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

        int index1 = 0;
        for (String key : SOINS_DATAS.keySet()) {
            TableRow row = new TableRow(this);

            TextView tv1 = new TextView(this);
            tv1.setPadding(25, 10, 25, 25);
            tv1.setText(SOINS_DATAS.get(key));

            TextView tv2 = new TextView(this);
            tv2.setPadding(25, 10, 25, 25);
            tv2.setGravity(Gravity.RIGHT);
            tv2.setText(key);

            if (index1 % 2 == 0){
                tv1.setBackgroundColor(Color.parseColor("#e4e4e4"));
                tv2.setBackgroundColor(Color.parseColor("#e4e4e4"));
            }

            row.addView(tv1);
            row.addView(tv2);

            table_layout1.addView(row);
            index1++;
        }

        int index2 = 0;
        for (String key : TRAITEMENTS_DATAS.keySet()) {
            TableRow row = new TableRow(this);

            TextView tv1 = new TextView(this);
            tv1.setPadding(25, 10, 25, 25);
            tv1.setText(TRAITEMENTS_DATAS.get(key));

            TextView tv2 = new TextView(this);
            tv2.setPadding(25, 10, 25, 25);
            tv2.setGravity(Gravity.RIGHT);
            tv2.setText(key);

            if (index2 % 2 == 0){
                tv1.setBackgroundColor(Color.parseColor("#e4e4e4"));
                tv2.setBackgroundColor(Color.parseColor("#e4e4e4"));
            }

            row.addView(tv1);
            row.addView(tv2);

            table_layout2.addView(row);
            index2++;
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