package com.example.dmp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseInfosPatient extends SQLiteOpenHelper {

    //~-------------------------------------------------
    //~ TABLE NAME
    //~-------------------------------------------------
    public static final String TABLE_NAME = "infosPatients";

    //~-------------------------------------------------
    //~ TABLE COLUMNS
    //~-------------------------------------------------
    public static final String INFOS_ID = "infos_id";
    public static final String BIOLOGIE_DATE = "biologie_date";
    public static final String BIOLOGIE_CONTENT = "biologie_content";
    public static final String IMAGERIE_DATE = "imagerie_date";
    public static final String IMAGERIE_CONTENT = "imagerie_content";
    public static final String TRAITEMENTS_DATE = "traitements_date";
    public static final String TRAITEMENTS_CONTENT = "traitements_content";
    public static final String SOINS_DATE = "soins_date";
    public static final String SOINS_CONTENT = "soins_content";
    public static final String COMPTE_RENDU_DATE = "compte_rendu_date";
    public static final String COMPTE_RENDU_CONTENT = "compte_rendu_content";

    public static final String PATIENT_ID = "patientId";

    //~-------------------------------------------------
    //~ DATABASE INFORMATIONS
    //~-------------------------------------------------
    static final String DB_NAME = "infosPatients.db";
    static final int DB_VERSION = 1;

    //~-------------------------------------------------
    //~ Table Query
    //~-------------------------------------------------
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +
            "(" + INFOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            " " + BIOLOGIE_DATE + " TEXT NOT NULL, " +
            " " + BIOLOGIE_CONTENT + " TEXT NOT NULL," +
            " " + IMAGERIE_DATE + " TEXT NOT NULL," +
            " " + IMAGERIE_CONTENT + " TEXT NOT NULL," +
            " " + TRAITEMENTS_DATE + " TEXT NOT NULL," +
            " " + TRAITEMENTS_CONTENT + " TEXT NOT NULL," +
            " " + SOINS_DATE + " TEXT NOT NULL," +
            " " + SOINS_CONTENT + " TEXT NOT NULL," +
            " " + COMPTE_RENDU_DATE + " TEXT NOT NULL," +
            " " + COMPTE_RENDU_CONTENT + " TEXT NOT NULL," +
            " " + PATIENT_ID + " TEXT NOT NULL);";


    //~-------------------------------------------------
    //~
    //~-------------------------------------------------
    public DatabaseInfosPatient(Context context) {

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
    //~ To upgrade the DB version
    //~-------------------------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
