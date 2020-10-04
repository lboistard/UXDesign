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

import com.example.dmp.Database.DBManagerInfosPatient;
import com.example.dmp.Database.DBManagerPatient;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Class/Object declaration
    //~-------------------------------------------------
    private DBManagerPatient dbManagerPatient;
    private DBManagerInfosPatient dbInfosPatient;
    private SimpleCursorAdapter adapter;


    String bioDate;
    String datas;
    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView toMedecin, patientTextView;
    ImageView logoPatient;
    EditText emailPatient, passwordPatient, numSecuPatient;
    Button buttonConnexionPatient, buttonCreationComptePatient;

    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    public void patientComponents(){
        toMedecin = findViewById(R.id.toMedecin);
        patientTextView = findViewById(R.id.textComptePatient);
        logoPatient = findViewById(R.id.logoComptePatient);
        emailPatient = findViewById(R.id.emailPatient);
        passwordPatient = findViewById(R.id.passwordPatient);
        numSecuPatient = findViewById(R.id.numSecuPatient);
        buttonConnexionPatient = findViewById(R.id.buttonConnexionPatient);
        buttonCreationComptePatient = findViewById(R.id.buttonCreationComptePatient);

    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        patientComponents();

        dbInfosPatient = new DBManagerInfosPatient(this);
        dbInfosPatient.openDBInfosPatient();

       //bioDate = dbInfosPatient.getBioInfos("1");
        //datas = dbInfosPatient.getCompteRendusInfos("2");


        //dbManagerPatient = new DBManagerPatient(this);
        //dbManagerPatient.openDBPatient();
        //Cursor cursor = dbManagerPatient.fetch();
    }

    //~-------------------------------------------------
    //~ Method that link to the "Medecin login page"
    //~-------------------------------------------------
    public void toMedecin(View view) {
        Intent intent = new Intent(MainActivity.this, LoginMedecin.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Method that link to the "Create account page"
    //~-------------------------------------------------
    public void toCreateAccount(View view){
        Intent intent = new Intent(MainActivity.this, CreateAccountPatient.class);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Method that connect the patient to his page
    //~-------------------------------------------------
    public void connectPatient(View view) {

        //Catch data
        String email = emailPatient.getText().toString();
        String password = passwordPatient.getText().toString();
        String numSecu = numSecuPatient.getText().toString();

        //ask if user exist
       // String numReturn = dbManagerPatient.checkUserExist(email, password, numSecu);
        //dbManagerPatient.close();

        //If user exist, go to next page
        //if(numReturn != "false"){
        Intent intent = new Intent(MainActivity.this, AccueilPatientActivity.class);
        intent.putExtra("NUMSECU", "689822974");
        intent.putExtra("EMAIL", "Lucas.boistard@hotmail.fr");
        startActivity(intent);
       // }
    }
}
