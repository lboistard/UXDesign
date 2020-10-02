package com.example.dmp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmp.Dialogs.ChangePasswordDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ComptePatientActivity extends AppCompatActivity {

	//~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
	TextView textComptePatient, textInfosPatient, textNumSecuPatient, inputNumSecu,
	textEmailPatient, inputEmailPatient, textPasswordPatientQuestion;
	ImageView logoComptePatient;
	Dialog epicDial ;

	Button cancel, ok ,buttonInfo ;




	//~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    private void initComponents(){

        textComptePatient = (TextView)findViewById(R.id.textComptePatient);
        textInfosPatient = (TextView)findViewById(R.id.textInfosPatient);
        textNumSecuPatient = (TextView)findViewById(R.id.textNumSecuPatient);
        inputNumSecu = (TextView)findViewById(R.id.textNumSecu);
        textEmailPatient = (TextView)findViewById(R.id.textEmailPatient);
        inputEmailPatient = (TextView)findViewById(R.id.inputEmailPatient);
        textPasswordPatientQuestion = (TextView)findViewById(R.id.textPasswordPatientQuestion);
        logoComptePatient = (ImageView)findViewById(R.id.logoComptePatient);
        buttonInfo = (Button) findViewById(R.id.buttonInfo);
    }

	//~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte_patient);
        initComponents();


        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(ComptePatientActivity.this);
                builder.setTitle("Ajout");
                builder.setMessage("Etes-vous sur de vouloir ajouter un commentaire ?");
                builder.show();
            }
        });
    }


    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    public void toModifyPassword(View view) {


        this.textPasswordPatientQuestion.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                buttonOpenDialogClicked();
            }
        });
    }

    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    private void buttonOpenDialogClicked()  {

        ChangePasswordDialog.FullNameListener listener = new ChangePasswordDialog.FullNameListener() {
            @Override
            public void fullNameEntered(String fullName) {
                Toast.makeText(ComptePatientActivity.this, "" , Toast.LENGTH_SHORT).show();
            }
        };
        final ChangePasswordDialog dialog = new ChangePasswordDialog(this, listener);
        dialog.show();
    }

    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    public void toPatientHome(View view) {
        Intent intent = new Intent(this, AccueilPatientActivity.class);
        startActivity(intent);
    }
}