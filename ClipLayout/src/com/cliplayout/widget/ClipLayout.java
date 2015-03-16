package com.cliplayout.widget;

import java.util.Stack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

public class ClipLayout extends RelativeLayout {
	static final String TAG = "ClipLayout";
	Context mContext;

	Stack<ClipPage> mViewStack = new Stack<ClipPage>();
	boolean isAnimating;
	boolean popFlag;
	
	
	public ClipLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		// TODO Auto-generated constructor stub
	}
	
	public void pushClipPage(final ClipPage clipPage){
		if (isAnimating) {
			return;
		}
		
		clipPage.setClipLayout(this);
		View view = clipPage.onCreateView(mContext,LayoutInflater.from(mContext), this);
		view.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return true;
			}
			
		});
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
				this.getMeasuredWidth(), this.getMeasuredHeight());
		view.setLayoutParams(params);
		clipPage.setView(view);
		this.addView(view);
		//clipPage attached
		clipPage.onClipPageAttached();
		clipPage.setAttached(true);
		
		if(mViewStack.size()>0){
			ClipPage lastTopClipPage = mViewStack.peek();
			//clipPage leave stack top
			lastTopClipPage.setOnStackTop(false);
			lastTopClipPage.onClipPageLeaveStackTop();
		}
		
		mViewStack.push(clipPage);
		
		//clipPage on stack top
		clipPage.setOnStackTop(true);
		clipPage.onClipPageOnStackTop();
		
		final int value = Math.max(clipPage.getCx(), getWidth() - clipPage.getCx())
				+ Math.max(clipPage.getCy(), getHeight() - clipPage.getCy());
		
		ValueAnimator animator = ValueAnimator.ofInt(clipPage.getStartRadius(), value);
		animator.setDuration(clipPage.getDuration());
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// TODO Auto-generated method stub

				int frameValue = (Integer) animation.getAnimatedValue();
				if (frameValue == value) {
					isAnimating = false;
					
					//clipPage push end
					clipPage.onClipPagePushEnd();
					
				}
				
				clipPage.setRadius(frameValue);

				invalidateChild(clipPage.getView(), new Rect(0, 0, getWidth(),
						getHeight()));
				invalidate(new Rect(0, 0, getWidth(),
						getHeight()));

			}
		});
		isAnimating = true;
		//clipPage push start
		clipPage.onClipPagePushStart();
		animator.start();
		
	}

	public void popClipPage(){
		if (isAnimating) {
			return;
		}
		if (!mViewStack.isEmpty()) {
			final ClipPage clipPage = mViewStack.peek();
			ValueAnimator animator = ValueAnimator.ofInt(clipPage.getRadius(),
					clipPage.getStartRadius());
			animator.setDuration(clipPage.getDuration());
			animator.addUpdateListener(new AnimatorUpdateListener() {

				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					// TODO Auto-generated method stub

					int frameValue = (Integer) animation.getAnimatedValue();
					clipPage.setRadius(frameValue);
					
					if (frameValue == clipPage.getStartRadius()) {
						isAnimating = false;
						//clipPage pop end
						clipPage.onClipPagePopEnd();
					}
					
					invalidateChild(clipPage.getView(), new Rect(0, 0, getWidth(),
							getHeight()));
					invalidate(new Rect(0, 0, getWidth(),
							getHeight()));
				}
			});
			popFlag = true;
			isAnimating = true;
			//clipPage pop start
			clipPage.onClipPagePopStart();
			
			animator.start();
			
			
		}
	}
	

	@Override
	public boolean drawChild(Canvas canvas, View child, long drawingTime) {
		if(child.getParent()==this){
			boolean isClipPageView = false;
			for(ClipPage page : mViewStack){
				if(child==page.getView()){
					isClipPageView = true;
				}
			}
			if(!isClipPageView){
				return super.drawChild(canvas, child, drawingTime); 
			}
		}
		
		if (mViewStack.isEmpty()) {
			return super.drawChild(canvas, child, drawingTime);
		}

		if(mViewStack.size()==1&&child==mViewStack.get(0).getView()){
			return drawStackView(canvas, child, drawingTime);
		}
		
		if(mViewStack.size()>1&&child==mViewStack.get(mViewStack.size()-1).getView()){
			return drawStackView(canvas, child, drawingTime);
		}
		
		if(mViewStack.size()>1&&child==mViewStack.get(mViewStack.size()-2).getView()){
			return drawStackView(canvas, child, drawingTime);
		}
		
		return false;
		
	}

	public boolean drawStackView(Canvas canvas, View child, long drawingTime){
		ClipPage clipPage = mViewStack.peek();
		if (child != clipPage.getView()) {
			return super.drawChild(canvas, child, drawingTime);
		}

		//final int state = canvas.save();
		Path path = new Path();

		path.addCircle(clipPage.getCx(), clipPage.getCy(), clipPage.getRadius(),
				Path.Direction.CW);

		canvas.clipPath(path);

		boolean isInvalided = super.drawChild(canvas, child, drawingTime);

		//canvas.restoreToCount(state);

		if (popFlag && clipPage.getRadius() == clipPage.getStartRadius()) {
			popFlag = false;
			mViewStack.pop();
			removeView(clipPage.getView());
			//clipPage detached 
			clipPage.setOnStackTop(false);
			clipPage.setAttached(false);
			clipPage.setClipLayout(null);
			clipPage.onClipPageDetached();
			
			if(mViewStack.size()>0){
				ClipPage topClipPage = mViewStack.peek();
				//clipPage on stack top
				topClipPage.setOnStackTop(true);
				topClipPage.onClipPageOnStackTop();
			}
		}
		return isInvalided;
	}
	
	public Stack<ClipPage> getPageStack(){
		return this.mViewStack;
	}
}
