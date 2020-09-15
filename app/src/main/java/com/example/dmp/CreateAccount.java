package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dmp.User.User;
import com.example.dmp.database.DBPatient;
import com.example.dmp.database.DBUser;


import org.json.JSONException;


import java.io.FileWriter;

import android.content.Context;

public class CreateAccount extends AppCompatActivity {


    //~-------------------------------------------------
    //~ Components declaration
    //~-------------------------------------------------
    TextView createAccountTextView,confirmPasswordTextView, statutTextView,ifProfessionelTextView;
    ImageView logoCreateAccount;
    EditText emailUser, passwordUser,passwordAgainUser;
    Button createAccountButton;
    RadioButton particulierButton, professionelSanteButton;





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
        particulierButton = findViewById(R.id.particulierButton);
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

    //~-------------------------------------------------
    //~ Account Creation, connect to database
    //~-------------------------------------------------
    public void createAccount(View view) throws JSONException {
        String username = emailUser.getText().toString();
        String password = passwordUser.getText().toString();
        String type= particulierButton.getText().toString();

        addPatientToJson();


    }

    public void addPatientToJson(){


    }
}


