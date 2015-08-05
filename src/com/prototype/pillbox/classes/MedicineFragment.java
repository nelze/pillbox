package com.prototype.pillbox.classes;

import com.example.pillbox.R;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import com.prototype.pillbox.classes.*;
 
public class MedicineFragment extends Fragment {
     
    public MedicineFragment(){}
    private MedicineDbAdapter dbHelper;
    private MedicinePOJO medpojo;
	private SimpleCursorAdapter dataAdapter;
	String color;
	int spojo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	medpojo = new MedicinePOJO();
        View rootView = inflater.inflate(R.layout.fragment_medicine, container, false);
          
        return rootView;
    }
    
    Intent intent;
    
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
            	dbHelper = new MedicineDbAdapter(getActivity());
        		dbHelper.open();
        		dbHelper.createMedicine(medpojo);
                v.setSelected(true);
                //add info to DB
                break;
                
            case R.id.color:
            	intent = new Intent(getActivity(), ColorSelect.class);
            	startActivityForResult(intent, 0); 
                break;
                
            case R.id.medName:
            	 //Get med name from db
            	intent = new Intent(getActivity(), Medicine.class);
            	startActivityForResult(intent, 2); 
                break;
                
            case R.id.medInfo:
           	 //Get med name from db
               break;
               
            case R.id.schedule:
            	intent = new Intent(getActivity(), Schedule.class);
            	startActivityForResult(intent, 1);    
                break;
                
            case R.id.reminders:
            	//Put reminders
                break;
                
            case R.id.refillReminders:
            	//Put refill reminders
                break;
        }
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // Check which request we're responding to
	    if (requestCode == 0) {
	        // Make sure the request was successful
	        if (resultCode == Activity.RESULT_OK) {
	        	medpojo.setColor(data.getStringExtra("color"));
	        }
	    }
	    if (requestCode == 1) {
	        // Make sure the request was successful
	        if (resultCode == Activity.RESULT_OK) {
	        	medpojo.setSchedule_id(data.getLongExtra("ScheduleID", -1));
	        }
	    }
	    if (requestCode == 2) {
	        // Make sure the request was successful
	        if (resultCode == Activity.RESULT_OK) {
	        	medpojo.setName(data.getStringExtra("MedicineName"));
	        }
	    }
    }
    
}