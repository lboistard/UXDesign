package com.example.dmp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseCommentairesPatient extends SQLiteOpenHelper {

    //~-------------------------------------------------
    //~ TABLE NAME
    //~-------------------------------------------------
    public static final String TABLE_NAME = "commentairesPatients";


    //~-------------------------------------------------
    //~ TABLE COLUMNS
    //~-------------------------------------------------
    public static final String COMMENT_ID = "comment_id";
    public static final String COMMENT_CONTENT = "comment_content";
    public static final String COMMENT_DATE = "comment_date";
    public static final String IDPATIENT= "id_patient";

    //~-------------------------------------------------
    //~ DATABASE INFORMATIONS
    //~-------------------------------------------------
    static final String DB_NAME = "commentairesPatients.db";
    static final int DB_VERSION = 1;

    //~-------------------------------------------------
    //~
    //~-------------------------------------------------
    public DatabaseCommentairesPatient(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    //~-------------------------------------------------
    //~ Table Query
    //~-------------------------------------------------
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + COMMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            " " + COMMENT_CONTENT + " TEXT NOT NULL, " +
            " " + COMMENT_DATE + " TEXT NOT NULL," +
            " " + IDPATIENT + " TEXT NOT NULL );";


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

