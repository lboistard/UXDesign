
package com.example.dmp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManagerPatient {

    //~-------------------------------------------------
    //~ Database Management Declaration
    //~-------------------------------------------------
	private DatabasePatient dbHelperPatient;
	private Context context;
	private SQLiteDatabase databasePatient;


    //~-------------------------------------------------
    //~ Constructor
    //~-------------------------------------------------
	public DBManagerPatient(Context c) {

		context = c;
	}

	//~-------------------------------------------------
    //~ Open patient database
    //~-------------------------------------------------
	public DBManagerPatient openDBPatient() throws SQLException {
		dbHelperPatient = new DatabasePatient(context);
		databasePatient = dbHelperPatient.getWritableDatabase();
		return this;
	}




	//~-------------------------------------------------
	//~ Close the DB
	//~-------------------------------------------------
	public void close() {

		dbHelperPatient.close();
	}

	//~-------------------------------------------------
	//~ Add patient to DB
	//~-------------------------------------------------
	public void insertPatient(String email, String password, String numSecu) {
		ContentValues contentValue = new ContentValues();
		contentValue.put(DatabasePatient.EMAIL, email);
		contentValue.put(DatabasePatient.PASSWORD, password);
		contentValue.put(DatabasePatient.NUMSECU, numSecu);

		databasePatient.insert(DatabasePatient.TABLE_NAME, null, contentValue);
	}



	//~-------------------------------------------------
	//~ Find Patient in DB
	//~-------------------------------------------------
	public Cursor fetch() {
		String[] columns = new String[] {
				DatabasePatient.USER_ID,
				DatabasePatient.EMAIL,
				DatabasePatient.PASSWORD,
				DatabasePatient.NUMSECU
		};
		Cursor cursor = databasePatient.query(DatabasePatient.TABLE_NAME, columns, null, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}


    //~-------------------------------------------------
    //~ Update la db: contrainte sur le numsecu
	//~ Il reste unique et définitif pour chaque user.
    //~-------------------------------------------------
	public int update(long _id, String email, String password) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(DatabasePatient.EMAIL, email);
		contentValues.put(DatabasePatient.PASSWORD, password);
		int i = databasePatient.update(DatabasePatient.TABLE_NAME, contentValues, DatabasePatient.USER_ID + " = " + _id, null);
		return i;
	}

    //~-------------------------------------------------
    //~ Delete a user
    //~-------------------------------------------------
	public void delete(long _id) {
		databasePatient.delete(DatabasePatient.TABLE_NAME, DatabasePatient.USER_ID + "=" + _id, null);
	}

}
