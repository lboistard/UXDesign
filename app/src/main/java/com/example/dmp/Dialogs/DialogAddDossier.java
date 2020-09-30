package com.example.dmp.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


import com.example.dmp.R;

public class DialogAddDossier extends Dialog {

    public interface FullNameListener {
        void fullNameEntered(String fullName);
    }

    public Context context;

    private EditText editTextFullName;
    private Button buttonOK;
    private Button buttonCancel;

    public DialogAddDossier.FullNameListener listener;

    public DialogAddDossier(Context context, DialogAddDossier.FullNameListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_change_password_patient);



        //this.editTextFullName = (EditText) findViewById(R.id.editText_fullName);
        this.buttonOK = (Button) findViewById(R.id.button_ok);
        this.buttonCancel  = (Button) findViewById(R.id.button_cancel);


        this.buttonOK .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOKClick();
            }
        });
        this.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCancelClick();
            }
        });
    }
    // User click "OK" button.
    private void buttonOKClick()  {
        String fullName = this.editTextFullName.getText().toString();

        if(fullName== null || fullName.isEmpty())  {
            Toast.makeText(this.context, "Please enter your name", Toast.LENGTH_LONG).show();
            return;
        }
        this.dismiss(); // Close Dialog

        if(this.listener!= null)  {
            this.listener.fullNameEntered(fullName);
        }
    }

    // User click "Cancel" button.
    private void buttonCancelClick()  {
        this.dismiss();
    }
}