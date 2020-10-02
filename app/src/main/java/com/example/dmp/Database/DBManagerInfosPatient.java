package com.example.dmp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManagerInfosPatient {
    //~-------------------------------------------------
    //~ Database Management Declaration
    //~-------------------------------------------------
    private DatabaseInfosPatient dbHelperInfos;
    private Context context;
    private SQLiteDatabase databaseInfosPatient;

    //~-------------------------------------------------
    //~ Constructor
    //~-------------------------------------------------
    public DBManagerInfosPatient(Context c) {
        context = c;
    }

    //~-------------------------------------------------
    //~ Open Infos Patient database
    //~-------------------------------------------------
    public DBManagerInfosPatient openDBInfosPatient() throws SQLException {
        dbHelperInfos = new DatabaseInfosPatient(context);
        databaseInfosPatient = dbHelperInfos.getWritableDatabase();
        return this;
    }

    //~-------------------------------------------------
    //~ Find Medecin in DB
    //~-------------------------------------------------
    public Cursor fetch() {
        String[] columns = new String[] {
                DatabaseInfosPatient.MED_ID,
                DatabaseInfosPatient.EMAIL,
                DatabaseInfosPatient.PASSWORD,
                DatabaseInfosPatient.NUMCPS
        };
        Cursor cursor = databaseInfosPatient.query(DatabaseMedecin.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
