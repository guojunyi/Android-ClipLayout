package com.cliplayout.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class ClipPage{
	private ClipLayout clipLayout;
	private int startRadius = 0;
	private int radius = 0;
	private int cx = 0;
	private int cy = 0;
	private int duration = 300;
	private View view;
	private boolean isOnStackTop;
	private boolean isAttached;
	public abstract View onCreateView(Context context,LayoutInflater inflater, ClipLayout container);
	
	public abstract void onClipPagePushStart();
	public abstract void onClipPagePushEnd();
	public abstract void onClipPagePopStart();
	public abstract void onClipPagePopEnd();
	public abstract void onClipPageOnStackTop();
	public abstract void onClipPageLeaveStackTop();
	public abstract void onClipPageAttached();
	public abstract void onClipPageDetached();
	
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

	public void setView(View view) {
		this.view = view;
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
