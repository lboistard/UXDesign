package com.example.dmp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dmp.Database.DBManagerCommentairesPatient;
import com.example.dmp.Database.DBManagerPatient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentairesPatientsActivity extends AppCompatActivity {

    EditText editTextInstructions;
    EditText textInputComment;

    //~-------------------------------------------------
    //~ Class/Object declaration
    //~-------------------------------------------------
    private DBManagerCommentairesPatient dbManagerCommentairesPatient;
    private SimpleCursorAdapter adapter;

    //~-------------------------------------------------
    //~ Global Variables (intent)
    //~-------------------------------------------------
    String NUMSECU;
    String EMAIL;
    Intent intent;
    private String comment, time;
    DateTimeFormatter dtf;
    LocalDateTime now;

    public void initComponents(){

        editTextInstructions = findViewById(R.id.editTextInstructions);
        textInputComment = findViewById(R.id.textInputComment);
    }


    //~-------------------------------------------------
    //~ Go to patient Comments Section
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentaires_patients);

        initComponents();

        intent = getIntent();
        NUMSECU = intent.getExtras().getString("NUMSECU");
        EMAIL = intent.getExtras().getString("EMAIL");

        editTextInstructions.setEnabled(false);
    }

    //~-------------------------------------------------
    //~ Go to patient Home
    //~-------------------------------------------------
    public void toPatientHome(View view) {
        Intent intent = new Intent(this, AccueilPatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);
        startActivity(intent);
    }

    //~-------------------------------------------------
    //~ Go to patient Account
    //~-------------------------------------------------
    public void toAccount(View view) {
        Intent intent = new Intent(this, ComptePatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);
        startActivity(intent);

    }

    //
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ajoutComment(View view) {

        dbManagerCommentairesPatient = new DBManagerCommentairesPatient(this);
        dbManagerCommentairesPatient.openDBCommentsPatient();
        Cursor cursor = dbManagerCommentairesPatient.fetch();


        comment = textInputComment.getText().toString();
        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        now = LocalDateTime.now();
        time = dtf.format(now);


        dbManagerCommentairesPatient.addComment(comment, time, NUMSECU);

        Intent intent = new Intent(this, AccueilPatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);
        startActivity(intent);
    }

    public void cancelAction(View view) {
        Intent intent = new Intent(this, AccueilPatientActivity.class);
        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);
        startActivity(intent);

    }
}