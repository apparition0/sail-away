//copyright: Philip Wheatley 2014

package com.wheatley.pswsailingdays2;

import android.util.Log;

public class MyDay {
	protected int yday = -1;
	protected String icon = null;
	protected int maxwind = -1;
	protected int avewind = -1;
	protected int lo = -1;
	protected int hi = -1;
	protected int worstweatherenum = -1;
	
	public MyDay()
	{
		Log.d("philip","new MyDay");
	}
	public MyDay(int _yday, int _maxwind,int _avewind,int _hi, int _lo, String _icon)
	{
		yday = _yday;
		maxwind= _maxwind;
		avewind = _avewind;
		hi = _hi;
		lo = _lo;
		icon = _icon;
		Log.d("philip","new MyDay " + this.toString());
	}
	public Boolean isValid()
	{
		Boolean r = true;
		if(yday						== -1 ) r = false;
		if(maxwind			   		== -1 ) r = false;
		if(avewind			   		== -1 ) r = false;
		if(hi			  	 		== -1 ) r = false;
		if(lo				   		== -1 ) r = false;
		//if(worstweatherenum		== -1 ) r = false;
		if(icon == null 		  ) r = false;
		Log.d("philip","MyDay is " + r);
		return r;
	}
	@Override 
	public String toString()
	{
		StringBuilder sb = new StringBuilder("---");
		sb.append("_yday=" + yday + "\n");
		sb.append("_maxwind=" + maxwind + "\n");
		sb.append("_avewind=" + avewind + "\n");
		sb.append("_hi=" + hi + "\n");
		sb.append("_lo=" + lo + "\n");
		sb.append("_worstweatherenum=" + worstweatherenum + "\n");
		sb.append("_icon=" + icon + "\n");
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
	public int getWorstweatherenum() {
		return worstweatherenum;
	}
	public void setWorstweatherenum(int worstweatherenum) {
		this.worstweatherenum = worstweatherenum;
	}
	public int getMaxwind() {
		return maxwind;
	}
	public void setMaxwind(int maxwind) {
		this.maxwind = maxwind;
	}
	public int getAvewind() {
		return avewind;
	}
	public void setAvewind(int avewind) {
		this.avewind = avewind;
	}
	public int getLo() {
		return lo;
	}
	public void setLo(int lo) {
		this.lo = lo;
	}
	public int getHi() {
		return hi;
	}
	public void setHi(int hi) {
		this.hi = hi;
	}		
}
