package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmp.Dialogs.ChangePasswordDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class ComptePatientActivity extends AppCompatActivity {

	//~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
	TextView textComptePatient, textInfosPatient, textNumSecuPatient, inputNumSecu,
	textEmailPatient, inputEmailPatient, textPasswordPatientQuestion;
	ImageView logoComptePatient;
	Dialog epicDial ;
	Button cancel, ok ,buttonComments ;

    //~-------------------------------------------------
    //~ Global Variables (intent)
    //~-------------------------------------------------
    String NUMSECU;
    String EMAIL;
    String RESPONSE = "";
    Intent intent;




    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    private void initComponents(){

        textComptePatient = (TextView)findViewById(R.id.textComptePatient);
        textInfosPatient = (TextView)findViewById(R.id.textInfosPatient);
        textNumSecuPatient = (TextView)findViewById(R.id.textNumSecuPatient);
        inputNumSecu = (EditText)findViewById(R.id.inputNumSecu);
        textEmailPatient = (TextView)findViewById(R.id.textEmailPatient);
        inputEmailPatient = (EditText)findViewById(R.id.inputEmailPatient);
        textPasswordPatientQuestion = (TextView)findViewById(R.id.textPasswordPatientQuestion);
        logoComptePatient = (ImageView)findViewById(R.id.logoComptePatient);
        buttonComments = (Button) findViewById(R.id.buttonComments);
    }

	//~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte_patient);
        initComponents();

        //disable  edition of input patient
       inputEmailPatient.setEnabled(false);
       inputNumSecu.setEnabled(false);



        intent = getIntent();
        NUMSECU = intent.getExtras().getString("NUMSECU");
        EMAIL = intent.getExtras().getString("EMAIL");
        RESPONSE = intent.getExtras().getString("RESPONSE");

        //ajoute snackbar si update ok
        inputNumSecu.setText(NUMSECU);
        inputEmailPatient.setText(EMAIL);

        //ask db for values
        buttonComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(ComptePatientActivity.this);
                builder.setTitle("Un commentaire ?");
                builder.setMessage("Vous êtes sur le point d'être redirigé vers notre page commentaires, "+"" +
                        "cliquez sui 'oui' si vous souhaitez être redirigé");

                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toCommentSection();
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



        textPasswordPatientQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(ComptePatientActivity.this);
                builder.setTitle("Changement de mot de passe ?");
                builder.setMessage("Etes-vous sur de vouloir ajouter un commentaire ?");



                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toPassword();
                    }
                });
                builder.show();
            }
        });
    }


    public void toPassword(){
        Intent intent = new Intent(this, PasswordChange.class);
        intent.putExtra("NUMSECU", NUMSECU);
        intent.putExtra("EMAIL", EMAIL);
        startActivity(intent);
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

    public void toCommentSection() {
        Intent intent = new Intent(this, CommentairesPatientsActivity.class);
        startActivity(intent);

    }
}