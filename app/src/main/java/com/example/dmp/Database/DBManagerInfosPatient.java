package com.example.dmp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

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
    //~ Find All InfosPatient in DB
    //~-------------------------------------------------
    public Cursor fetch() {
        String[] columns = new String[] {
                DatabaseInfosPatient.INFOS_ID,
                DatabaseInfosPatient.BIOLOGIE_DATE ,
                DatabaseInfosPatient.BIOLOGIE_CONTENT,
                DatabaseInfosPatient.IMAGERIE_DATE,
                DatabaseInfosPatient.IMAGERIE_CONTENT,
                DatabaseInfosPatient.TRAITEMENTS_DATE,
                DatabaseInfosPatient.TRAITEMENTS_CONTENT,
                DatabaseInfosPatient.SOINS_DATE,
                DatabaseInfosPatient.SOINS_CONTENT,
                DatabaseInfosPatient.COMPTE_RENDU_DATE,
                DatabaseInfosPatient.COMPTE_RENDU_CONTENT,
                DatabaseInfosPatient.PATIENT_ID
        };
        Cursor cursor = databaseInfosPatient.query(DatabaseInfosPatient.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    //~-------------------------------------------------
    //~ Get Biologie infos
    //~-------------------------------------------------
    public String getBioInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT biologie_date, biologie_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String biologie_date = cursor.getString(cursor.getColumnIndex("biologie_date"));

                    //patientData.put("numSecu", numS);
                    return biologie_date;
                } while (cursor.moveToNext());
            }
        }
        return null;
    }


    //~-------------------------------------------------
    //~ Get Imagerie infos
    //~-------------------------------------------------
    public String getImagerieInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT biologie_date, biologie_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String biologie_date = cursor.getString(cursor.getColumnIndex("biologie_date"));

                    //patientData.put("numSecu", numS);
                    return biologie_date;
                } while (cursor.moveToNext());
            }
        }
        return null;
    }

    //~-------------------------------------------------
    //~ Get Soins infos
    //~-------------------------------------------------
    public String getSoinsInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT biologie_date, biologie_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String biologie_date = cursor.getString(cursor.getColumnIndex("biologie_date"));

                    //patientData.put("numSecu", numS);
                    return biologie_date;
                } while (cursor.moveToNext());
            }
        }
        return null;
    }


    //~-------------------------------------------------
    //~ Get Traitements infos
    //~-------------------------------------------------
    public String getTraitementsInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT biologie_date, biologie_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String biologie_date = cursor.getString(cursor.getColumnIndex("biologie_date"));

                    //patientData.put("numSecu", numS);
                    return biologie_date;
                } while (cursor.moveToNext());
            }
        }
        return null;
    }

    //~-------------------------------------------------
    //~ Get Compte Rendu infos
    //~-------------------------------------------------
    public String getCompteRendusInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT compte_rendu_date, compte_rendu_content FROM infosPatients where patientId =" + patientId, null);


        String compte_rendu_date, compte_rendu_content;

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    compte_rendu_date = cursor.getString(cursor.getColumnIndex("compte_rendu_date"));
                    compte_rendu_content = cursor.getString(cursor.getColumnIndex("compte_rendu_content"));

                    System.out.print("Compte rendu date : " + cursor.getString(cursor.getColumnIndex("compte_rendu_date")));


                    return compte_rendu_content;
                } while (cursor.moveToNext());
            }
        }
        return null;
    }
}
