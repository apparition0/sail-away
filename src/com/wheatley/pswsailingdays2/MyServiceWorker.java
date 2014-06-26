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
		timer.scheduleAtFixedRate(_mt, 10000/*ten seconds*/, /*10 minutes*/ 1000 * 60 * 10 );
		return null;
	}
}
