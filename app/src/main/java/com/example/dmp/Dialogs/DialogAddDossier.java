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



    }

}