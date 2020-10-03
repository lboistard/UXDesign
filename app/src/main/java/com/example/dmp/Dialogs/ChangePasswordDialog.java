package com.example.dmp.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.dmp.R;

public class ChangePasswordDialog extends Dialog {

    //~-------------------------------------------------
    //~ Declaration
    //~-------------------------------------------------
    public Context context;
    public ChangePasswordDialog.FullNameListener listener;

    //~-------------------------------------------------
    //~ Components Declaration
    //~-------------------------------------------------
    EditText inputPassword, inputNewPasswordAgain;
    TextView textPasswordChange;
    Button button_ok, button_cancel;

    //~-------------------------------------------------
    //~ Components Initialization method
    //~-------------------------------------------------
    public void changePasswordComponents(){
        textPasswordChange = findViewById(R.id.textPasswordChange);
        inputPassword = findViewById(R.id.inputPassword);
        inputNewPasswordAgain = findViewById(R.id.inputNewPasswordAgain);
        button_cancel = findViewById(R.id.button_cancel);
        button_ok = findViewById(R.id.button_ok);
    }

    //~-------------------------------------------------
    //~
    //~-------------------------------------------------
    public interface FullNameListener {
        void fullNameEntered(String fullName);
    }

    //~-------------------------------------------------
    //~ Listener to the dialog
    //~-------------------------------------------------
    public ChangePasswordDialog(Context context, ChangePasswordDialog.FullNameListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    //~-------------------------------------------------
    //~ Init method
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_password_change_patient);
        changePasswordComponents();

        //if Ok is pressed
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = inputPassword.getText().toString();
                System.out.println(text);
            }
        });

        //if annule is pressed
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

}