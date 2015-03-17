package com.cliplayout;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.cliplayout.ClipPageThreeContent.OnDetachedListener;
import com.cliplayout.widget.CircleButton;
import com.cliplayout.widget.ClipLayout;
import com.cliplayout.widget.ClipPage;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ObjectAnimator;

public class ClipPageThree extends ClipPage implements OnClickListener{
	

	static final String TAG = "ClipPageThree";
	CircleButton button;
	ImageView image_back;
	Handler mHandler = new Handler();
	ClipLayout layout_clip;
	Context mContext;
	
	public ClipPageThree(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(Context context) {
		// TODO Auto-generated method stub
		mContext = context;
		View view = LayoutInflater.from(context).inflate(R.layout.layout_page3, null);
		initComponent(view);
		return view;
	}

	public void initComponent(View view){
		button = (CircleButton) view.findViewById(R.id.button);
		image_back = (ImageView) view.findViewById(R.id.image_back);
		layout_clip = (ClipLayout) view.findViewById(R.id.layout_clip);
		
		image_back.setOnClickListener(this);
		button.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button:
			
			
			final int movX = getClipLayout().getWidth()/2 - button.getPosition().x;
			final int movY = layout_clip.getTop()+layout_clip.getHeight()/2 - button.getPosition().y;
			
			ObjectAnimator.ofFloat(button, "translationX", 0,movX).setDuration(300).start();
			ObjectAnimator.ofFloat(button, "translationY", 0,movY).setDuration(300).start();
			ObjectAnimator.ofFloat(button, "scaleY", 1.0f,0.0f).setDuration(300).start();
			ObjectAnimator animator = ObjectAnimator.ofFloat(button, "scaleX", 1.0f,0.0f);
			
			animator.addListener(new AnimatorListener(){

				@Override
				public void onAnimationCancel(Animator arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onAnimationEnd(Animator arg0) {
					// TODO Auto-generated method stub
					ClipPageThreeContent clipPage = new ClipPageThreeContent(mContext);
					clipPage.setOnDetachedListener(new OnDetachedListener(){

						@Override
						public void onDetached() {
							// TODO Auto-generated method stub
							ObjectAnimator.ofFloat(button, "translationX", movX,0).setDuration(0).start();
							ObjectAnimator.ofFloat(button, "translationY", movY,0).setDuration(0).start();
							ObjectAnimator.ofFloat(button, "scaleY", 0.0f, 1.3f, 1.0f).setDuration(300).start();
							ObjectAnimator.ofFloat(button, "scaleX", 0.0f, 1.3f, 1.0f).setDuration(300).start();
							button.setClickable(true);
						}
						
					});
					clipPage.setCx(layout_clip.getWidth()/2);
					clipPage.setCy(layout_clip.getHeight()/2);
					layout_clip.pushClipPage(clipPage);
					button.setClickable(false);
				}

				@Override
				public void onAnimationRepeat(Animator arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onAnimationStart(Animator arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			animator.setDuration(300).start();
			
			break;
		case R.id.image_back:
			
			if(layout_clip.getPageStack().size()>0){
				layout_clip.popClipPage();
			}else{
				this.getClipLayout().popClipPage();
			}
			
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
