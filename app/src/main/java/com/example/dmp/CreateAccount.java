package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class CreateAccount extends AppCompatActivity {


    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView createAccountTextView,confirmPasswordTextView, statutTextView,ifProfessionelTextView;
    ImageView logoCreateAccount;
    EditText emailUser, passwordUser,passwordAgainUser;
    Button createAccountButton;
    RadioButton particlierButton, professionelSanteButton;

    //~-------------------------------------------------
    //~ Window components attribution
    //~-------------------------------------------------
    public void createAccountComponents(){
        createAccountTextView = findViewById(R.id.createAccountTextView);
		confirmPasswordTextView = findViewById(R.id.confirmPasswordTextView);
		statutTextView = findViewById(R.id.statutTextView);
		ifProfessionelTextView = findViewById(R.id.ifProfessionelTextView);
		logoCreateAccount = findViewById(R.id.logoCreateAccount);
		emailUser = findViewById(R.id.emailUser);
		passwordUser = findViewById(R.id.passwordUser);
		passwordAgainUser = findViewById(R.id.passwordAgainUser);
		createAccountButton = findViewById(R.id.createAccountButton);
		particlierButton = findViewById(R.id.particlierButton);
		professionelSanteButton = findViewById(R.id.professionelSanteButton);

    }

    //~-------------------------------------------------
    //~ Window Init
    //~-------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createAccountComponents();
    }
}

