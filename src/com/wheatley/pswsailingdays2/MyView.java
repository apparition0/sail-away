package com.wheatley.pswsailingdays2;


//import com.wheatley.pswutil5.MyButtonFour;
//import com.wheatley.pswutil5.MyButtonOne;
//import com.wheatley.pswutil5.MyButtonThree;
//import com.wheatley.pswutil5.MyButtonTwo;
//import com.wheatley.pswutil5.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;

public class MyView {
	protected static Activity _a;
	protected static Context _c;

	protected static int _id;
	protected static int _hour;
	protected static int _minute; 
	protected static int _WorstWeather;
	protected static int _WindMin;
	protected static int _WindMax;
	
	public MyView(Activity a)
	{
		_a = a;

		init();
	}
	public static void setContext(Context c)
	{
		_c = c;
	}
	public static Context getContext()
	{
		return _c;
	}
	public static Activity getActivity()
	{
		return _a;
	}
	protected void init()
	{
		try {
			NumberPicker np1 = (NumberPicker) _a
					.findViewById(R.id.numberPicker1);
			np1.setMaxValue(20);
			np1.setMinValue(0);
			NumberPicker np2 = (NumberPicker) _a
					.findViewById(R.id.numberPicker2);
			np2.setMaxValue(30);
			np2.setMinValue(0);
			NumberPicker np3 = (NumberPicker) _a
					.findViewById(R.id.numberPicker3);
			np3.setMaxValue(2);
			np3.setMinValue(0);
			np3.setDisplayedValues(new String[] { "Clear or Cloudy",
					"Chance of Thunderstorms", "Thunderstorms" });
			Button b1 = (Button) _a.findViewById(R.id.button1);
			b1.setOnClickListener(new Button.OnClickListener() {  
		        public void onClick(View v)
	            { // start
		        	MyController.start();
	            }
	         });
			Button b2 = (Button) _a.findViewById(R.id.button2);
			b2.setOnClickListener(new Button.OnClickListener() {  
		        public void onClick(View v)
	            { // stop
		        	MyController.stop();
	            }
	         });
			Button b3 = (Button) _a.findViewById(R.id.button3);
			b3.setOnClickListener(new Button.OnClickListener() {  
		        public void onClick(View v)
	            { // save
		        	MyController.save();
	            }
	         });
			Button b4 = (Button) _a.findViewById(R.id.button4);
			b4.setOnClickListener(new Button.OnClickListener() {  
		        public void onClick(View v)
	            { // reload
		        	MyController.reload();
	            }
	         });
		} catch (Exception ex) {
			Log.e("philip", "MyView " + ex.toString());
		}

	}
	public static int getId() {
		return _id;
	}
	public static void setId(int id) {
		//this.id = id;
		_id = id;
	}
	public static int getHour() {
		TimePicker p1 = (TimePicker) _a.findViewById(R.id.timePicker1);
		_hour = p1.getCurrentHour();
		return _hour;
	}
	public static void setHour(int hour) {
		//this.hour = hour;
		TimePicker p1 = (TimePicker) _a.findViewById(R.id.timePicker1);
		p1.setCurrentHour(hour);
	}
	public static int getMinute() {
		TimePicker p1 = (TimePicker) _a.findViewById(R.id.timePicker1);
		_minute = p1.getCurrentMinute();
		return _minute;
	}
	public static void setMinute(int minute) {
		//this.minute = minute;
		TimePicker p1 = (TimePicker) _a.findViewById(R.id.timePicker1);
		p1.setCurrentMinute(minute);
		_minute = minute;
	}
	public static int getWorstWeather() {
		NumberPicker n1 = (NumberPicker) _a.findViewById(R.id.numberPicker1);
		_WorstWeather = n1.getValue();
		return _WorstWeather;
	}
	public static void setWorstWeather(int worstWeather) {
		NumberPicker n1 = (NumberPicker) _a.findViewById(R.id.numberPicker1);
		n1.setValue(worstWeather);
		_WorstWeather = worstWeather;
	}
	public static int getWindMin() {
		NumberPicker n2 = (NumberPicker) _a.findViewById(R.id.numberPicker2);
		_WindMin = n2.getValue();
		return _WindMin;
	}
	public static void setWindMin(int windMin) {
		NumberPicker n2 = (NumberPicker) _a.findViewById(R.id.numberPicker2);
		n2.setValue(windMin);
		_WindMin = windMin;
	}
	public static int getWindMax() {
		NumberPicker n3 = (NumberPicker) _a.findViewById(R.id.numberPicker3);
		_WindMax = n3.getValue();
		return _WindMax;
	}
	public static void setWindMax(int windMax) {
		NumberPicker n3 = (NumberPicker) _a.findViewById(R.id.numberPicker3);
		n3.setValue(windMax);
		_WindMax = windMax;
	}
}
