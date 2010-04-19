package com.github.stchris.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.github.stchris.R;
import com.github.stchris.queries.Constants;
import com.github.stchris.util.Util;

public class ShowImageActivity extends Activity {

	/**
	 * Intent action for ShowImageActivity.
	 */
	public static final String ACTION = "com.github.stchris.action.ShowImageAction";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showimage);
		
		final ImageView imgView = (ImageView) findViewById(R.id.imgToShow);

		final Intent intent = getIntent();
		String imageToShow = "";
		if (ACTION.equals(intent.getAction())) {
			imageToShow = intent.getExtras().getString(Constants.IMAGE_TO_SHOW);
		}
		
		imgView.setImageBitmap(Util.loadBitmap(imageToShow));
	}
	
}
