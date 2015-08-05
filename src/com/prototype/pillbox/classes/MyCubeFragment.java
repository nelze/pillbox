package com.prototype.pillbox.classes;

import com.example.pillbox.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
 
public class MyCubeFragment extends Fragment implements android.view.View.OnClickListener {
	
	Button blue;
     
    public MyCubeFragment(){}
     
    @SuppressLint("ResourceAsColor")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
    	View rootView = inflater.inflate(R.layout.fragment_mycube, container, false);
        
        View blue = rootView.findViewById(R.id.bluebutton); 
        blue.setBackgroundColor(0xff4da3dc);
        
        View yellow = rootView.findViewById(R.id.yellowbutton); 
        yellow.setBackgroundColor(0xfff1c40f);
        
        View green = rootView.findViewById(R.id.greenbutton); 
        green.setBackgroundColor(0xff3ac2a6);
        
        View purple = rootView.findViewById(R.id.purplebutton); 
        purple.setBackgroundColor(0xffa46bbb);
        
        View orange = rootView.findViewById(R.id.orangebutton); 
        orange.setBackgroundColor(0xffe68a42);
        
        View red = rootView.findViewById(R.id.redbutton); 
        red.setBackgroundColor(0xffe45c50);
        
        yellow.setClickable(true);
        yellow.setOnClickListener(this);
        return rootView;
    }
    
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yellowbutton:
            	Intent intent = new Intent(getActivity(), ShowAll.class);
            	startActivity(intent);    
                break;
                
            
        }
    }
}