package com.github.stchris.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Utility methods.
 * 
 * @author chris
 *
 */
public abstract class Util {

	/**
	 * Buffer size for copy operation.
	 */
	private static final int IO_BUFFER_SIZE = 4 * 1024;
	
	/**
	 * Tag used for logging.
	 */
	private static final String TAG = "Util.loadBitmap";

	/**
	 * Download an image from the given URL and store it in memory as a Bitmap.
	 * 
	 * @param url URL String
	 * @return {@link Bitmap} the image
	 */
	public static Bitmap loadBitmap(String url) {
		if (url == null) {
			return null;
		}
		Bitmap bitmap = null;
		InputStream in = null;
		BufferedOutputStream out = null;

		try {
			in = new BufferedInputStream(new URL(url).openStream(),
					IO_BUFFER_SIZE);

			final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
			out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);
			copy(in, out);
			out.flush();

			final byte[] data = dataStream.toByteArray();
			BitmapFactory.Options options = new BitmapFactory.Options();

			bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,
					options);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				Log.e(TAG, e.getMessage());
			}
			
		}

		return bitmap;
	}

	/**
	 * Copy the contents of the {@link InputStream} to the given {@link OutputStream}.
	 * 
	 * @param in {@link InputStream}
	 * @param out {@link OutputStream}
	 * @throws IOException copy fail
	 */
	private static void copy(InputStream in, OutputStream out)
			throws IOException {
		byte[] b = new byte[IO_BUFFER_SIZE];
		int read;
		while ((read = in.read(b)) != -1) {
			out.write(b, 0, read);
		}
	}

}
