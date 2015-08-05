package com.prototype.pillbox.classes;

import com.example.pillbox.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
 
public class JournalFragment extends Fragment implements OnClickListener{
     
    public JournalFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_journal, container, false);
        Button a = (Button) rootView.findViewById(R.id.daily);
        Button b = (Button) rootView.findViewById(R.id.weekly);
        Button c = (Button) rootView.findViewById(R.id.monthly);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);  
        return rootView;
    }
    

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.daily:
                v.setSelected(true);
                getView().findViewById(R.id.weekly).setSelected(false);
                getView().findViewById(R.id.monthly).setSelected(false);
                break;
                
            case R.id.weekly:
            	 v.setSelected(true);
                 getView().findViewById(R.id.daily).setSelected(false);
                 getView().findViewById(R.id.monthly).setSelected(false);
                break;
                
            case R.id.monthly:
            	 v.setSelected(true);
                 getView().findViewById(R.id.weekly).setSelected(false);
                 getView().findViewById(R.id.daily).setSelected(false);
                break;
        }
    }
    
   
    	
    	
}