package com.insinoorityo.kuntojaba;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.KuntoJaba.R;

public class CalendarActivity extends Fragment {
	
	//CalendarView calendar;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.calendar_layout, container, false);
        return rootView;
    }
	
	
	
	
 
}


