package com.prototype.pillbox;

import com.example.pillbox.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class MedicineFragment extends Fragment {
     
    public MedicineFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_medicine, container, false);
          
        return rootView;
    }
}