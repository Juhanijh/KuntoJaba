package com.insinoorityo.kuntojaba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.KuntoJaba.R;

public class CalendarAdapter extends BaseAdapter {
	
	         private Context context;
	         private String[] items;
	         LayoutInflater inflater;
	         
	         public CalendarAdapter(Context context, String[] items) {
	        	 
	        	 Log.d("kaatuu?","caladapter1");
	        	 this.context = context;
	        	 this.items = items;
	        	 Log.d("kaatuu?","caladapter1,1");
	        	 inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        	 Log.d("kaatuu?","caladapter1,2");
	         }
	         

			@Override
				public View getView(int position, View convertView, ViewGroup parent) {
	        	 

	        	 
	        	 Log.d("kaatuu?","caladapter1,5");
	        	 	if(convertView == null) {
	        	 		Log.d("kaatuu?","caladapter2");
	        	 		//k�ytet��n item_gridviewi� layouttina, joka sis�lt�� vain yhen napin
	        	 		convertView = inflater.inflate(R.layout.item_gridview, null);
	        	 	}

	        	 	
	        	 	Button button = (Button) convertView.findViewById(R.id.grid_item_button);
	        	 	button.setText(items[position]);
	        	 	Log.d("kaatuu?","caladapter3");
	        	 	
	        	 	
	        	 	
	        	 	
	        	 
					return convertView;
				}

			@Override
			public int getCount() {
				return items.length;
			}

			@Override
			public Object getItem(int position) {
				return items[position];
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			
	       
	    public class GridObject {
	    	
	    	private String name;
	        private int state;

	        public GridObject(String name, int state) {
	            super();
	            this.name = name;
	            this.state = state;
	        }

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        public int getState() {
	            return state;
	        }

	        public void setState(int state) {
	            this.state = state;
	        }   
	    	
	    	
	    }

	}