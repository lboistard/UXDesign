package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dmp.User.User;
import com.example.dmp.database.DBPatient;
import com.example.dmp.database.DBUser;

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

        DBPatient dbUser = new DBPatient(this);

        User user = new User("Lucas","Boistard","test","empty");

        dbUser.open();
        dbUser.insertUser(user);

        //on extrait le livre de la BDD grâce au titre du livre que l'on a créé précédemment
        User userFromDb = dbUser.getUserFromDB("Boistard");

        emailUser.setText(userFromDb.getNom());

    }

    //~-------------------------------------------------
    //~ Account Creation, connect to database
    //~-------------------------------------------------
    public void createAccount(View view) {
        String username = emailUser.getText().toString();
        String password = passwordUser.getText().toString();

    }
}

