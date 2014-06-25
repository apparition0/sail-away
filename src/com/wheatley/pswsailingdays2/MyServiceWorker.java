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
		Log.d("Philip", "doInBackground");
		_mt = new MyTimer();
		Timer timer = new Timer(true);
		// Date dt = new Date();
		// Calendar _cnow = Calendar.getInstance();
		// Calendar _cthen = Calendar.getInstance();
		// _cthen.clear(Calendar.HOUR);
		// _cthen.clear(Calendar.MINUTE);
		// _cthen.clear(Calendar.SECOND);
		// _cthen.set(Calendar.HOUR, MyView.getHour());
		// _cthen.set(Calendar.MINUTE, MyView.getMinute());

		timer.scheduleAtFixedRate(_mt, 10000, 1000 * 60 * 60 );
		return null;
	}
}
