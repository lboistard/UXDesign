package com.example.dmp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DBManagerInfosPatient {

    //~-------------------------------------------------
    //~ Database Management Declaration
    //~-------------------------------------------------
    private DatabaseInfosPatient dbHelperInfos;
    private Context context;
    private SQLiteDatabase databaseInfosPatient;
   
    //~-------------------------------------------------
    //~ Database Query Variables Declaration
    //~-------------------------------------------------
    private Map<String, String> infosBio = new HashMap<String, String>();
    private Map<String, String> infosImageries = new HashMap<String, String>();
    private Map<String, String> infosCR = new HashMap<String, String>();
    private Map<String, String> infosTraitements = new HashMap<String, String>();
    private Map<String, String> infosSoins = new HashMap<String, String>();

    private String biologie_date, biologie_content;
    private String imagerie_date, imagerie_content;
    private String compte_rendus_date, compte_rendus_content;
    private String traitements_date, traitements_content;
    private String soins_date, soins_content;

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
    public Map<String, String> getBioInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT biologie_date, biologie_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    biologie_date = cursor.getString(cursor.getColumnIndex("biologie_date"));
                    biologie_content = cursor.getString(cursor.getColumnIndex("biologie_content"));
                    infosBio.put(biologie_date, biologie_content);


                    System.out.println("DEBUG Function =====");
                    for(String key : infosBio.keySet()){
                        System.out.println(key);
                    }


                } while (cursor.moveToNext());
                return infosBio;
            }
        }
        return null;
    }


    //~-------------------------------------------------
    //~ Get Imagerie infos
    //~-------------------------------------------------
    public Map<String, String> getImagerieInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT imagerie_date, imagerie_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    imagerie_date = cursor.getString(cursor.getColumnIndex("imagerie_date"));
                    imagerie_content = cursor.getString(cursor.getColumnIndex("imagerie_content"));
                    infosImageries.put(imagerie_date, imagerie_content);
                } while (cursor.moveToNext());
                return infosImageries;
            }
        }
        return null;
    }

    //~-------------------------------------------------
    //~ Get Soins infos
    //~-------------------------------------------------
    public Map<String, String> getSoinsInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT soins_date, soins_content FROM infosPatients where patientId =" + patientId, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    soins_date = cursor.getString(cursor.getColumnIndex("soins_date"));
                    soins_content = cursor.getString(cursor.getColumnIndex("soins_content"));
                    infosSoins.put(soins_date, soins_content);
                } while (cursor.moveToNext());
                return infosSoins;
            }
        }
        return null;
    }


    //~-------------------------------------------------
    //~ Get Traitements infos
    //~-------------------------------------------------
    public Map<String, String> getTraitementsInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT traitements_date, traitements_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    traitements_date = cursor.getString(cursor.getColumnIndex("traitements_date"));
                    traitements_content = cursor.getString(cursor.getColumnIndex("traitements_content"));
                    infosTraitements.put(traitements_date, traitements_content);
                } while (cursor.moveToNext());
                return infosTraitements;
            }
        }
        return null;
    }

    //~-------------------------------------------------
    //~ Get Compte Rendu infos
    //~-------------------------------------------------
    public Map<String, String> getCompteRendusInfos(String patientId){
        Cursor cursor = databaseInfosPatient.rawQuery("SELECT compte_rendu_date, compte_rendu_content FROM infosPatients where patientId =" + patientId, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    compte_rendus_date = cursor.getString(cursor.getColumnIndex("compte_rendu_date"));
                    compte_rendus_content = cursor.getString(cursor.getColumnIndex("compte_rendu_content"));
                    infosCR.put(compte_rendus_date, compte_rendus_content);
                } while (cursor.moveToNext());
                return infosCR;
            }
        }
        return null;
    }

}
