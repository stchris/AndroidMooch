package com.github.stchris.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

import com.github.stchris.R;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, BookSearchActivity.class);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost
				.newTabSpec("search")
				.setIndicator("Search",
						res.getDrawable(R.drawable.tab_search))
				.setContent(intent);
		tabHost.addTab(spec);

		// Do the same for the other tabs
		intent = new Intent().setClass(this, InventoryActivity.class);
		spec = tabHost
				.newTabSpec("inventory")
				.setIndicator("Inventory",
						res.getDrawable(R.drawable.tab_inventory))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, WishlistActivity.class);
		spec = tabHost
				.newTabSpec("wishlist")
				.setIndicator("Wishlist", res.getDrawable(R.drawable.tab_wishlist))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);

	}

}
