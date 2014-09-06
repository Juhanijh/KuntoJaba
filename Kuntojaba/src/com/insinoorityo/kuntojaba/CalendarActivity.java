package com.insinoorityo.kuntojaba;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Fragment;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.FeatureInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.KuntoJaba.R;
import com.insinoorityo.kuntojaba.CalendarAdapter.GridObject;

public class CalendarActivity extends Fragment  {

	public static Context context;
	GridView grid_august;
	GridView grid_september;
	GridView grid_dayofweek;
	View BackgroundView;
	public static ArrayAdapter<String> daysList = null;
	public static Adapter gridAdapter2 = null;
	public static CalendarAdapter gridAdapter = null;
	public static int flag = -1;
	private Resources stateChanged;
	public static final String PREFS_NAME = "MyPrefsFile";
	//private static final int COLORED = 0;
	public static final FileInputStream inputStream = null;
	public static FileOutputStream outputStream = null;
	
	
	String[] dayofweek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	
	String[] august = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
			"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	
	String[] september = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
			"22", "23", "24", "25", "26", "27", "28", "29", "30" };
	
	
	
	@Override
	public View onCreateView(LayoutInflater inlater, ViewGroup container, Bundle savedInstanceState) {
		Log.d("kaatuu?","calactivity1");
		final String filename = "colored_days";
		
	//	SharedPreferences pref = this.getActivity().getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE); 
	    FileInputStream inputStream = openFileInput(filename);
	    
	    
		
		
		
	//	int storedValue = pref.getInt("day_colored", 0);
		

		//kyll� t�h�n tulee oikea value
		//nyt pit�is vaa v�rj�� kaikki mitk� on saanu positionin oikein :D
		
	//	Log.d("calact2", "stored:  " +storedValue);
		
	    
	 //   pref.getInt("day_colored", COLORED);
	    
	    
	    
		context = inlater.getContext();
		//k�ytet��n calendar_layout2 viewi� 
		View rootView = inlater.inflate(R.layout.calendar_fragment, container, false);
		gridAdapter = new CalendarAdapter(context, august);
		
		grid_dayofweek = (GridView)rootView.findViewById(R.id.grid_dayofweek);
		daysList = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dayofweek);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dayofweek);
		grid_dayofweek.setAdapter(adapter);
		
//**************************************************************************************************************	
		//T�ST� KOPIOITU NOTEPADIIN
		

		grid_august = (GridView)rootView.findViewById(R.id.grid_august);
		grid_august.setAdapter(gridAdapter);
		
		
		
		

		grid_august.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			int marked_days[] = {};

			
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.d("kaatuu?","calactivity6");
				Log.d("ITEMI� KLIKATTU JEE AUGUST", "" + (String) (grid_august.getItemAtPosition(position)));
				Log.d("onitemclick", "id" + id);
				
				int marked_position = 0;
				marked_position = position + 1;
				

				if(stateChanged == null) {
					
					stateChanged = view.getResources();
					view.setBackgroundResource(R.color.green);
					
					/*ei toimi oikee
					outputStream = openFileOutput(filename, Context.MODE_APPEND);
					try {
						outputStream.write(marked_days[marked_position]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/
					
					
					//editor.putInt("day_colored", marked_position);
					Log.d("onclick-ifstatedchanged", "marketposition: " + marked_position);
				//	editor.commit();
				} else {
					
					view.setBackgroundResource(R.color.background_color_selector);
					stateChanged = null;
					
				}

				
				
				
				
				
				
				
				
				//selectorilla t�� taitaa selvit�!
			//	view.setBackgroundResource(R.color.background_color_selector);
				
				
		//		parent.getChildAt(position).setBackgroundColor(Color.BLUE);
				
		//		int save = 0;
		//		if(save != -1 && save != position) {
					
		//			parent.getChildAt(save).setBackgroundColor(Color.BLACK);
		//		}
				
		//		save = position;
				
			}

			private FileOutputStream openFileOutput(String filename,
					int modeAppend) {
				// TODO Auto-generated method stub
				return null;
			}


			
		});
		
		
		
		
		
		
		
//***************************************************************************************************************
		grid_september = (GridView)rootView.findViewById(R.id.grid_september);
		daysList = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, september);
		final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, september);
		grid_september.setAdapter(adapter3);
		
		
		grid_september.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						Toast.makeText(getActivity(), "You Clicked at " + september[+position],
						Toast.LENGTH_SHORT).show();
					}
				});
//***************************************************************************************************************
		
		
		
		
		
		
		
		
		return rootView;
		
	}



	private FileInputStream openFileInput(String filename) {
		// TODO Auto-generated method stub
		return null;
	}



	private Context getApplicationContext() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void onStop() {

		super.onStop();
	
		
		
		
		
		
	}

	
	/*
	private void adapterGuy() {

		final String[] august = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
				"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

		String[] september = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
				"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		
		
		Log.d("MISS� KAATUU", "6");
		daysList = new ArrayAdapter<String>(null, android.R.layout.simple_list_item_1, august);
		daysList = new ArrayAdapter<String>(null, android.R.layout.simple_list_item_1, september);
		
		grid_august.setAdapter(daysList);
		
		grid_august.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(null, "You Clicked at " + august[+position],Toast.LENGTH_SHORT).show();
			}
		});
		
	}
}
*/
}

	/*
	 * N�� HELVETTII EI TOIMI :D:DD: Button add_button;
	 * 
	 * public View onCreateView(LayoutInflater inflater, ViewGroup container,
	 * Bundle savedInstanceState) {
	 * 
	 * //luodaan n�kym� xml tiedostosta View view =
	 * inflater.inflate(R.layout.calendar_layout, container, false);
	 * 
	 * //haetaan xml tiedostosta n�pp�imen id Button add_button = (Button)
	 * view.findViewById(R.id.add_button);
	 * 
	 * //luodaan kuuntelija n�pp�imelle add_button.setOnClickListener(new
	 * View.OnClickListener() {
	 * 
	 * 
	 * 
	 * @Override public void onClick(View v) { Activity activity =
	 * getActivity();
	 * 
	 * 
	 * if (activity != null) { Toast.makeText(activity,
	 * "R.string.toast_you_just_clicked_a_fragment", Toast.LENGTH_LONG).show();
	 * Log.d("button", "MIK� T�� ARVO ON " + activity + v);
	 * 
	 * } }
	 * 
	 * });
	 * 
	 * return view; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * /* public void buttonAdd() { Button addButton = new
	 * Button(getActivity());
	 * 
	 * Toast.makeText(getActivity(), "this is my Toast message!!! =)",
	 * Toast.LENGTH_LONG).show();
	 * 
	 * Log.d("ADDBUTTON", "oisko t�� paska toiminu"); } kokeilua
	 */


// lis�� viel� namiskalle kuva hymi� ::)

