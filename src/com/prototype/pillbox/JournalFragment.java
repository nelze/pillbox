package com.prototype.pillbox;

import com.example.pillbox.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class JournalFragment extends Fragment {
     
    public JournalFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_journal, container, false);
          
        return rootView;
    }
}