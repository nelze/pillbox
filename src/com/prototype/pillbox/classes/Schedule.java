package com.prototype.pillbox.classes;



import java.util.HashMap;
import java.util.List;

import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Schedule extends Activity {
	
	HashMap<String, Object> params = new HashMap<String, Object>();
	String days;
	int timesaday;
	int hours;
	List<Time> time;
	TextView daysList;
	TextView pickdays;
    private ScheduleDbAdapter dbHelper;
    private SchedulePOJO skedpojo;
	private SimpleCursorAdapter dataAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule);
		
		String url = "https://polar-coast-7695.herokuapp.com/schedule/create";
		
		Bundle bundle = getIntent().getExtras();
    	days = bundle.getString("days");
    	timesaday = bundle.getInt("timesaday");
    	hours = bundle.getInt("hours");
    	//time = bundle.get("time");
    	daysList = (TextView) findViewById(R.id.days_list);
    	pickdays = (TextView) findViewById(R.id.pickdays);
    	daysList.setText(days);
    	pickdays.setTextColor(getResources().getColor(R.color.grey));
		
		
	}
	
	public void days(View v)
	{
		Intent intent = new Intent(this, Days.class);
    	startActivityForResult(intent, 0);
	}
	
	public void frequency(View v)
	{
		Intent intent = new Intent(this, Frequency.class);
    	startActivityForResult(intent, 1);
	}
	
	public void time(View v)
	{
		Intent intent = new Intent(this, Frequency.class);
    	startActivityForResult(intent, 2);
	}
	
	public void everyday(View v)
	{
		days = "Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday";
	}
	public void save(View v)
	{
		skedpojo.setActive(true);
		dbHelper = new ScheduleDbAdapter(this);
		dbHelper.open();
		dbHelper.createSchedule(skedpojo);
        v.setSelected(true);
		//save all of the data here
          finish();//finishing activity  
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // Check which request we're responding to
	    if (requestCode == 0) {
	        // Make sure the request was successful
	        if (resultCode == RESULT_OK) {
	        	skedpojo.setDays(data.getStringExtra("days"));
	            // The user picked a contact.
	            // The Intent's data Uri identifies which contact was selected.

	            // Do something with the contact here (bigger example below)
	        }
	    }
	    
	    if (requestCode == 1) {
	        // Make sure the request was successful
	        if (resultCode == RESULT_OK) {
	        	
	        	skedpojo.setFrequency(data.getIntExtra("timesaday", 0));
	        	skedpojo.setInterval(data.getIntExtra("hours", 0));
	        	//timesaday = data.getIntExtra("timesaday", 0);
	        	//hours = data.getIntExtra("hours", 0);
	            // The user picked a contact.
	            // The Intent's data Uri identifies which contact was selected.

	            // Do something with the contact here (bigger example below)
	        }
	    }
	    
	    if (requestCode == 2) {
	        // Make sure the request was successful
	        if (resultCode == RESULT_OK) {
	        	
	        	
	        	//time =data.getStringExtra("time");
	            // The user picked a contact.
	            // The Intent's data Uri identifies which contact was selected.

	            // Do something with the contact here (bigger example below)
	        }
	    }
	}
	/*public void signin(View v) {
		Intent intent = new Intent(EditMedicine.this, Journal.class);
    	startActivity(intent);    
    	EditMedicine.this.finish();
	}*/
}
