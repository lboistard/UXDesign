package com.example.dmp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

public class DBManagerCommentairesPatient {

    //~-------------------------------------------------
    //~ Database Management Declaration
    //~-------------------------------------------------
    private DatabaseCommentairesPatient dbhelpercommentPatient;
    private Context context;
    private SQLiteDatabase databaseCommentairesPatient;

    //~-------------------------------------------------
    //~ Database Query Variables Declaration
    //~-------------------------------------------------
    private Map<String, String> infosComment = new HashMap<String, String>();
    private String comment_date, comment_content;



    //~-------------------------------------------------
    //~ Constructor
    //~-------------------------------------------------
    public DBManagerCommentairesPatient(Context c) {

        context = c;
    }

    //~-------------------------------------------------
    //~ Open Infos Patient database
    //~-------------------------------------------------
    public DBManagerCommentairesPatient openDBCommentsPatient() throws SQLException {
        dbhelpercommentPatient = new DatabaseCommentairesPatient(context);
        databaseCommentairesPatient = dbhelpercommentPatient.getWritableDatabase();
        return this;
    }


    //~-------------------------------------------------
    //~ Find All InfosPatient in DB
    //~-------------------------------------------------
    public Cursor fetch() {
        String[] columns = new String[] {
                DatabaseCommentairesPatient.COMMENT_ID,
                DatabaseCommentairesPatient.COMMENT_CONTENT ,
                DatabaseCommentairesPatient.COMMENT_DATE,
                DatabaseCommentairesPatient.IDPATIENT,
        };
        Cursor cursor = databaseCommentairesPatient.query(DatabaseCommentairesPatient.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    //~-------------------------------------------------
    //~ Get Compte Rendu infos
    //~-------------------------------------------------
    public String getLastComment(String patientId){
        Cursor cursor = databaseCommentairesPatient.rawQuery("SELECT comment_content FROM commentairesPatients where id_patient = " + patientId + " ORDER BY comment_id DESC" , null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    comment_content = cursor.getString(cursor.getColumnIndex("comment_content"));
                    return comment_content;
                } while (cursor.moveToNext());
            }
        }
        return null;
    }

    //~-------------------------------------------------
    //~ Add Comment
    //~-------------------------------------------------
    public void addComment(String comment_content, String comment_date, String idPatient){
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseCommentairesPatient.COMMENT_DATE, comment_date);
        contentValue.put(DatabaseCommentairesPatient.COMMENT_CONTENT, comment_content);
        contentValue.put(DatabaseCommentairesPatient.IDPATIENT, idPatient);
        databaseCommentairesPatient.insert(DatabaseCommentairesPatient.TABLE_NAME, null, contentValue);

    }



}
