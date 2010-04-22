package com.github.stchris.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.github.stchris.models.Book;
import com.github.stchris.models.BookListAdapter;
import com.github.stchris.queries.Constants;
import com.github.stchris.util.JSONUtil;

public class BookSearchActivity extends ListActivity {

	private Book[] books;

	/**
	 * Intent action for BookSearchActivity.
	 */
	public static final String ACTION = "com.github.stchris.action.BookSearchAction";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String searchString = "";
		String searchEngine = "";
		String searchEngineCode = "";
		final Intent intent = getIntent();
		if (ACTION.equals(intent.getAction())) {
			searchString = intent.getExtras()
					.getString(Constants.SEARCH_STRING);
			searchEngine = intent.getExtras()
					.getString(Constants.SEARCH_ENGINE);
		}
		
		if (searchEngine.equals("BookMooch")) {
			searchEngineCode = "bm"; 
		} else if (searchEngine.equals("Amazon.com")) {
			searchEngineCode = "amazon.com";
		} else if (searchEngine.equals("Amazon.de")) {
			searchEngineCode = "amazon.de";
		} else if (searchEngine.equals("Amazon.co.uk")) {
			searchEngineCode = "amazon.co.uk";
		} else if (searchEngine.equals("Amazon.co.jp")) {
			searchEngineCode = "amazon.co.jp";
		} else if (searchEngine.equals("Amazon.fr")) {
			searchEngineCode = "amazon.fr";
		} else if (searchEngine.equals("Amazon.ca")) {
			searchEngineCode = "amazon.ca";
		}

		books = JSONUtil.searchBooks(searchString, searchEngineCode);
		setListAdapter(new BookListAdapter(this, books));
		getListView().setTextFilterEnabled(true);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Intent bookInfoIntent = new Intent(BookInfoActivity.ACTION);
		bookInfoIntent.putExtra(Constants.ISBN_PARAMETER, books[position].isbn);
		startActivity(bookInfoIntent);
	}

}
