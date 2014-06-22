package com.wheatley.pswsailingdays2;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;


public  class MyController {
	public MyController()
	{
		
	}
	public static void save()
	{
		Context c = MyView.getContext();
		SharedPreferences sp = c.getSharedPreferences("SailingDays2", MyView.getActivity().MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		spe.putInt("id", 			MyView.getId());
		spe.putInt("hour", 			MyView.getHour());
		spe.putInt("minute", 		MyView.getMinute());
		spe.putInt("WindMax", 		MyView.getWindMax());
		spe.putInt("WindMin", 		MyView.getWindMin());
		spe.putInt("WorstWeather", 	MyView.getWorstWeather());
		spe.apply();
	}
	public static void start() 
	{
		
	}
	public static void stop() 
	{
		
	}
	public static void reload() 
	{
		Context c = MyView.getContext();
		SharedPreferences sp = c.getSharedPreferences("SailingDays2", MyView.getActivity().MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		MyView.setId(sp.getInt("id", 						MyView.getId()));
		MyView.setHour(sp.getInt("hour", 					MyView.getHour()));
		MyView.setMinute(sp.getInt("minute", 				MyView.getMinute()));
		MyView.setWindMax(sp.getInt("WindMax", 				MyView.getWindMax()));
		MyView.setWindMin(sp.getInt("WindMin", 				MyView.getWindMin()));
		MyView.setWorstWeather(sp.getInt("WorstWeather", 	MyView.getWorstWeather()));
	}
}
