package com.cliplayout.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewHolder {
	private final SparseArray<View> mViews;
	private View mConvertView;
	private int mPosition;
	
	private ViewHolder(Context context, ViewGroup parent, int layoutId,  
            int position){
		this.mPosition = position;
		this.mViews = new SparseArray<View>();  
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,  
                false);  
        mConvertView.setTag(this);  
	}
	
	public static ViewHolder get(Context context, View convertView,  
            ViewGroup parent, int layoutId, int position)  
    {  
      
        if (convertView == null)  
        {  
            return new ViewHolder(context, parent, layoutId, position);  
        }  
        return (ViewHolder) convertView.getTag();  
    }  
	
	public <T extends View> T getView(int viewId)  
    {  
          
        View view = mViews.get(viewId);  
        if (view == null)  
        {  
            view = mConvertView.findViewById(viewId);  
            mViews.put(viewId, view);  
        }  
        return (T) view;  
    }  
	
	public View getConvertView()  
    {  
        return mConvertView;  
    } 
	
	 
    public ViewHolder setImageResource(int viewId, int drawableId)  
    {  
        ImageView view = getView(viewId);  
        view.setImageResource(drawableId);  
  
        return this;  
    }  
  
     
    public ViewHolder setImageBitmap(int viewId, Bitmap bm)  
    {  
        ImageView view = getView(viewId);  
        view.setImageBitmap(bm);  
        return this;  
    }  
  
    
//    public ViewHolder setImageByUrl(int viewId, String url)  
//    {  
//        ImageLoader.getInstance(3, Type.LIFO).loadImage(url,  
//                (ImageView) getView(viewId));  
//        return this;  
//    }  
  
    public int getPosition()  
    {  
        return mPosition;  
    }  
}
