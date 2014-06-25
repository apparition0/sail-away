package com.wheatley.pswsailingdays2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import android.os.AsyncTask;
import android.util.Log;

public class WeatherFetchOperation extends AsyncTask<String, Void, String> {
	@Override
	protected String doInBackground(String... arg0) {
		String result = null;

		if (true) {
			result = MyFile.readFromFile("2014-06-22-json");
			MyWeather.setJsonResult(result);  // minus: adds control logic, plus: async thread and where else
			MyController.parseResults();      // probably should be an observer pattern
			return result;
		} else {
			DefaultHttpClient httpclient = new DefaultHttpClient(
					new BasicHttpParams());
			HttpPost httppost = new HttpPost(
					"http://api.wunderground.com/api/f2e53d68fe83590a/forecast10day/q/TX/Dallas.json");
			// Depends on your web service
			httppost.setHeader("Content-type", "application/json");

			InputStream inputStream = null;

			try {
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();

				inputStream = entity.getContent();
				// json is UTF-8 by default
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream, "UTF-8"), 8);
				StringBuilder sb = new StringBuilder();

				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				result = sb.toString();
			} catch (Exception e) {
				Log.e("philip", e.toString());
			} finally {
				try {
					if (inputStream != null)
						inputStream.close();
				} catch (Exception squish) {
				}
			}
			MyFile.writeToFile("2014-06-22-json", result); // TODO belongs
															// elsewhere
			MyWeather.setJsonResult(result);
			MyController.parseResults(); // plus, this is done in a separet
											// "thread"
											// minus, done by Weather Fetch
											// instance
											// Observer might have been better
		}
		return result;
	}
}
