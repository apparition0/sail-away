package com.wheatley.pswsailingdays2;

import android.util.Log;

public class MyDay {
	protected int yday = -1;
	protected String icon = null;
	protected int wind = -1;
	protected int worstweatherenum = -1;
	
	public MyDay()
	{
		Log.d("philip","new MyDay");
	}
	public Boolean isValid()
	{
		Boolean r = true;
		if(yday				== -1 ) r = false;
		if(wind			    == -1 ) r = false;
		//if(worstweatherenum	== -1 ) r = false;
		if(icon == null 		  ) r = false;
		Log.d("philip","MyDay is " + r);
		return r;
	}
	@Override 
	public String toString()
	{
		StringBuilder sb = new StringBuilder("");
		sb.append("yday=" + yday + "\n");
		sb.append("maxwind=" + yday + "\n");
		sb.append("minwind=" + yday + "\n");
		sb.append("worstweatherenum=" + yday + "\n");
		sb.append("icon=" + yday + "\n");
		return sb.toString();
	}
	public int getYday() {
		return yday;
	}
	public void setYday(int yday) {
		this.yday = yday;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getWind() {
		return wind;
	}
	public void setWind(int minwind) {
		this.wind = wind;
	}
	public int getWorstweatherenum() {
		return worstweatherenum;
	}
	public void setWorstweatherenum(int worstweatherenum) {
		this.worstweatherenum = worstweatherenum;
	}		
}
