package com.insinoorityo.kuntojaba;

import com.example.KuntoJaba.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SQLView extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("sqlview", "1");
		setContentView(R.layout.sqlview);
		Log.d("sqlview", "2");
		TextView tv = (TextView)findViewById(R.id.tv_workout_data);
		LogActivity info = new LogActivity(this);
		Log.d("sqlview", "3");
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
	}

}
