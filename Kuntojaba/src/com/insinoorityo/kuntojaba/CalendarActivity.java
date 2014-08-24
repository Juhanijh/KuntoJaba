package com.insinoorityo.kuntojaba;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.KuntoJaba.R;

public class CalendarActivity extends Fragment {


	GridView grid_august;
	GridView grid_september;
	GridView grid_dayofweek;
	View BackgroundView;
	public static ArrayAdapter<String> daysList;
	
	String[] dayofweek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	
	String[] august = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
			"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	
	String[] september = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
			"22", "23", "24", "25", "26", "27", "28", "29", "30" };
	
	
	
	@Override
	public View onCreateView(LayoutInflater inlater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//k�ytet��n calendar_layout2 viewi� 
		View rootView = inlater.inflate(R.layout.calendar_layout2, container, false);

		
		grid_dayofweek = (GridView)rootView.findViewById(R.id.grid_dayofweek);
		daysList = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dayofweek);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dayofweek);
		grid_dayofweek.setAdapter(adapter);
		
//**************************************************************************************************************	
		grid_august = (GridView)rootView.findViewById(R.id.grid_august);
		daysList = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, august);
		final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, august);
		grid_august.setAdapter(adapter2);
		
		
		grid_august.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						Toast.makeText(getActivity(), "You Clicked at " + august[+position],
						Toast.LENGTH_SHORT).show();
						Log.d("CLIKKAUS", "MIK�S VITTU T�� ARVO ON T�S " + id);
				/*
						grid_august.setSelector(R.color.background_color_selector);
						grid_august.setItemChecked(position, true);
						grid_august.setSelection(position);
						grid_august.setSelected(true);
					*/
						
						//view.setBackgroundResource(R.color.background_color_selector);
						grid_august.getChildAt(position).setBackgroundColor(Color.GREEN);
						adapter2.notifyDataSetChanged();
						
						

						
						
						
						
						
						
						
						/*KAKKA merkkaa vaa yhen p�iv�n
						if(BackgroundView != null)
							BackgroundView.setBackgroundColor(Color.WHITE);
						
						view.setBackgroundColor(Color.GREEN);
						BackgroundView = view;				
						
						
						adapter2.notifyDataSetChanged();
						*/
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

