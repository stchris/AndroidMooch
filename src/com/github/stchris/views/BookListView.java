package com.github.stchris.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookListView extends LinearLayout {

	private TextView tvTitle;
	private TextView tvAuthor;
	
	public BookListView(Context context) {
		super(context);
	}

	public BookListView(Context context, String title, String author) {
		this(context);
		this.setOrientation(VERTICAL);
		tvTitle = new TextView(context);
		tvTitle.setText(title);
		tvAuthor = new TextView(context);
		tvAuthor.setText(author);
		
		addView(tvTitle, new LinearLayout.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		addView(tvAuthor, new LinearLayout.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	}
	
	public void setTitle(String title) {
		tvTitle.setText(title);
	}
	
	public void setAuthor(String author) {
		tvAuthor.setText(author);
	}
}
