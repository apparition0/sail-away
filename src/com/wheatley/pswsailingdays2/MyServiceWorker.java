package com.wheatley.pswsailingdays2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import android.os.AsyncTask;
import android.util.Log;

public class MyServiceWorker extends AsyncTask {
	MyTimer _mt;

	@Override
	protected Object doInBackground(Object... arg0) {
		Log.d("Philip", "MyServiceWorker.doInBackground()");
		_mt = new MyTimer();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(_mt, 10000/*ten seconds*/, /*24 hours*/ 1000 * 60 * 60 * 24 );
		return null;
	}
}
