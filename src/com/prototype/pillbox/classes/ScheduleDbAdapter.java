package com.prototype.pillbox.classes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//National Capital Region,NCR; Metro Manila
//Cordillera Administrative Region,CAR
//Ilocos Region,Region I
//Cagayan Valley,Region II
//Central Luzon,Region III
//CALABARZON,Region IV-A
//MIMAROPA,Region IV-B
//Bicol Region,Region V
//Western Visayas,Region VI
//Central Visayas,Region VII
//Eastern Visayas,Region VIII
//Zamboanga Peninsula,Region IX
//Northern Mindanao,Region X
//Davao Region,Region XI
//SOCCSKSARGEN,Region XII
//Caraga,Region XIII
//Autonomous Region in Muslim Mindanao,ARMM

public class ScheduleDbAdapter {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_JSON = "json";

	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	private static final String DATABASE_NAME = "Schedule";
	private static final String SQLITE_TABLE = "Skeds";
	private static final int DATABASE_VERSION = 1;

	private final Context mCtx;

	private static final String DATABASE_CREATE = "CREATE TABLE if not exists "
			+ SQLITE_TABLE + " (" + KEY_ROWID
			+ " integer PRIMARY KEY autoincrement," + KEY_JSON + ");";

	
	// UTILITY TABLE HELPER CLASS
	
	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		// DATABASE CREATION
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		// DATABASE CHANGE
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
			onCreate(db);
		}
	}
	
	
	// LIFE CYCLE
	
	public ScheduleDbAdapter(Context ctx) {
		this.mCtx = ctx;
	}

	public ScheduleDbAdapter open() throws SQLException {
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
		
		
		return this;
	}

	public void close() {
		if (mDbHelper != null) {
			mDbHelper.close();
		}
	}

	
	
	// ACTIONS
	
	
	public long createSchedule(SchedulePOJO sked) {

		try
		{
			// INSERT
			ContentValues initialValues = new ContentValues();
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(sked);
			initialValues.put(KEY_JSON, json);
	
			// parameters
			// mDb.insert(table, nullColumnHack, values);
			
			return mDb.insert(SQLITE_TABLE, null, initialValues);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public boolean deleteAllMeds() {

		// DELETE
		// parameters
		// mDb.delete(table, whereClause, whereArgs)
		
		int doneDelete = 0;
		doneDelete = mDb.delete(SQLITE_TABLE, null, null);
		return doneDelete > 0;

	}

	public Cursor fetchAllSkeds() {

		// parameter descriptions
		// mDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)

		Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] { KEY_ROWID,
				KEY_JSON }, null, null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public MedicinePOJO fetchSkedById(Long id) {

		// parameter descriptions
		// mDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)

		Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] { KEY_ROWID,
				KEY_JSON }, KEY_ROWID+"="+id, null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
			
			try {
				String json = mCursor.getString(1);
				ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(json, MedicinePOJO.class);
			} 
			catch (Exception e) 
			{
				throw new RuntimeException(e);
			}			
		}
		
		throw new RuntimeException("No med for id "+id);
	}
		
}