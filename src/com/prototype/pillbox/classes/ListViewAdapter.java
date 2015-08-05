package com.prototype.pillbox.classes;


import java.util.ArrayList;

import com.example.pillbox.R;
 
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.Switch;
import android.widget.TextView;
 
public class ListViewAdapter extends ArrayAdapter {
 
        private final Context context;
        private final ArrayList<MedicineInfo> itemsArrayList;
 
        public ListViewAdapter(Context context, ArrayList<MedicineInfo> itemsArrayList) {
 
            super(context, R.layout.indiv_medicine, itemsArrayList);
 
            this.context = context;
            this.itemsArrayList = itemsArrayList;
        }
 
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
 
            // 1. Create inflater 
            LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
            // 2. Get rowView from inflater
            View rowView = inflater.inflate(R.layout.indiv_medicine, parent, false);
 
            // 3. Get the two text view from the rowView
            TextView nameView = (TextView) rowView.findViewById(R.id.name);
            TextView dosageView = (TextView) rowView.findViewById(R.id.dosage);
            TextView statusView = (TextView) rowView.findViewById(R.id.status);
            TextView scheduleView = (TextView) rowView.findViewById(R.id.schedule);
            TextView tabletsremView = (TextView) rowView.findViewById(R.id.tabletsrem);
            Switch active = (Switch)rowView.findViewById(R.id.switch1);
 
            // 4. Set the text for textView 
            nameView.setText(itemsArrayList.get(position).getName());
            dosageView.setText(itemsArrayList.get(position).getDosage());
            statusView.setText(itemsArrayList.get(position).getStatus());
            scheduleView.setText(itemsArrayList.get(position).getSchedule());
            tabletsremView.setText(itemsArrayList.get(position).getTabletsRem());
            if (itemsArrayList.get(position).getStatus().equalsIgnoreCase("active"))
            	active.setChecked(true);
            else
            	active.setChecked(false);
 
            // 5. retrn rowView
            return rowView;
        }

}