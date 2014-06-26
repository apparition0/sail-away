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
	static List<MyDay> lod = new ArrayList<MyDay>();
	//static MyDay WorkingDay = null; // this is the day currently being "built"

	public static List<MyDay> parse(String s) {
		try {
			JSONObject jo = new JSONObject(s);
			directparse(jo); // maybe should obviously set lod by return value
		} catch (Exception ex) {
			Log.e("philip", ex.toString());
		}
		return lod;
	}

	public static void directparse(JSONObject jo) {
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

//	public static void fillin(JSONObject o, String s) {
//		try {
//
//			if (WorkingDay != null) {
//				if (s.equalsIgnoreCase("icon"))
//					WorkingDay.setIcon(o.getString(s));
//				if (s.equalsIgnoreCase("maxwind"))
//					WorkingDay.setMaxwind(o.getInt(s));
//				if (s.equalsIgnoreCase("avewind"))
//					WorkingDay.setAvewind(o.getInt(s));
//				if (s.equalsIgnoreCase("hi"))
//					WorkingDay.setHi(o.getInt(s));
//				if (s.equalsIgnoreCase("lo"))
//					WorkingDay.setLo(o.getInt(s));
//				if (s.equalsIgnoreCase("yday"))
//					WorkingDay.setYday(o.getInt(s));
//			}
//		} catch (Exception ex) {
//			Log.e("philip", ex.toString());
//		}
//	}
//
//	public static void recurse(JSONObject jo, String tabs) {
//		Iterator i = jo.keys();
//		while (i.hasNext()) {
//			try {
//				String s = i.next().toString();
//				Log.i("philip:recurse()", tabs + s + " (val) "
//						+ jo.get(s).toString());
//
//				if (s.equals("yday")) {
//					WorkingDay = new MyDay();
//					int yday = Integer.parseInt(jo.get(s).toString());
//					WorkingDay.setYday(yday);
//					recurse(jo, tabs + ".. ");
//					if (WorkingDay.isValid())
//						lod.add(WorkingDay);
//					else
//						WorkingDay = null;
//
//				}
//
//				if (jo.get(s) instanceof Integer)
//					Log.i("philip", tabs + "(int) " + jo.getInt(s));
//				if (jo.get(s) instanceof String)
//					Log.i("philip", tabs + "(str) " + jo.getString(s));
//				if (jo.get(s) instanceof Long)
//					Log.i("philip", tabs + "(lon) " + jo.getLong(s));
//				if (jo.get(s) instanceof JSONArray) {
//					Log.i("philip", "---------------- Begin Array");
//					Log.i("philip", tabs + "(ARR) "
//							+ jo.getString(s).substring(0, 20));
//					JSONArray ja = jo.getJSONArray(s);
//					for (int k = 0; k < ja.length(); k++) {
//						Log.i("philip", "----------- Array element " + k);
//						recurse(ja.getJSONObject(k), tabs + "(arr) ");
//					}
//					Log.i("philip", "----------------- End Array");
//				}
//
//				if (jo.get(s) instanceof JSONObject) {
//					JSONObject o = (JSONObject) jo.get(s);
//					recurse(o, tabs + ".. ");
//					fillin(o, s);
//				}
//
//				Log.i("philip", "------ return from recurse call");
//
//			} catch (Exception ex) {
//				Log.e("philip", ex.toString());
//			}
//		}
//	}
//
//	public static void recurse1(JSONObject jo, String tabs) {
//		Iterator i = jo.keys();
//		while (i.hasNext()) {
//			String s = i.next().toString();
//			Log.i("philip", tabs + s);
//			try {
//				if (jo.get(s) instanceof JSONObject) {
//					JSONObject o = (JSONObject) jo.get(s);
//					recurse(o, tabs + ".. ");
//					fillin(o, s);
//				} else {
//					if (jo.get(s) instanceof Integer)
//						Log.i("philip", tabs + "## " + jo.getInt(s));
//					if (jo.get(s) instanceof String)
//						Log.i("philip", tabs + "** " + jo.getString(s));
//					if (jo.get(s) instanceof JSONArray) {
//						Log.i("philip", "---------------- Begin Array");
//						Log.i("philip", tabs + ":: "
//								+ jo.getString(s).substring(0, 20));
//						JSONArray ja = jo.getJSONArray(s);
//						for (int k = 0; k < ja.length(); k++) {
//							Log.i("philip", "----------- Array element " + k);
//							WorkingDay = new MyDay();
//							recurse(ja.getJSONObject(k), tabs + ":: ");
//							if (WorkingDay.isValid())
//								lod.add(WorkingDay);
//							else
//								WorkingDay = null;
//						}
//						Log.i("philip", "----------------- End Array");
//					} else
//						Log.i("philip", tabs + ",, unknown "
//								+ jo.get(s).toString());
//					Log.i("philip", "------ return from recurse call");
//				}
//			} catch (Exception ex) {
//				Log.e("philip", ex.toString());
//			}
//		}
//	}

	public static List<MyDay> getListOfDays() {
		return lod;
	}

	public static void setListOfDays(List<MyDay> lod) {
		MyWuJson.lod = lod;
	}
}
