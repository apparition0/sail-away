package com.wheatley.pswsailingdays2;

import java.util.GregorianCalendar;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import android.os.AsyncTask;
import android.util.Log;
 

public class MyWeather {
	protected int _dayofyear;
	protected static String JsonResult;  // not abstracted, wunderground format
	// TODO cleanup with DI to be a moc 
	private static final String filePath = "C:\\Users\\katerina\\Desktop\\jsonTestFile.json";
	
	public MyWeather()
	{
		_dayofyear = GregorianCalendar.DAY_OF_YEAR;
	}
	public static void stopFetching()
	{
		
	}
	public static void FetchWeather()
	{	
		new	WeatherFetchOperation().execute("");
	}
	public static String getJsonResult() {
		return JsonResult;
	}
	public static void setJsonResult(String jsonResult) {
		JsonResult = jsonResult;
	}

}

