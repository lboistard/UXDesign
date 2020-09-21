package com.example.dmp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManagerMedecin {

    //~-------------------------------------------------
    //~ Database Management Declaration
    //~-------------------------------------------------
    private DatabaseMedecin dbHelperMed;
    private Context context;
    private SQLiteDatabase databaseMed;

    //~-------------------------------------------------
    //~ Constructor
    //~-------------------------------------------------
    public DBManagerMedecin(Context c) {
        context = c;
    }

    //~-------------------------------------------------
    //~ Open Medecin database
    //~-------------------------------------------------
    public DBManagerMedecin openDBMedecin() throws SQLException {
        dbHelperMed = new DatabaseMedecin(context);
        databaseMed = dbHelperMed.getWritableDatabase();
        return this;
    }

    //~-------------------------------------------------
    //~ Add Medecin to DB
    //~-------------------------------------------------
    public void insertMedecin(String email, String password, String numSecu) {
        ContentValues contentValue = new ContentValues();

        contentValue.put(DatabaseMedecin.EMAIL, email);
        contentValue.put(DatabaseMedecin.PASSWORD, password);
        contentValue.put(DatabaseMedecin.NUMCPS, numSecu);

        databaseMed.insert(DatabaseMedecin.TABLE_NAME, null, contentValue);
    }

    //~-------------------------------------------------
    //~ Find Medecin in DB
    //~-------------------------------------------------
    public Cursor fetch() {
        String[] columns = new String[] {
                DatabaseMedecin.MED_ID,
                DatabaseMedecin.EMAIL,
                DatabaseMedecin.PASSWORD,
                DatabaseMedecin.NUMCPS
        };
        Cursor cursor = databaseMed.query(DatabaseMedecin.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public String checkUserExist(String mail, String password, String CPS){
        String[] columns = {"NUMCPS"};


        String selection = "emailMed= ? and passwordMed = ? and NUMCPS = ?";
        String[] selectionArgs = {mail, password, CPS};

        Cursor cursor = databaseMed.query("medecins", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        databaseMed.close();

        if(count > 0){
            return CPS;
        }
        return "false";
    }

    //~-------------------------------------------------
    //~ Update la db: contrainte sur le numcps
    //~ Il reste unique et définitif pour chaque medecin.
    //~-------------------------------------------------
    public int updateMed(long _id, String email, String password) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseMedecin.EMAIL, email);
        contentValues.put(DatabaseMedecin.PASSWORD, password);

        int i = databaseMed.update(DatabaseMedecin.TABLE_NAME, contentValues, DatabaseMedecin.MED_ID + " = " + _id, null);
        return i;
    }

    //~-------------------------------------------------
    //~ Delete a user
    //~-------------------------------------------------
    public void deleteMed(long _id) {
        databaseMed.delete(DatabaseMedecin.TABLE_NAME, DatabaseMedecin.MED_ID + "=" + _id, null);
    }
}
