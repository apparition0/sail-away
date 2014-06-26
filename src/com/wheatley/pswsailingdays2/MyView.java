package com.wheatley.pswsailingdays2;

//import com.wheatley.pswutil5.MyButtonFour;
//import com.wheatley.pswutil5.MyButtonOne;
//import com.wheatley.pswutil5.MyButtonThree;
//import com.wheatley.pswutil5.MyButtonTwo;
//import com.wheatley.pswutil5.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.Notification;

public class MyView {
	protected static Activity _a;
	protected static Context _c;
	protected static Handler _mainthread;

	protected static int _id;
	protected static int _hour;
	protected static int _minute;
	protected static int _WorstWeather;
	protected static int _WindMin;
	protected static int _WindMax;
	protected static Button b1;
	protected static Button b2;
	protected static Button b3;
	protected static Button b4;
	private final static int myid = 10101010;

	// need to add temperature, as if below freezing probably is not acceptable

	public MyView(Activity a) {
		_a = a;
		_mainthread = new Handler();
		init();
	}

	public static void HanderPost(Runnable _r) {
		_mainthread.post(_r);
	}

	public class NotifyMessage extends Activity {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			TextView txt = new TextView(this);

			txt.setText("Activity after click on notification");
			setContentView(txt);
		}
	}

	protected static void NotificationDetails() {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(_a)
				.setContentTitle("Sailing")
				.setSmallIcon(
						com.wheatley.pswsailingdays2.R.drawable.ic_launcher)
				.setContentText("go Sailing Tomorrow");
		// Creates an explicit intent for an Activity in your app
		Intent resultIntent = new Intent(_a, FullscreenActivity.class);

		// The stack builder object will contain an artificial back stack for
		// the
		// started Activity.
		// This ensures that navigating backward from the Activity leads out of
		// your application to the Home screen.
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(_a);
		// Adds the back stack for the Intent (but not the Intent itself)
		stackBuilder.addParentStack(FullscreenActivity.class);
		// Adds the Intent that starts the Activity to the top of the stack
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) _a
				.getSystemService(Context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(myid, builder.build());
	}

	public static void Notification() {
		_mainthread.post(new Runnable() {
			@Override
			public void run() {
				NotificationDetails();
			}
		});
	}

	public static void CancelNotification() {
		_mainthread.post(new Runnable() {
			@Override
			public void run() {
				String s = Context.NOTIFICATION_SERVICE;
			    NotificationManager nMgr = (NotificationManager) _c.getSystemService(s);
			    nMgr.cancel(myid);
			}
		});
	}

	protected void init() {
		try {
			// worst weather
			NumberPicker np1 = (NumberPicker) _a
					.findViewById(R.id.numberPicker1);
			np1.setMaxValue(2);
			np1.setMinValue(0);
			np1.setDisplayedValues(new String[] { "Clear or Cloudy",
					"Chance of Thunderstorms", "Thunderstorms" });
			// min wind
			NumberPicker np2 = (NumberPicker) _a
					.findViewById(R.id.numberPicker2);
			np2.setMaxValue(20);
			np2.setMinValue(0);
			// max wind
			NumberPicker np3 = (NumberPicker) _a
					.findViewById(R.id.numberPicker3);
			np3.setMaxValue(35);
			np3.setMinValue(0);

			b1 = (Button) _a.findViewById(R.id.button1);
			b1.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) { // start
					MyController.start();
				}
			});
			b2 = (Button) _a.findViewById(R.id.button2);
			b2.setEnabled(false);
			b2.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) { // stop
					MyController.stop();
				}
			});
			b3 = (Button) _a.findViewById(R.id.button3);
			b3.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) { // save
					MyController.save();
				}
			});
			b4 = (Button) _a.findViewById(R.id.button4);
			b4.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) { // reload
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
		// this.id = id;
		_id = id;
	}

	public static int getHour() {
		TimePicker p1 = (TimePicker) _a.findViewById(R.id.timePicker1);
		_hour = p1.getCurrentHour();
		return _hour;
	}

	public static void setHour(int hour) {
		// this.hour = hour;
		TimePicker p1 = (TimePicker) _a.findViewById(R.id.timePicker1);
		p1.setCurrentHour(hour);
	}

	public static int getMinute() {
		TimePicker p1 = (TimePicker) _a.findViewById(R.id.timePicker1);
		_minute = p1.getCurrentMinute();
		return _minute;
	}

	public static void setMinute(int minute) {
		// this.minute = minute;
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

	public static void setContext(Context c) {
		_c = c;
	}

	public static Context getContext() {
		return _c;
	}

	public static Activity getActivity() {
		return _a;
	}

	public static Button getStartButton() {
		return b1;
	}

	public static void setStartButton(Button b1) {
		MyView.b1 = b1;
	}

	public static Button getStopButton() {
		return b2;
	}

	public static void setStopButton(Button b2) {
		MyView.b2 = b2;
	}

	public static Button getSaveButton() {
		return b3;
	}

	public static void setSaveButton(Button b3) {
		MyView.b3 = b3;
	}

	public static Button getReloadButton() {
		return b4;
	}

	public static void setReloadButton(Button b4) {
		MyView.b4 = b4;
	}
}
