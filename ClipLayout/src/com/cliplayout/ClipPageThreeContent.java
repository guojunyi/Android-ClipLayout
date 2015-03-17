package com.cliplayout;

import java.util.Arrays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.cliplayout.adapter.CommonAdapter;
import com.cliplayout.adapter.ViewHolder;
import com.cliplayout.widget.ClipPage;

public class ClipPageThreeContent extends ClipPage {
	OnDetachedListener mOnDetachedListener;
	Context mContext;
	ListView listView;
	CommonAdapter mAdapter;
	static String[] adapterData = new String[] { "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z" };

	public ClipPageThreeContent(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public View onCreateView(Context context) {
		// TODO Auto-generated method stub
		mContext = context;
		View view = LayoutInflater.from(context).inflate(
				R.layout.layout_page3_content, null);
		initComponent(view);
		return view;
	}

	public void initComponent(View view) {
		listView = (ListView) view.findViewById(R.id.listView);

		mAdapter = new CommonAdapter<String>(mContext,
				Arrays.asList(adapterData), R.layout.list_item_clip_page1) {

			@Override
			public void convert(ViewHolder holder, String item, int position) {
				// TODO Auto-generated method stub
				TextView textView = holder.getView(R.id.text_name);
				textView.setTextColor(0xffffffff);
				textView.setText(item);
			}

		};
		listView.setAdapter(mAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "item:" + position, 1000).show();
				;
			}

		});
	}

	@Override
	public void onClipPageDetached() {
		// TODO Auto-generated method stub
		super.onClipPageDetached();
		if (null != mOnDetachedListener) {
			mOnDetachedListener.onDetached();
		}

	}

	public void setOnDetachedListener(OnDetachedListener onDetachedListener) {
		this.mOnDetachedListener = onDetachedListener;
	}

	public interface OnDetachedListener {
		public void onDetached();
	}
}
