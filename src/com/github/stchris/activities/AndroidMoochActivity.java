package com.github.stchris.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.github.stchris.R;
import com.github.stchris.queries.Constants;

/**
 * Main AndroidMooch {@link Activity}.
 * 
 * @author chris
 * 
 */
public class AndroidMoochActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final EditText isbnText = (EditText) findViewById(R.id.isbntext);
		final Button btnBookInfo = (Button) findViewById(R.id.btnBookInfo);
		final EditText searchText = (EditText) findViewById(R.id.searchtext);
		final Button btnSearchBook = (Button) findViewById(R.id.btnSearchBook);

		isbnText.setText("0445408499");
		btnBookInfo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent bookInfoIntent = new Intent(BookInfoActivity.ACTION);
				bookInfoIntent.putExtra(Constants.ISBN_PARAMETER, isbnText.getText().toString());
				startActivity(bookInfoIntent);
			}

		});
		
		btnSearchBook.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent bookSearchIntent = new Intent(BookSearchActivity.ACTION);
				bookSearchIntent.putExtra(Constants.SEARCH_STRING, searchText.getText().toString());
				startActivity(bookSearchIntent);
			}
		});
	}
}