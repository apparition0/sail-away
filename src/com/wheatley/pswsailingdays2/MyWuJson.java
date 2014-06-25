package com.wheatley.pswsailingdays2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

//  JSON parser for WUnderground format

public class MyWuJson {
	static List<MyDay> lod = new ArrayList<MyDay>();
	static MyDay WorkingDay = null; // this is the day currently being "built"

	public static List<MyDay> parse(String s) {
		try {
			if (true) {
				lod.add(new MyDay(177,30,10,100,70, "chancetstorms"));
				lod.add(new MyDay(172,30,10,100,70, "chancetstorms"));
				lod.add(new MyDay(173,30,10,100,70, "chancetstorms"));
				lod.add(new MyDay(174,30,10,100,70, "chancetstorms"));
				lod.add(new MyDay(175,30,10,100,70, "chancetstorms"));
				lod.add(new MyDay(176,30,10,100,70, "chancetstorms"));
			} else {
				JSONObject jo = new JSONObject(s);
				recurse(jo, ".. ");
			}
		} catch (Exception ex) {
			Log.e("philip", ex.toString());
		}
		Log.v("philip", "exiting json");
		return lod;
	}

	public static void fillin(JSONObject o, String s) {
		try {

			if (WorkingDay != null) {
				if (s.equalsIgnoreCase("icon"))
					WorkingDay.setIcon(o.getString(s));
				if (s.equalsIgnoreCase("maxwind"))
					WorkingDay.setMaxwind(o.getInt(s));
				if (s.equalsIgnoreCase("avewind"))
					WorkingDay.setAvewind(o.getInt(s));
				if (s.equalsIgnoreCase("hi"))
					WorkingDay.setHi(o.getInt(s));
				if (s.equalsIgnoreCase("lo"))
					WorkingDay.setLo(o.getInt(s));
				if (s.equalsIgnoreCase("yday"))
					WorkingDay.setYday(o.getInt(s));
			}
		} catch (Exception ex) {
			Log.e("philip", ex.toString());
		}
	}

	public static void recurse(JSONObject jo, String tabs) {
		Iterator i = jo.keys();
		while (i.hasNext()) {
			try {
				String s = i.next().toString();
				Log.i("philip:recurse()", tabs + s + " (val) "
						+ jo.get(s).toString());

				if (s.equals("yday")) {
					WorkingDay = new MyDay();
					int yday = Integer.parseInt(jo.get(s).toString());
					WorkingDay.setYday(yday);
					recurse(jo, tabs + ".. ");
					if (WorkingDay.isValid())
						lod.add(WorkingDay);
					else
						WorkingDay = null;

				}

				if (jo.get(s) instanceof Integer)
					Log.i("philip", tabs + "(int) " + jo.getInt(s));
				if (jo.get(s) instanceof String)
					Log.i("philip", tabs + "(str) " + jo.getString(s));
				if (jo.get(s) instanceof Long)
					Log.i("philip", tabs + "(lon) " + jo.getLong(s));
				if (jo.get(s) instanceof JSONArray) {
					Log.i("philip", "---------------- Begin Array");
					Log.i("philip", tabs + "(ARR) "
							+ jo.getString(s).substring(0, 20));
					JSONArray ja = jo.getJSONArray(s);
					for (int k = 0; k < ja.length(); k++) {
						Log.i("philip", "----------- Array element " + k);
						recurse(ja.getJSONObject(k), tabs + "(arr) ");
					}
					Log.i("philip", "----------------- End Array");
				}

				if (jo.get(s) instanceof JSONObject) {
					JSONObject o = (JSONObject) jo.get(s);
					recurse(o, tabs + ".. ");
					fillin(o, s);
				}

				Log.i("philip", "------ return from recurse call");

			} catch (Exception ex) {
				Log.e("philip", ex.toString());
			}
		}
	}

	public static void recurse1(JSONObject jo, String tabs) {
		Iterator i = jo.keys();
		while (i.hasNext()) {
			String s = i.next().toString();
			Log.i("philip", tabs + s);
			try {
				if (jo.get(s) instanceof JSONObject) {
					JSONObject o = (JSONObject) jo.get(s);
					recurse(o, tabs + ".. ");
					fillin(o, s);
				} else {
					if (jo.get(s) instanceof Integer)
						Log.i("philip", tabs + "## " + jo.getInt(s));
					if (jo.get(s) instanceof String)
						Log.i("philip", tabs + "** " + jo.getString(s));
					if (jo.get(s) instanceof JSONArray) {
						Log.i("philip", "---------------- Begin Array");
						Log.i("philip", tabs + ":: "
								+ jo.getString(s).substring(0, 20));
						JSONArray ja = jo.getJSONArray(s);
						for (int k = 0; k < ja.length(); k++) {
							Log.i("philip", "----------- Array element " + k);
							WorkingDay = new MyDay();
							recurse(ja.getJSONObject(k), tabs + ":: ");
							if (WorkingDay.isValid())
								lod.add(WorkingDay);
							else
								WorkingDay = null;
						}
						Log.i("philip", "----------------- End Array");
					} else
						Log.i("philip", tabs + ",, unknown "
								+ jo.get(s).toString());
					Log.i("philip", "------ return from recurse call");
				}
			} catch (Exception ex) {
				Log.e("philip", ex.toString());
			}
		}
	}

	public static List<MyDay> getListOfDays() {
		return lod;
	}

	public static void setListOfDays(List<MyDay> lod) {
		MyWuJson.lod = lod;
	}
}
