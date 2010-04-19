package com.github.stchris.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.stchris.R;
import com.github.stchris.models.Book;
import com.github.stchris.queries.Constants;
import com.github.stchris.util.JSONUtil;
import com.github.stchris.util.Util;

public class BookInfoActivity extends Activity {

	/**
	 * Intent action for BookInfoActivity.
	 */
	public static final String ACTION = "com.github.stchris.action.BookInfoAction";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookinfo);

		final TextView tv = (TextView) findViewById(R.id.tvBookInfo);
		final ImageButton img = (ImageButton) findViewById(R.id.imgBookinfoSmall);

		String isbn = "";
		final Intent intent = getIntent();
		if (ACTION.equals(intent.getAction())) {
			isbn = intent.getExtras().getString(Constants.ISBN_PARAMETER);
		}

		final Book book = JSONUtil.getBookInfo(isbn);
		tv.setText(book.toString());
		if (book.smallImgUrl != null && !"".equals(book.smallImgUrl.trim())) {
			img.setImageBitmap(Util.loadBitmap(book.smallImgUrl));
			img.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Intent showImageIntent = new Intent(
							ShowImageActivity.ACTION);
					showImageIntent.putExtra(Constants.IMAGE_TO_SHOW,
							book.largeImgUrl);
					startActivity(showImageIntent);
				}
			});
		}
	}

}
