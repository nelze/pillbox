package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TimePicker;

public class Time extends Activity {
	
	TimePicker time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_select);
		time = (TimePicker) findViewById(R.id.timePicker1);
	}
	
	public void save (View v){
		String time1 = time.getCurrentHour().toString() +":"+time.getCurrentMinute(); 
		Intent intent = new Intent(Time.this, Schedule.class);
		intent.putExtra("time", time1);
    	startActivity(intent);    
	}
	
	/*public void signin(View v) {
		Intent intent = new Intent(EditMedicine.this, Journal.class);
    	startActivity(intent);    
    	EditMedicine.this.finish();
	}*/
}
