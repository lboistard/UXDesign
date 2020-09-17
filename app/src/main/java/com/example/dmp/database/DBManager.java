
package com.example.dmp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.dmp.database.DatabaseHelper;

public class DBManager {

    //~-------------------------------------------------
    //~ CLOSE THE DB
    //~-------------------------------------------------
	private DatabaseHelper dbHelper;
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
		dbHelper = new DatabaseHelper(context);
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

		contentValue.put(DatabaseHelper.EMAIL, email);
		contentValue.put(DatabaseHelper.PASSWORD, password);
		contentValue.put(DatabaseHelper.NUMSECU, numSecu);

		database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
	}


	//~-------------------------------------------------
	//~ FIND IN DB
	//~-------------------------------------------------
	public Cursor fetch() {
		String[] columns = new String[] {
				DatabaseHelper.USER_ID,
				DatabaseHelper.EMAIL,
				DatabaseHelper.PASSWORD,
				DatabaseHelper.NUMSECU
		};
		Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
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

		contentValues.put(DatabaseHelper.EMAIL, email);
		contentValues.put(DatabaseHelper.PASSWORD, password);
		int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.USER_ID + " = " + _id, null);
		return i;
	}

    //~-------------------------------------------------
    //~ Delete a user
    //~-------------------------------------------------
	public void delete(long _id) {
		database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.USER_ID + "=" + _id, null);
	}

}
