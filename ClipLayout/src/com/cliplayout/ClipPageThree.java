package com.cliplayout;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.cliplayout.widget.CircleButton;
import com.cliplayout.widget.ClipLayout;
import com.cliplayout.widget.ClipPage;
import com.nineoldandroids.animation.ObjectAnimator;

public class ClipPageThree extends ClipPage implements OnClickListener{
	static final String TAG = "ClipPageThree";
	CircleButton button;
	ImageView image_back;
	Handler mHandler = new Handler();
	
	@Override
	public View onCreateView(Context context,LayoutInflater inflater, ClipLayout container) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.layout_page3, null);
		initComponent(view);
		return view;
	}

	public void initComponent(View view){
		button = (CircleButton) view.findViewById(R.id.button);
		image_back = (ImageView) view.findViewById(R.id.image_back);
		image_back.setOnClickListener(this);
		button.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button:
			ObjectAnimator.ofFloat(button, "scaleY", 0.0f, 1.3f, 1.0f).setDuration(300).start();
			ObjectAnimator.ofFloat(button, "scaleX", 0.0f, 1.3f, 1.0f).setDuration(300).start();
			ObjectAnimator.ofFloat(button, "rotation", 0, 180, 0).setDuration(300).start();
			break;
		case R.id.image_back:
			this.getClipLayout().popClipPage();
			break;
		}
	}
	
	
	@Override
	public void onClipPagePushStart() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPagePushStart");
		
	}

	@Override
	public void onClipPagePushEnd() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPagePushEnd");
	}

	@Override
	public void onClipPagePopStart() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPagePopStart");
	}

	@Override
	public void onClipPagePopEnd() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPagePopEnd");
	}

	@Override
	public void onClipPageOnStackTop() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPageOnStackTop");
		mHandler.postDelayed(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				button.setVisibility(View.VISIBLE);
				ObjectAnimator.ofFloat(button, "scaleY", 0.0f, 1.3f, 1.0f).setDuration(300).start();
				ObjectAnimator.ofFloat(button, "scaleX", 0.0f, 1.3f, 1.0f).setDuration(300).start();
				
				ObjectAnimator.ofFloat(button, "rotation", 0, 180, 0).setDuration(300).start();
			}
			
		}, 200);
		
	}

	@Override
	public void onClipPageLeaveStackTop() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPageLeaveStackTop");
	}

	@Override
	public void onClipPageAttached() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPageAttached");
	}

	@Override
	public void onClipPageDetached() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPageDetached");
	}
}
