package com.wheatley.pswsailingdays2;

import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;

public class MyTimer extends TimerTask {

	@Override
	public void run() {
		Boolean r = false;
		Log.d("philip", "timertask.run()");
		MyWeather mw = new MyWeather();
		mw.FetchWeather(); // will spawn off another thread
	}

}
