package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EditMedicine extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_medicine);
	}
	
	public void schedule(View v)
	{
		Intent intent = new Intent(this, Schedule.class);
    	startActivity(intent);
	}
	
	public void quantity(View v)
	{
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.quantity);
		dialog.setTitle("Select Quantity");

		// set the custom dialog components - text, image and button

		
		//Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		//////dialogButton.setOnClickListener(new OnClickListener() {
			/*@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});*/
		

		dialog.show();
	}
	
	public void color(View v)
	{
		Intent intent = new Intent(this, ColorSelect.class);
    	startActivity(intent);
	}
	
	public void refill(View v)
	{
		Intent intent = new Intent(this, Schedule.class);
    	startActivity(intent);
	}
	
	/*public void signin(View v) {
		Intent intent = new Intent(EditMedicine.this, Journal.class);
    	startActivity(intent);    
    	EditMedicine.this.finish();
	}*/
}
