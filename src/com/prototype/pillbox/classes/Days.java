package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class Days extends Activity {
	
	String days;
	CheckBox mon;
	CheckBox tues;
	CheckBox wed;
	CheckBox thurs;
	CheckBox fri;
	CheckBox sat;
	CheckBox sun;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.days);
		Bundle bundle = getIntent().getExtras();
		days = bundle.getString("days");
		mon = (CheckBox) findViewById(R.id.Mondaycb);
		tues = (CheckBox) findViewById(R.id.Tuesdaycb);
		wed = (CheckBox) findViewById(R.id.Wednesdaycb);
		thurs = (CheckBox) findViewById(R.id.Thursdaycb);
		fri = (CheckBox) findViewById(R.id.Fridaycb);
		sat = (CheckBox) findViewById(R.id.Saturdaycb);
		sun = (CheckBox) findViewById(R.id.Sundaycb);
		
		if (days!=null)
		{
			String split[] = days.split(",");
			
			for (int i = 0; i < split.length; i++)
			{
				if (split[i].equalsIgnoreCase("Mon"))
				{
					mon.setChecked(true);
					
				}
				if (split[i].equalsIgnoreCase("Tues"))
				{
					tues.setChecked(true);
					
				}
				if (split[i].equalsIgnoreCase("Wed"))
				{
					wed.setChecked(true);
				}
				if (split[i].equalsIgnoreCase("Thurs"))
				{
					thurs.setChecked(true);
				}
				if (split[i].equalsIgnoreCase("Fri"))
				{
					fri.setChecked(true);
				}
				if (split[i].equalsIgnoreCase("Sat"))
				{
					sat.setChecked(true);
				}
				if (split[i].equalsIgnoreCase("Sun"))
				{
					sun.setChecked(true);
				}
				
			}
		}
	}
	
	public void save(View v)
	{
		days ="";
		if (mon.isChecked())
			days+="Mon,";
		if (tues.isChecked())
			days+="Tues,";
		if (wed.isChecked())
			days+="Wed,";
		if (thurs.isChecked())
			days+="Thurs,";
		if (fri.isChecked())
			days+="Fri,";
		if (sat.isChecked())
			days+="Sat,";
		if (sun.isChecked())
			days+="Sun,";
		
		String str = days;
		str = str.replaceAll(",$", "");
		
		Intent intent = new Intent(this, Schedule.class);
		intent.putExtra(days, days);
    	startActivity(intent);
    	finish();
    	
    	
	}
	/*public void signin(View v) {
		Intent intent = new Intent(EditMedicine.this, Journal.class);
    	startActivity(intent);    
    	EditMedicine.this.finish();
	}*/
}
