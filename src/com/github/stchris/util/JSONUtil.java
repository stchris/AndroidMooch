package com.github.stchris.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.github.stchris.models.Book;
import com.github.stchris.queries.Constants;

/**
 * JSON handlers and parsers.
 * 
 * @author chris
 * 
 */
public class JSONUtil {

	/**
	 * Logging tag.
	 */
	private static final String TAG = "JSONUtil";

	/**
	 * Call the asin service and get book information for one book.
	 * 
	 * @param asin
	 *            the amazon id or ISBN of the book to query
	 * @return Book model
	 */
	public static Book getBookInfo(String asin) {
		if (asin == null || "".equals(asin.trim())) {
			return new Book();
		}
		return getBooksInfoFromJSON(getJSON(Constants.ASINS_URL.replace(
				Constants.ASINS_URL_PLACEHOLDER, asin)))[0];
	}

	public static Book[] searchBooks(String query, String db) {
		if (query == null || "".equals(query.trim())) {
			return null;
		}
		String url = Constants.SEARCH_URL.replace(Constants.SEARCH_URL_DB, db);
		url = url.replace(Constants.SEARCH_URL_QUERY, query);
		return getBooksInfoFromJSON(getJSON(url));
	}

	/**
	 * Parse the given JSON and fill a Book model entry.
	 * 
	 * @param json
	 *            book info
	 * @return Book model
	 */
	private static Book[] getBooksInfoFromJSON(String json) {
		List<Book> books = new ArrayList<Book>();
		try {
			JSONArray arr = new JSONArray(json);
			for (int i = 0; i < arr.length(); i++) {
				JSONObject bookJSON = arr.getJSONObject(i);
				Book book = new Book();
				book.author = safeGet(bookJSON, Constants.KEY_AUTHOR);
				book.title = safeGet(bookJSON, Constants.KEY_TITLE);
				book.publisher = safeGet(bookJSON, Constants.KEY_PUBLISHER);
				book.publicationDate = safeGet(bookJSON, Constants.KEY_PUBLICATION_DATE);
				book.numberOfPages = safeGet(bookJSON, Constants.KEY_NUMBER_OF_PAGES);
				book.binding = safeGet(bookJSON, Constants.KEY_BINDING);
				book.store = safeGet(bookJSON, Constants.KEY_STORE);
				book.price = safeGet(bookJSON, Constants.KEY_PRICE);
				book.currency = safeGet(bookJSON, Constants.KEY_CURRENCY);
				book.smallImgUrl = safeGet(bookJSON, Constants.KEY_SMALLIMG_URL);
				book.smallImgHeight = safeGet(bookJSON, Constants.KEY_SMALLIMG_HEIGHT);
				book.smallImgWidth = safeGet(bookJSON, Constants.KEY_SMALLIMG_WIDTH);
				book.largeImgUrl = safeGet(bookJSON, Constants.KEY_LARGEIMG_URL);
				book.largeImgHeight = safeGet(bookJSON, Constants.KEY_LARGEIMG_HEIGHT);
				book.largeImgWidth = safeGet(bookJSON, Constants.KEY_LARGEIMG_WIDTH);
				book.isbn = safeGet(bookJSON, Constants.KEY_ISBN);
				books.add(book);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return books.toArray(new Book[0]);
	}

	/**
	 * Request JSON from a given URL.
	 * 
	 * @param url
	 *            String
	 * @return result as {@link String}
	 */
	private static String getJSON(String url) {
		StringBuffer res = new StringBuffer();

		try {
			// Perform action on click
			URLConnection conn = new URL(url).openConnection();
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn
					.getInputStream()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				res.append(line);
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return res.toString();
	}
	
	/**
	 * Get a key from an object, but return an empty String if it's not found. 
	 * 
	 * @param obj {@link JSONObject} to query
	 * @param key key to look for
	 * @return String with result
	 */
	private static String safeGet(JSONObject obj, String key) {
		if (obj.has(key))  {
			try {
				return obj.getString(key);
			} catch (JSONException e) {
				Log.e(TAG, e.getMessage());
				return "";
			}
		} else {
			return "";
		}
	}
}
