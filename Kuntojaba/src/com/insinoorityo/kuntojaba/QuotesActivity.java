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
	
	private static final String QUOTE_FILE = "motivation_database_new2.csv";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("quote", "1");
		View view = inflater.inflate(R.layout.quotes_fragment, container, false);
		Button quoteButton = (Button)view.findViewById(R.id.quotesButton);
		final TextView quoteView = (TextView)view.findViewById(R.id.textView_quote);
		List quotelist;
		
		
		quoteButton.setOnClickListener(new View.OnClickListener() {
			
		InputStream is = getResources().openRawResource(R.raw.motivation_database_new2);	
		//String[] row = null;
		String result = null;
		
			
			public void onClick(View v) {
				
				BufferedInputStream bis = new BufferedInputStream(is);
				ByteArrayBuffer baf = new ByteArrayBuffer(50);
				
				Log.d("quote", "baf" + bis);
				Log.d("quote", "baf" + baf);
				
				
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
	//			int index = randomGenerator.nextInt(stockTx.length());
				
				@SuppressWarnings("resource")
				Scanner lineScanner = new Scanner(stockTx);
		//		while(lineScanner.hasNext()){
				
				
				
		//		String line = lineScanner.nextLine();
				
				
		//		Log.d("scanner", "line: " +line);
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
				
			//	}
				/*
				 * 
				String stockNumber = tokens[0];
				String stockQuote = tokens[1];
				String stockWhoSaid = tokens[2];
				*/
				//String fstackSymbol = stockNumber.substring(0, stockNumber.length());
				
				//Log.d("while", "1" + fstackSymbol);
		

				
				
				//jos halutaan eroon lainaus merkeist�
				//String fstackSymbol = stockNumber.substring(1, stockNumber.length() -1);
				
				//Log.d("quote", "2,5" + stockNumber);
				//Log.d("quote", "2,5" + stockQuote);
			//	Log.d("quote", "2,5" + stockWhoSaid);
			//	quoteView.setText(stockTx);

				
/*
 * 
				try {
					Log.d("quote", "1,6");
					@SuppressWarnings("resource")
					Scanner s = new Scanner(getResources().openRawResource(R.raw.motivation_database_new2));
					Log.d("quote", "1,7");
					//File file = new File("res/raw/motivation_database_new2.csv");
					String quotesFile = "K:\\Metropolia\\opinnaytetyo_halkola_koodi\\Kuntojaba\\res\\raw\\motivation_database_new2.csv";
					Log.d("quote", "1,8");
					CSVReader reader = new CSVReader(new FileReader(quotesFile));
					Log.d("quote", "1,9");
					
					String[] nextLine = null;
					Log.d("quote", "2");
					while((nextLine = reader.readNext()) != null) {
						
						System.out.println(nextLine[0]);
						Log.d("while", "3");
						System.out.println(reader);
						
					}
					

				} catch (Exception e) {
					// TODO: handle exception
				}
				*/
				
				
				
				
				
				
				
				
				
				

				//onclickin sis�ll�
			}

			
		});
		return view;
		
	}

	
}
	
	


