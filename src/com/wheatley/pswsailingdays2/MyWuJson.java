package com.wheatley.pswsailingdays2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

//  JSON parser for WUnderground format

public class MyWuJson {
	static List<MyDay> lod = null;
	//static MyDay WorkingDay = null; // this is the day currently being "built"

	public static List<MyDay> parse(String s) {
		try {
			lod = null; // reset, eliminating yesterdays data
			lod = new ArrayList<MyDay>();
			JSONObject jo = new JSONObject(s);
			directparse(jo); // maybe should obviously set lod by return value
		} catch (Exception ex) {
			Log.e("philip", ex.toString());
		}
		return lod;
	}

	protected static void directparse(JSONObject jo) {
		String name, value;
		try {
			JSONObject jo1 = jo.getJSONObject("forecast");
			JSONObject jo2 = jo1.getJSONObject("simpleforecast");
			Object o = jo2.get("forecastday");
			JSONArray ja = (JSONArray) o;

			for (int k = 0; k < ja.length(); k++) {
				JSONObject jo4 = ja.getJSONObject(k);
				Log.d("philip1", jo4.toString());// .substring(0, 25));
				MyDay md = new MyDay();

				value = jo4.get("icon").toString();
				Log.d("icon", value);
				md.setIcon(value);

				value = jo4.get("maxwind").toString();
				Log.d("maxwind", value);
				value = jo4.getJSONObject("maxwind").get("mph").toString();
				Log.d("maxwind", value);
				md.setMaxwind(Integer.parseInt(value));

				value = jo4.get("avewind").toString();
				Log.d("avewind", value);
				value = jo4.getJSONObject("avewind").get("mph").toString();
				Log.d("avewind", value);
				md.setAvewind(Integer.parseInt(value));

				value = jo4.get("high").toString();
				Log.d("high", value);
				value = jo4.getJSONObject("high").get("fahrenheit").toString();
				Log.d("high", value);
				md.setHi(Integer.parseInt(value));

				value = jo4.get("low").toString();
				Log.d("low", value);
				value = jo4.getJSONObject("low").get("fahrenheit").toString();
				Log.d("low", value);
				md.setLo(Integer.parseInt(value));

				value = jo4.get("date").toString();
				Log.d("date", value);
				value = jo4.getJSONObject("date").get("yday").toString();
				Log.d("date", value);
				md.setYday(Integer.parseInt(value));

				lod.add(md);
				Log.d("myday", md.toString());
			}

		} catch (Exception e) {
			Log.e("philip", e.toString());
		}
	}


	public static List<MyDay> getListOfDays() {
		return lod;
	}

	public static void setListOfDays(List<MyDay> lod) {
		MyWuJson.lod = lod;
	}
}
