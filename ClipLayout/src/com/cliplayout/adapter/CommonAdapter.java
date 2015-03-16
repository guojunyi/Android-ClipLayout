package com.cliplayout.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter{
	protected LayoutInflater mInflater;  
    protected Context mContext;  
    protected List<T> mDatas;  
    protected final int mItemLayoutId;
    protected int viewTypeCount;
    protected ItemViewTypeCallback itemViewTypeCallback;
    protected ItemViewTypeCountCallback itemViewTypeCountCallback;
    
    public interface ItemViewTypeCallback{
		public int getViewType(int position);
	}
    
	public interface ItemViewTypeCountCallback{
		public int getViewTypeCount();
	}
	
    public CommonAdapter(Context context, List<T> mDatas,int itemLayoutId)  
    {  
        mInflater = LayoutInflater.from(context);  
        this.mContext = context;  
        this.mDatas = mDatas;  
        this.mItemLayoutId = itemLayoutId;
    } 
    
    @Override  
    public int getCount()  
    {  
        return mDatas.size();  
    }  
  
    @Override  
    public T getItem(int position)  
    {  
        return mDatas.get(position);  
    }  
  
    @Override  
    public long getItemId(int position)  
    {  
        return position;  
    }  
    
    @Override  
    public View getView(int position, View convertView, ViewGroup parent)  
    {  
        final ViewHolder viewHolder = getViewHolder(position, convertView,  
                parent);  
        convert(viewHolder, getItem(position),position);  
        return viewHolder.getConvertView();  
    }
    
    private ViewHolder getViewHolder(int position, View convertView,  
            ViewGroup parent)  
    {  
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,  
                position);  
    }  
    
    public abstract void convert(ViewHolder holder, T item,int position);  
    
    public void updateData(List<T> datas){
    	this.mDatas = datas;
    	//this.notifyDataSetChanged();
    	this.notifyDataSetInvalidated();
    }

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if(null!=itemViewTypeCallback){
			return itemViewTypeCallback.getViewType(position);
		}else{
			return super.getItemViewType(position);
		}
		
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		if(null!=itemViewTypeCallback){
			return itemViewTypeCountCallback.getViewTypeCount();
		}else{
			return super.getViewTypeCount();
		}
		
	}

	public void setItemViewTypeCallback(ItemViewTypeCallback itemViewTypeCallback) {
		this.itemViewTypeCallback = itemViewTypeCallback;
	}

	public void setItemViewTypeCountCallback(
			ItemViewTypeCountCallback itemViewTypeCountCallback) {
		this.itemViewTypeCountCallback = itemViewTypeCountCallback;
	}
	
	
	
	
}
