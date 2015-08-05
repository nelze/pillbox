package com.prototype.pillbox.classes;



import java.util.ArrayList;

import com.example.pillbox.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowAll extends ListActivity implements OnClickListener {
	
	private ListView listview;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> arrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_all);

	
		
		ListViewAdapter adapter = new ListViewAdapter(this, generateData());
		 
        //2. setListAdapter
       setListAdapter(adapter);
	/*View blue = findViewById(R.id.bluebutton); 
    blue.setBackgroundColor(0xff4da3dc);
    blue.findViewById(R.id.info).setOnClickListener(this);
    
    View green = findViewById(R.id.greenbutton); 
    green.setBackgroundColor(0xff3ac2a6);
    blue.findViewById(R.id.info).setOnClickListener(this);
    
    View purple = findViewById(R.id.purplebutton); 
    purple.setBackgroundColor(0xffa46bbb);
    blue.findViewById(R.id.info).setOnClickListener(this);
    
    View orange = findViewById(R.id.orangebutton); 
    orange.setBackgroundColor(0xffe68a42);
    blue.findViewById(R.id.info).setOnClickListener(this);
    
    View red = findViewById(R.id.redbutton); 
    red.setBackgroundColor(0xffe45c50);
    blue.findViewById(R.id.info).setOnClickListener(this);*/
	}
	
	/*private void setListAdapter(ListViewAdapter adapter2) {
		
		
		// TODO Auto-generated method stub
		
	}*/

	private ArrayList<MedicineInfo> generateData(){
        ArrayList<MedicineInfo> items = new ArrayList<MedicineInfo>();
        items.add(new MedicineInfo("Biogesic","(500mg)","Active.","Daily.Every 6 Hours","20 Tablets Left"));
        items.add(new MedicineInfo("Biogesic","(500mg)","Active.","Daily.Every 6 Hours","20 Tablets Left"));
        items.add(new MedicineInfo("Biogesic","(500mg)","Active.","Daily.Every 6 Hours","20 Tablets Left"));
 
        return items;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("Checking");
		 switch (v.getId()) {
	case R.id.info:
		Intent intent = new Intent(this, EditMedicine.class);
    	startActivity(intent);     
		//Toast.makeText(getApplicationContext(), "Checking",
			//	   Toast.LENGTH_LONG).show();
        break;
		 }
	}
}
