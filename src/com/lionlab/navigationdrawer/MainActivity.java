package com.lionlab.navigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String[] drawer_content = { "Example", "Navigation",
			"drawer" };
	private ListView listView;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle actionBarDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.left_drawer);
		listView.setAdapter(new ArrayAdapter<String>(getBaseContext(),
				android.R.layout.simple_list_item_1, drawer_content));

		listView.setOnItemClickListener(new DrawerItemListener());

		drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
		actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
				drawerLayout, R.drawable.ic_launcher, R.string.app_name,
				R.string.hello_world) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Close");
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Open");
				invalidateOptionsMenu();
			}
		};

		drawerLayout.setDrawerListener(actionBarDrawerToggle);
	}

	private class DrawerItemListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {

			Toast.makeText(MainActivity.this, "Selected" + arg2,
					Toast.LENGTH_SHORT).show();
		}
	}

}
