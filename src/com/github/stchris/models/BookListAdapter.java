package com.github.stchris.models;

import com.github.stchris.views.BookListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class BookListAdapter extends BaseAdapter {

	private Book[] books;
	private Context context;

	public BookListAdapter(Context context, Book[] books) {
		this.context = context;
		this.books = books;
	}

	public int getCount() {
		return books.length;
	}

	public Object getItem(int pos) {
		return books[pos];
	}

	public long getItemId(int pos) {
		return pos;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		BookListView bv;
		if (convertView == null) {
			Book b = books[position];
			bv = new BookListView(context, b.title, b.author);
		} else {
			bv = (BookListView) convertView;
			Book b = books[position];
			bv.setTitle(b.title);
			bv.setAuthor(b.author);
		}
		return bv;
	}

}
