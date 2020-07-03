package com.example.dmp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBUserPatient {

    //~-------------------------------------------------
    //~ Declaration
    //~-------------------------------------------------
    private Context context = null;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    private static final String DATABASE_NAME = "patientDB";
    private static final String DATABASE_TABLE = "patient";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table users (_id integer primary key autoincrement, "
                    + "username text not null, "
                    + "password text not null);";


    //~-------------------------------------------------
    //~ Constructor
    //~-------------------------------------------------
    public DBUserPatient(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }


    //~-------------------------------------------------
    //~ InnerClass that create database if not exist
    //~-------------------------------------------------
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, "/sdcard/folderName/"+DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w("TAG", "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
    }
}
