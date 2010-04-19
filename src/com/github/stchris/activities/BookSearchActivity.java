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
		final Intent intent = getIntent();
		if (ACTION.equals(intent.getAction())) {
			searchString = intent.getExtras()
					.getString(Constants.SEARCH_STRING);
		}

		books = JSONUtil.searchBooks(searchString, "bm");
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
