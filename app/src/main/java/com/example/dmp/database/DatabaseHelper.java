package com.example.dmp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {


    //~-------------------------------------------------
    //~ TABLE NAME
    //~-------------------------------------------------
    public static final String TABLE_NAME = "users";

    //~-------------------------------------------------
    //~ TABLE COLUMNS
    //~-------------------------------------------------
    public static final String USER_ID = "user_id";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String NUMSECU = "numsecu";

    //~-------------------------------------------------
    //~ DATABASE INFORMATIONS
    //~-------------------------------------------------
    static final String DB_NAME = "assets/users.db";
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
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //~-------------------------------------------------
    //~
    //~-------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }


    //~-------------------------------------------------
    //~
    //~-------------------------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

