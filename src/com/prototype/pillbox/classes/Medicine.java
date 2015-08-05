package com.prototype.pillbox.classes;

import com.example.pillbox.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Medicine extends Activity {

	private MedsDbAdapter dbHelper;
	private SimpleCursorAdapter dataAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medicine_select);

		dbHelper = new MedsDbAdapter(this);
		dbHelper.open();

		// Clean all data
		// dbHelper.deleteAllRegions();
		
		// Add some data
		if (dbHelper.isEmpty())
		{
			dbHelper.seed();
		}
		
		// Generate ListView from SQLite Database
		Cursor cursor = dbHelper.fetchAllRegions();

		// create the adapter using the cursor pointing to the desired data
		// as well as the layout information
		
		// new SimpleCursorAdapter(context, layout, c, from, to, flags)
		dataAdapter = new SimpleCursorAdapter(this, 
											  R.layout.region_info,
											  cursor, 
											  new String[] { MedsDbAdapter.KEY_NAME },  	// columns to be bound 
											  new int[]    { R.id.name },									// views id which the data will be bound to 
											  0);

		// Assign adapter to ListView
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(dataAdapter);

		
		// clicking an item in the listview
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View view,
					int position, long id) {
				// Get the cursor, positioned to the corresponding row in the
				// result set
				Cursor cursor = (Cursor) listView.getItemAtPosition(position);

				// Get the region's name from this row in the database.
				String name = cursor.getString(cursor.getColumnIndexOrThrow(MedsDbAdapter.KEY_NAME));
				
				// display in toast
				Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
			}
		});

		
		
		// this detects changes in the EditText as you type
		EditText myFilter = (EditText) findViewById(R.id.myFilter);
		myFilter.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				// this tells the adapter to trigger the filter
				dataAdapter.getFilter().filter(s.toString());
			}
		});

		
		// indicates what query will be run when filtering
		dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
			public Cursor runQuery(CharSequence constraint) {
				return dbHelper.fetchRegionsByName(constraint.toString());
			}
		});

	}
}