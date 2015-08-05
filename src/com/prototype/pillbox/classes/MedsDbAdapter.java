package com.prototype.pillbox.classes;

import java.io.BufferedInputStream;
import java.io.InputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;

public class MedsDbAdapter {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "name";

	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	private static final String DATABASE_NAME = "RxNorm";
	private static final String SQLITE_TABLE = "Meds";
	private static final int DATABASE_VERSION = 1;

	private final Context mCtx;

	private static final String DATABASE_CREATE = "CREATE TABLE if not exists "
			+ SQLITE_TABLE + " (" + KEY_ROWID
			+ " integer PRIMARY KEY autoincrement," + KEY_NAME 
			+ ");";

	
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
	
	public MedsDbAdapter(Context ctx) {
		this.mCtx = ctx;
	}

	public MedsDbAdapter open() throws SQLException {
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
	
	
	public long createRow(String name) {

		
		// INSERT
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_NAME, name);


		// parameters
		// mDb.insert(table, nullColumnHack, values);
		
		return mDb.insert(SQLITE_TABLE, null, initialValues);
	}

	public boolean deleteAllRegions() {

		// DELETE
		// parameters
		// mDb.delete(table, whereClause, whereArgs)
		
		int doneDelete = 0;
		doneDelete = mDb.delete(SQLITE_TABLE, null, null);
		return doneDelete > 0;

	}

	public Cursor fetchRegionsByName(String inputText) throws SQLException {
		Cursor mCursor = null;
		if (inputText == null || inputText.length() == 0) {
			
			mCursor = mDb.query(SQLITE_TABLE, new String[] { KEY_ROWID,
					KEY_NAME }, null, null, null, null, null);

		} else {
			mCursor = mDb.query(true, SQLITE_TABLE, new String[] { KEY_ROWID,
					KEY_NAME }, KEY_NAME + " like '%" + inputText
					+ "%'", null, null, null, null, null);
		}
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	public Cursor fetchAllRegions() {

		// parameter descriptions
		// mDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)

		Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] { KEY_ROWID,
				KEY_NAME }, null, null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	
	public boolean isEmpty() {

		// parameter descriptions
		// mDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)

		Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] { KEY_ROWID,
				KEY_NAME }, null, null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();

			return (mCursor.getCount() == 0);
		}
		else
		{
			throw new RuntimeException("Null cursor");
		}
	}
	
	
	// SEEDING
	
	public void seed() {

		try
		{
			// the Context is the Activity where this is currently used
			InputStream stream = mCtx.getAssets().open("meds.json");
			BufferedInputStream bis = new BufferedInputStream(stream, 100*1024);
			
			JsonFactory f = new MappingJsonFactory();
		    JsonParser jp = f.createParser(stream);
		    
		    
		    // this is for bulk mode inserting
		    mDb.beginTransaction();
			
		    while (jp.nextToken() != JsonToken.END_ARRAY) {
	
		    	jp.nextToken();
		    	JsonNode node = jp.readValueAsTree();
		    	
	            // And now we have random access to everything in the object
		    	String name = node.get("name").asText();
		    	
		    	
				// INSERT
				ContentValues initialValues = new ContentValues();
				initialValues.put(KEY_NAME, name);

				mDb.insert(SQLITE_TABLE, null, initialValues);
		    	
		    	//System.out.println(code+" -> "+name);
		    }
		    bis.close();
		    mDb.setTransactionSuccessful();
		}
		catch(Exception e)
		{
			System.out.println("Error seeding db");
		}
		finally
		{
		    mDb.endTransaction();
		}
	}

}