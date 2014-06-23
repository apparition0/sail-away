package com.wheatley.pswsailingdays2;

import java.io.*;

import android.content.Context;
import android.util.Log;

public class MyFile {
	public static Boolean writeToFile(String filename, String message) {
		Boolean r = false;
		try {
			FileOutputStream fos = MyView.getContext().openFileOutput(filename,
					Context.MODE_PRIVATE);
			byte[] bite /* ha ha */= message.getBytes();
			fos.write(bite);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			Log.e("philip", e.toString());
			r = false;
		}
		return r;
	}

	public static String readFromFile(String filename) {
		StringBuilder sb = new StringBuilder();
		FileInputStream fis = null;
		String message = null;
		try {
			fis = MyView.getContext().openFileInput(filename);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			message = sb.toString();
		} catch (IOException e) {
			Log.e("philip", e.toString());
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception ex) {
			}
		}
		return message;
	}
}
