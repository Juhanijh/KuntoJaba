package com.insinoorityo.kuntojaba;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.example.KuntoJaba.R;


public class MainActivity extends Activity {

	ActionBar.Tab Tab1, Tab2, Tab3;
	//luodaan fragmentit javaluokista CalendarActivity ja logActivity
	Fragment calendarActivity = new CalendarActivity();
	Fragment logActivity = new LogActivity();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ActionBar actionBar = getActionBar();

		// n�yt� actionbarin iconi
		actionBar.setDisplayShowHomeEnabled(true);

		// n�yt� actionbarin nimi = sovelluksen nimi
		actionBar.setDisplayShowTitleEnabled(true);

		// luodaan actionbaariin v�lilehdet "tabit"
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// laitetaan actionbaariin iconit ja nimet tabeille
		Tab1 = actionBar.newTab().setText("Calendar").setIcon(R.drawable.ic_action_event);
	//	Tab1 = actionBar.newTab().setIcon(R.drawable.tab1);
		Tab2 = actionBar.newTab().setText("Log Workout").setIcon(R.drawable.ic_action_new);
	//	Tab3 = actionBar.newTab().setText("Tab3");

		// tab listenerit kuntoon
		Tab1.setTabListener(new TabListener(calendarActivity));
		Tab2.setTabListener(new TabListener(logActivity));
	//	Tab3.setTabListener(new TabListener(fragmentTab3));

		// lis�t��n actionbaariin kaks "tabia"
		actionBar.addTab(Tab1);
		actionBar.addTab(Tab2);
	//	actionBar.addTab(Tab3);
		
		
	}


}
