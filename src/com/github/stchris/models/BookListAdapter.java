package com.github.stchris.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.stchris.R;
import com.github.stchris.util.Util;

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
		final Book book = books[position];
		RelativeLayout rowLayout = null;
		if (convertView == null) {
			rowLayout = (RelativeLayout) LayoutInflater.from(context).inflate(
					R.layout.booklistview, parent, false);
			TextView tv = (TextView) rowLayout.findViewById(R.id.tvBookListAuthor);
			tv.setText(book.author);
			tv = (TextView) rowLayout.findViewById(R.id.tvBookListTitle);
			tv.setText(book.title);
			ImageView img = (ImageView) rowLayout.findViewById(R.id.imgBookList);
			Bitmap bmp = Util.loadBitmap(book.smallImgUrl);
			if (bmp != null) {
				img.setImageBitmap(bmp);
			};
		} else {
			rowLayout = (RelativeLayout) convertView;
		}
		return rowLayout;
	}

}
