package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ColorSelect extends Activity {
	
	String color;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_color);
		
		View blue = this.findViewById(R.id.bluebutton); 
        blue.setBackgroundColor(0xff4da3dc);
        
        View yellow = this.findViewById(R.id.yellowbutton); 
        yellow.setBackgroundColor(0xfff1c40f);
        
        View green = this.findViewById(R.id.greenbutton); 
        green.setBackgroundColor(0xff3ac2a6);
        
        View purple = this.findViewById(R.id.purplebutton); 
        purple.setBackgroundColor(0xffa46bbb);
        
        View orange = this.findViewById(R.id.orangebutton); 
        orange.setBackgroundColor(0xffe68a42);
        
        View red = this.findViewById(R.id.redbutton); 
        red.setBackgroundColor(0xffe45c50);
	}
	
	public void blue (View v)
	{
		color = "Blue";
		
		Intent intent = new Intent(this, Schedule.class);
		intent.putExtra("color", color);
    	startActivity(intent);
    	finish();
	}
	public void back (View v)
	{
		Intent intent = new Intent(this, Schedule.class);
    	startActivity(intent);
    	finish();
	}
	public void green (View v)
	{
		color = "Green";	
		Intent intent = new Intent(this, Schedule.class);
		intent.putExtra("color", color);
    	startActivity(intent);
    	finish();
	}
	public void purple (View v)
	{
		color = "Purple";
		
		Intent intent = new Intent(this, Schedule.class);
		intent.putExtra("color", color);
    	startActivity(intent);
    	finish();
	}
	public void orange (View v)
	{
		color = "Orange";
		Intent intent = new Intent(this, Schedule.class);
		intent.putExtra("color", color);
    	startActivity(intent);
    	finish();
	}
	public void red (View v)
	{
		color = "Red";
		Intent intent = new Intent(this, Schedule.class);
		intent.putExtra("color", color);
    	startActivity(intent);
    	finish();
	}
	
	
}
