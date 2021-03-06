package com.example.dmp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabasePatient extends SQLiteOpenHelper {


    //~-------------------------------------------------
    //~ TABLE NAME
    //~-------------------------------------------------
    public static final String TABLE_NAME = "patients";

    //~-------------------------------------------------
    //~ TABLE COLUMNS
    //~-------------------------------------------------
    public static final String USER_ID = "patient_id";
    public static final String EMAIL = "emailPatient";
    public static final String PASSWORD = "passwordPatient";
    public static final String NUMSECU = "numSecuPatient";

    //~-------------------------------------------------
    //~ DATABASE INFORMATIONS
    //~-------------------------------------------------
    static final String DB_NAME = "patients.db";
    static final int DB_VERSION = 1;

    //~-------------------------------------------------
    //~ Table Query
    //~-------------------------------------------------
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + USER_ID
    + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            " " + EMAIL + " TEXT NOT NULL, " +
            " " + PASSWORD + " TEXT NOT NULL," +
            " " + NUMSECU + " TEXT NOT NULL UNIQUE);";


    //~-------------------------------------------------
    //~
    //~-------------------------------------------------
    public DatabasePatient(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    //~-------------------------------------------------
    //~ Create the table if not exist
    //~-------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    //~-------------------------------------------------
    //~ To upgrade the DB content
    //~-------------------------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

