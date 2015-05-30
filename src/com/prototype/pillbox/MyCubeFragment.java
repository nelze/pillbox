package com.prototype.pillbox;

import com.example.pillbox.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class MyCubeFragment extends Fragment {
     
    public MyCubeFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_mycube, container, false);
          
        return rootView;
    }
}