package com.insinoorityo.kuntojaba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.KuntoJaba.R;


public class CalendarActivity_backup extends Fragment {

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
	public static final FileInputStream inputStream = null;
	public static FileOutputStream outputStream = null;
	public static String collected = null;
	public static byte[] dataArray = new byte[0];
	public static SQLite dbhelper;
	private SQLiteDatabase database;
	
	
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

	
	//	dbhelper = new SQLite(getActivity());
		//DbHelper1 info = new DbHelper1(getActivity().getApplicationContext());
	//	info.open();
	//	String data = info.getData();
	//	info.close();
		
	//	Log.d("CALENDARACTIVITY", "getdata arvo: " + data);
		
		
		Log.d("collectedarvo", "on: " + collected);
		Log.d("augustarvo", "on: " + august[0]);
		Log.d("augustarvo", "on: " + august[1]);
		Log.d("augustarvo", "on: " + august[2]);
		
		
		
		SharedPreferences pref = getActivity().getSharedPreferences("august_pref", Activity.MODE_PRIVATE);
		int myStoredValue = pref.getInt("marked_days_august", -1);
	    
		Log.d("t�h�n pit�is tulla se yhen p�iv�n arvo", "myStorevalue: " + myStoredValue);
		

		//kyll� t�h�n tulee oikea value
		//nyt pit�is vaa v�rj�� kaikki mitk� on saanu positionin oikein :D  
	    
	    
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
		
		
		final String FILENAME = "internaldata";
		


		try {
			grid_august.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				
			//	SharedPreferences pref = this.getActivity().getSharedPreferences("august_pref", Context.MODE_PRIVATE);
				
				int[] marked_days = new int[32];
				FileOutputStream fos = getActivity().openFileOutput(FILENAME, Context.MODE_APPEND);
				
				
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Log.d("kaatuu?","calactivity6");
					
					boolean didItWork = true;
					try{
					int day_value = position + 1;
					
					Log.d("tryssa", "dayvalue: " + day_value);
			//		dbhelper = new SQLite(context);
					Log.d("KYLL� TOIMII", "1: " + day_value);
			//		dbhelper.onOpen(database);
					Log.d("KYLL� TOIMII", "2: " + day_value);
			//		dbhelper.createEntry(day_value);
					Log.d("KYLL� TOIMII", "3: " + day_value);
					
			//		dbhelper.close();
					}catch (Exception e) {
						didItWork = false;
					}finally {
						if(didItWork){
							Log.d("KYLL� TOIMII", "kait");
						}
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					for(int i=1; i<august.length;i++){
						
						if(august[i].equals(collected)) {
							
							Log.d("iflause", "august: " + august[i]);
						}
						
					}

					
					int marked_position = 0;
					marked_position = position + 1;
					String test_string = Integer.toString(marked_position);
					

					if(stateChanged == null) {
						
						stateChanged = view.getResources();
						view.setBackgroundResource(R.color.green);
						
						try {
							String separator = System.getProperty("line.separator");
							fos = getActivity().openFileOutput(FILENAME+".txt", Context.MODE_APPEND);
							Writer writer = new OutputStreamWriter(fos);
							writer.write(test_string);
							writer.append('\n');
							writer.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						//String collected = null;
						FileInputStream fis = null;
						try {
							fis = getActivity().openFileInput(FILENAME+".txt");
							BufferedReader r = new BufferedReader(new InputStreamReader(fis));
						//	String line = r.readLine();
						//	r.close();
							byte[] dataArray = new byte[fis.available()];
							while(fis.read(dataArray) != -1){
								
								
								collected = new String(dataArray);
								Log.d("array", "data: " + collected);
								
								
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							try {
								fis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
						
						try {
							fos.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						
						
						
						
						
						
						/*
						SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
						JSONArray arr = new JSONArray();
						arr.put(marked_position);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("marked_days_august", arr.toString());
						Log.d("markeddayaugust: ", "arvo: " + arr);
						editor.commit();
						
						
						
						
							
							try {
								Log.d("json","1");
								JSONArray arr2 = new JSONArray(pref.getString("marked_days_august", "[]"));
								
								for(int i = 0; i < arr2.length(); i++) {
									Log.d("my JSON array ", arr2.getInt(i)+"");
									
									
								}
								Log.d("json","2");
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							*/
							
						
						
						
						
						/*
						SharedPreferences pref = getActivity().getSharedPreferences("august_pref", Activity.MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putInt("marked_days_august", marked_days[marked_position]);
						editor.commit();
						
						Log.d("markeddays", "arvo: " + marked_days[0]);
						Log.d("markeddays", "arvo1: " + marked_days[1]);
						Log.d("markeddays", "arvo2: " + marked_days[2]);
						Log.d("markeddays", "arvo3: " + marked_days[3]);
						Log.d("markeddays", "arvo4: " + marked_days[4]);
						*/
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

				//	SharedPreferences pref = getActivity().getSharedPreferences("august_pref", Activity.MODE_PRIVATE);
				//	int myStoredValue = pref.getInt("marked_days_august", -1);
					
				//	Log.d("markeddays", "arvo: " + myStoredValue);
					
					
					
					
					
					//selectorilla t�� taitaa selvit�!
				//	view.setBackgroundResource(R.color.background_color_selector);
					
					
			//		parent.getChildAt(position).setBackgroundColor(Color.BLUE);
					
			//		int save = 0;
			//		if(save != -1 && save != position) {
						
			//			parent.getChildAt(save).setBackgroundColor(Color.BLACK);
			//		}
					
			//		save = position;
					
				}


				
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
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



