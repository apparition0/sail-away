package com.wheatley.pswsailingdays2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d("philip","onBind");
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		Log.d("philip","onStartCommand");	
		int r = super.onStartCommand(intent, flags, startId);
		MyServiceWorker msw = new MyServiceWorker();
		msw.execute();
		return r;
		
		//return START_NOT_STICKY;
	}
	
}
