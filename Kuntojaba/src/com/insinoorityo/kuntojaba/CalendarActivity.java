package com.insinoorityo.kuntojaba;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.KuntoJaba.R;

public class CalendarActivity extends Fragment {
	
	CalendarView cal;

	@Override
	public View onCreateView(LayoutInflater inlater, ViewGroup container,
			Bundle savedInstanceState) {
		
	    	View rootView = inlater.inflate(R.layout.calendar_fragment2, container, false);
	    	
	    	cal = (CalendarView)rootView.findViewById(R.id.calendarView);
		
		
				return rootView;

	}

}