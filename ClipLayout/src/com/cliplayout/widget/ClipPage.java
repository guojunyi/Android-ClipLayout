package com.cliplayout.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class ClipPage{
	
	private ClipLayout clipLayout;
	
	/** The push animation begins radius */
	private int startRadius = 0;
	
	/** The push or pop animation doing radius */
	private int radius = 0;
	
	/** The animation center of a circle x */
	private int cx = 0;
	
	/** The animation center of a circle y */
	private int cy = 0;
	
	/** The push and pop animation duration */
	private int duration = 300;
	
	/** With the current page bound view */
	private final View view;
	
	/** Whether or not the page view is on cliplayout(@link ClipLayout.mViewStack) top */
	private boolean isOnStackTop;
	
	/** Whether or not the page view was added to cliplayout */
	private boolean isAttached;
	
	
	public ClipPage(Context context){
		view = onCreateView(context);
	}
	
	/** Subclasses must implement this method to create view */
	public abstract View onCreateView(Context context);
	
	/** when push animator start */
	public void onClipPagePushStart(){
		
	}
	
	/** when push animator end */
	public void onClipPagePushEnd(){
		
	};
	
	/** when pop animator start */
	public void onClipPagePopStart(){
		
	};
	
	/** when pop animator end */
	public void onClipPagePopEnd(){
		
	};
	
	/** when clip page into the stack top */
	public void onClipPageOnStackTop(){
		
	};
	
	/** when clip page leave stack top */
	public void onClipPageLeaveStackTop(){
		
	};
	
	/** when clip page added into clipLayout */
	public void onClipPageAttached(){
		
	};
	
	/** when clip page removed from clipLayout */
	public void onClipPageDetached(){
		
	};
	
	
	public ClipLayout getClipLayout() {
		return this.clipLayout;
	}

	public void setClipLayout(ClipLayout clipLayout) {
		this.clipLayout = clipLayout;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public View getView() {
		return view;
	}

	public int getStartRadius() {
		return startRadius;
	}

	public void setStartRadius(int startRadius) {
		this.startRadius = startRadius;
	}

	public boolean isOnStackTop() {
		return isOnStackTop;
	}

	public void setOnStackTop(boolean isOnStackTop) {
		this.isOnStackTop = isOnStackTop;
	}
	
	public boolean isAttached() {
		return isAttached;
	}
	
	public void setAttached(boolean isAttached) {
		this.isAttached = isAttached;
	}
	
	
}
