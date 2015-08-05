package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Frequency extends Activity {

	int timesaday;
	int interval;
	TextView times;
	TextView hours;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frequency);
		Bundle bundle = getIntent().getExtras();
		timesaday = bundle.getInt("timesaday");
		interval = bundle.getInt("interval");
		times = (TextView) findViewById(R.id.timesaday);
		hours = (TextView) findViewById(R.id.hours);
		if (timesaday!=0)
		{
			times.setText(timesaday);
		}
		if (interval!=0)
		{
			hours.setText(interval);
		}
	}
	
	public void save(View v)
	{
		
		Intent intent = new Intent(this, Schedule.class);
		intent.putExtra("timesaday", times.getText().toString());
		intent.putExtra("interval", hours.getText().toString());
    	startActivity(intent);
	}
	/*public void signin(View v) {
		Intent intent = new Intent(EditMedicine.this, Journal.class);
    	startActivity(intent);    
    	EditMedicine.this.finish();
	}*/
}
