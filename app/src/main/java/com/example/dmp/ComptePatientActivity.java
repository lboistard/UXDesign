package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmp.Dialogs.DialogAddDossier;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ComptePatientActivity extends AppCompatActivity {

	//~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
	TextView textComptePatient, textInfosPatient, textNumSecuPatient, inputNumSecu,
	textEmailPatient, inputEmailPatient, textPasswordPatientQuestion;
	ImageView logoComptePatient;


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
    }

	//~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte_patient);

        initComponents();
    }

    public void toModifyPassword(View view) {

        this.textPasswordPatientQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOpenDialogClicked();
            }
        });
    }

    private void buttonOpenDialogClicked()  {
        DialogAddDossier.FullNameListener listener = new DialogAddDossier.FullNameListener() {
            @Override
            public void fullNameEntered(String fullName) {
                Toast.makeText(ComptePatientActivity.this, "Full name: " + fullName, Toast.LENGTH_LONG).show();
            }
        };
        final DialogAddDossier dialog = new DialogAddDossier(this, listener);

        dialog.show();
    }
}