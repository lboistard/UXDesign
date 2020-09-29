package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AccueilMedecinActivity extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView  textDossiers, textNumCps, inputNumCps, textNomTab,textDateTab, textActionTab;
    ImageView logoMedecin;
    Button buttonAccountMed, buttonInfoMed, buttonHomeMed;


    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    private void initComponents(){

        textDossiers = (TextView)findViewById(R.id.textDossiers);
        textNumCps = (TextView)findViewById(R.id.textNumCps);
        inputNumCps = (TextView)findViewById(R.id.inputNumCps);
        textNomTab = (TextView)findViewById(R.id.textNomTab);
        textDateTab = (TextView)findViewById(R.id.textDateTab);
        textActionTab = (TextView)findViewById(R.id.textActionTab);
        logoMedecin = (ImageView)findViewById(R.id.logoMedecin);
        buttonAccountMed = (Button)findViewById(R.id.buttonAccountMed);
        buttonInfoMed = (Button)findViewById(R.id.buttonInfoMed);
        buttonHomeMed = (Button)findViewById(R.id.buttonHomeMed);   
    }


    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_medecin);
        initComponents();

        Intent intent = getIntent();
        String var =  intent.getStringExtra("numCps");
        inputNumCps.setText(var);
    }

    //~-------------------------------------------------
    //~ button that link to medecin account
    //~-------------------------------------------------
    public void toMedecinAccount(View view) {
        Intent intent = new Intent(this, CompteMedecinActivity.class);
        startActivity(intent);

    }

    //~-------------------------------------------------
    //~ button that link to medecin informations
    //~-------------------------------------------------
    public void toInfoMedecin(View view) {


    }

    //~-------------------------------------------------
    //~ button that link to medecin home (login here)
    //~-------------------------------------------------
    public void toHomeMedecin(View view) {
        Intent intent = new Intent(this, LoginMedecin.class);
        startActivity(intent);
    }
}