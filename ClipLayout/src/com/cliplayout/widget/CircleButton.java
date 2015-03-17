package com.cliplayout.widget;

import com.cliplayout.R;
import com.cliplayout.R.styleable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleButton extends ImageView{
	Paint mPaint;
	int color;
	public CircleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.CircleButton);  
		int n = a.getIndexCount();  
        for (int i = 0; i < n; i++)  
        {  
            int attr = a.getIndex(i);  
            switch (attr)  
            {  
            case R.styleable.CircleButton_color:
            	color = a.getColor(R.styleable.CircleButton_color, 0xff000000);
            	break;
            }  
        }  
        a.recycle(); 
        
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
	}

	
	@Override
	public void onDraw(Canvas canvas){
		
		mPaint.setStyle(Style.FILL);
		mPaint.setColor(color);
		
		int radius = getWidth()<getHeight()?getWidth()/2:getHeight()/2;
		canvas.drawCircle(getWidth()/2, getHeight()/2, radius, mPaint);
		
		super.onDraw(canvas);
	}
	
	public void setColor(int color){
		this.color = color;
		this.invalidate();
	}
	
	public Point getPosition(){
		Point p = new Point();
		p.x = this.getLeft()+this.getMeasuredWidth()/2;
		p.y = this.getTop()+this.getMeasuredHeight()/2;
		return p;
	}
	
}
