package com.insinoorityo.kuntojaba;

import com.example.KuntoJaba.R;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SQLite extends Fragment {
	
	Button sqlUpdate;
	Button sqlView;
	EditText sqlWorkout;
	EditText sqlWorkoutDate;
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.log_fragment, container, false);
		Log.d("sqlite", "1: " );
		
		sqlUpdate = (Button)view.findViewById(R.id.button_update);
		sqlView = (Button)view.findViewById(R.id.button_view);
		
		sqlWorkout = (EditText)view.findViewById(R.id.workout_name);
		sqlWorkoutDate = (EditText)view.findViewById(R.id.workout_day);
		

		sqlUpdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("sqlite", "3: " );
				String workout = sqlWorkout.getText().toString();
				String workout_date = sqlWorkoutDate.getText().toString();
				
				LogActivity entry = new LogActivity(getActivity());
				entry.open();
				entry.createEntry(workout, workout_date);
				entry.close();
				Log.d("workout", "arvo: " + workout);
				Log.d("workoutday", "arvo: " + workout_date);
	
				
			}
		});
		
		sqlView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("sqlite", "4: " );
				Intent i = new Intent("android.intent.action.SQLVIEW");
				Log.d("sqlite", "4,5: " );
				startActivity(i);
				Log.d("sqlite", "5: " );
				
			}
		});
		return view;
	}


	
}


	
