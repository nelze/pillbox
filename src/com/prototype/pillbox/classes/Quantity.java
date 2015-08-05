package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Quantity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule);
	}
	
	public void days(View v)
	{
		Intent intent = new Intent(this, Days.class);
    	startActivity(intent); 
	}
	
	public void frequency(View v)
	{
		//Intent intent = new Intent(this, Frequency.class);
    	//startActivity(intent); 
	}
	/*public void signin(View v) {
		Intent intent = new Intent(EditMedicine.this, Journal.class);
    	startActivity(intent);    
    	EditMedicine.this.finish();
	}*/
}
