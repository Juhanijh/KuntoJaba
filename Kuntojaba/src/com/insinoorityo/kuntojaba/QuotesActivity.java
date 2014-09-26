package com.insinoorityo.kuntojaba;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.http.util.ByteArrayBuffer;

import android.R.string;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import au.com.bytecode.opencsv.CSVReader;

import com.example.KuntoJaba.R;

	

public class QuotesActivity extends Fragment {
	
	//private static final String QUOTE_FILE = "motivation_database_new2.csv";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("quote", "1");
		View view = inflater.inflate(R.layout.quotes_fragment, container, false);
		final Button quoteButton = (Button)view.findViewById(R.id.quotesButton);
		final TextView quoteView = (TextView)view.findViewById(R.id.textView_quote);
		
	//	quoteButton.setBackground(getResources().getDrawable(R.drawable.quote_button_selector));
		
		
		quoteButton.setOnClickListener(new View.OnClickListener() {
			boolean isPressed = false;
		InputStream is = getResources().openRawResource(R.raw.motivation_database_new2);	
		//String[] row = null;
		String result = null;
		
			
			public void onClick(View v) {
				
				/*
				if(isPressed) {
					quoteButton.setBackgroundResource(R.drawable.kuntojaba_background_testi2);
				}else {
					quoteButton.setBackgroundResource(R.drawable.kuntojaba_background_testi3);
					
				}
				isPressed = true;
				*/
				BufferedInputStream bis = new BufferedInputStream(is);
				ByteArrayBuffer baf = new ByteArrayBuffer(50);
				

				int current = 0;
				
				try {
					while ((current = bis.read()) != -1) {
						baf.append((byte) current);
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String stockTx = new String(baf.toByteArray());
				Random randomGenerator = null;
				
				@SuppressWarnings("resource")
				Scanner lineScanner = new Scanner(stockTx);

				Log.d("scanner", "linescanner: " +lineScanner);
				
				 
			     Random rand = new Random();
			     int n = 0;
			     for(Scanner sc = new Scanner(stockTx); sc.hasNext();)
			     {
			        ++n;
			        String line1 = sc.nextLine();
			        if(rand.nextInt(n) == 0)
			           result = line1;
			        
			     }
			     
			     Log.d("result", "result:" + result); 
				 quoteView.setText(result);
				 quoteView.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));
				

			}

			
		});
		return view;
		
	}

	
}
	
	


