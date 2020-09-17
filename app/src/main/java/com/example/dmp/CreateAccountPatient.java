package com.example.dmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dmp.database.DBManager;
import com.example.dmp.database.DatabaseHelper;

public class CreateAccountPatient extends AppCompatActivity {

    //~-------------------------------------------------
    //~ Class/Object declaration
    //~-------------------------------------------------
    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[] {
            DatabaseHelper.USER_ID,
            DatabaseHelper.EMAIL,
            DatabaseHelper.PASSWORD,
            DatabaseHelper.NUMSECU
    };

    final int[] to = new int[] {
            R.id.title,
            R.id.emailUser
    };

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
        setContentView(R.layout.activity_create_account_patient);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        createAccountComponents();
    }

    //~-------------------------------------------------
    //~ Account Creation, connect to database
    //~-------------------------------------------------
    public void createAccount(View view) {
        String username = emailUser.getText().toString();
        String password = passwordUser.getText().toString();

        String type= particulierButton.getText().toString();



    }


}


