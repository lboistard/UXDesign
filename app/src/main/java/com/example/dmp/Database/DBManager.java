
package com.example.dmp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    //~-------------------------------------------------
    //~ CLOSE THE DB
    //~-------------------------------------------------
	private DatabasePatient dbHelper;
	private Context context;
	private SQLiteDatabase database;


    //~-------------------------------------------------
    //~
    //~-------------------------------------------------
	public DBManager(Context c) {
		context = c;
	}

	//~-------------------------------------------------
    //~
    //~-------------------------------------------------
	public DBManager open() throws SQLException {
		dbHelper = new DatabasePatient(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	//~-------------------------------------------------
	//~
	//~-------------------------------------------------
	public void close() {
		dbHelper.close();
	}

	//~-------------------------------------------------
	//~ ADD USER TO DB
	//~-------------------------------------------------
	public void insert(String email, String password, String numSecu) {
		ContentValues contentValue = new ContentValues();

		contentValue.put(DatabasePatient.EMAIL, email);
		contentValue.put(DatabasePatient.PASSWORD, password);
		contentValue.put(DatabasePatient.NUMSECU, numSecu);

		database.insert(DatabasePatient.TABLE_NAME, null, contentValue);
	}


	//~-------------------------------------------------
	//~ FIND IN DB
	//~-------------------------------------------------
	public Cursor fetch() {
		String[] columns = new String[] {
				DatabasePatient.USER_ID,
				DatabasePatient.EMAIL,
				DatabasePatient.PASSWORD,
				DatabasePatient.NUMSECU
		};
		Cursor cursor = database.query(DatabasePatient.TABLE_NAME, columns, null, null, null, null, null);
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
		int i = database.update(DatabasePatient.TABLE_NAME, contentValues, DatabasePatient.USER_ID + " = " + _id, null);
		return i;
	}

    //~-------------------------------------------------
    //~ Delete a user
    //~-------------------------------------------------
	public void delete(long _id) {
		database.delete(DatabasePatient.TABLE_NAME, DatabasePatient.USER_ID + "=" + _id, null);
	}

}
