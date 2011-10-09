package com.github.stchris.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.github.stchris.R;
import com.github.stchris.queries.Constants;

/**
 * Main AndroidMooch {@link Activity}.
 * 
 * @author chris
 * 
 */
public class BookSearchActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		final EditText isbnText = (EditText) findViewById(R.id.isbntext);
		final Button btnBookInfo = (Button) findViewById(R.id.btnBookInfo);
		final EditText searchText = (EditText) findViewById(R.id.searchtext);
		final Button btnSearchBook = (Button) findViewById(R.id.btnSearchBook);

		final Spinner spinnerSearchEngine = (Spinner) findViewById(R.id.spinnerSearchEngine);
		SpinnerAdapter searchEngineSpinnerAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, new String[] {
						"BookMooch", "Amazon.com", "Amazon.de", "Amazon.co.uk",
						"Amazon.co.jp", "Amazon.fr", "Amazon.fr" });
		spinnerSearchEngine.setAdapter(searchEngineSpinnerAdapter);

		btnBookInfo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent bookInfoIntent = new Intent(BookInfoActivity.ACTION);
				bookInfoIntent.putExtra(Constants.ISBN_PARAMETER, isbnText
						.getText().toString());
				startActivity(bookInfoIntent);
			}

		});

		btnSearchBook.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent bookSearchIntent = new Intent(BookSearchListActivity.ACTION);
				bookSearchIntent.putExtra(Constants.SEARCH_STRING, searchText
						.getText().toString());
				bookSearchIntent.putExtra(Constants.SEARCH_ENGINE,
						spinnerSearchEngine.getSelectedItem()
								.toString());
				startActivity(bookSearchIntent);
			}
		});
	}
}