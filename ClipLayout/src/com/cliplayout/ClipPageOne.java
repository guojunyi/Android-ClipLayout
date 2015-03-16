package com.cliplayout;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cliplayout.adapter.CommonAdapter;
import com.cliplayout.adapter.ViewHolder;
import com.cliplayout.widget.CircleButton;
import com.cliplayout.widget.ClipLayout;
import com.cliplayout.widget.ClipPage;
import com.nineoldandroids.animation.ObjectAnimator;

public class ClipPageOne extends ClipPage implements OnClickListener{
	static final String TAG = "ClipPageOne";
	CircleButton button;
	ImageView image_back;
	ListView listView;
	CommonAdapter mAdapter;
	Context mContext;
	Handler mHandler = new Handler();
	
	static String[] adapterData = new String[] { "A", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
		"S", "T", "U", "V", "W", "X", "Y", "Z" };
	@Override
	public View onCreateView(Context context,LayoutInflater inflater, ClipLayout container) {
		// TODO Auto-generated method stub
		mContext = context;
		View view = inflater.inflate(R.layout.layout_page1, null);
		initComponent(view);
		return view;
	}

	public void initComponent(View view){
		button = (CircleButton) view.findViewById(R.id.button);
		image_back = (ImageView) view.findViewById(R.id.image_back);
		listView = (ListView) view.findViewById(R.id.listView);
		
		mAdapter = new CommonAdapter<String>(mContext, Arrays.asList(adapterData),
				R.layout.list_item_clip_page1) {

			@Override
			public void convert(ViewHolder holder, String item, int position) {
				// TODO Auto-generated method stub
				((TextView)holder.getView(R.id.text_name)).setText(item);
			}

		};
		listView.setAdapter(mAdapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "item:"+position, 1000).show();;
			}
			
		});
		
		
		image_back.setOnClickListener(this);
		button.setOnClickListener(this);
		
	}
	
	public void showButton(){
		if(button.getVisibility()==View.GONE){
			button.setVisibility(View.VISIBLE);
			ObjectAnimator.ofFloat(button, "scaleY", 0.0f, 1.3f, 1.0f).setDuration(300).start();
			ObjectAnimator.ofFloat(button, "scaleX", 0.0f, 1.3f, 1.0f).setDuration(300).start();
		}
	}
	
	public void hiddeButton(){
		if(button.getVisibility()==View.VISIBLE){
			ObjectAnimator.ofFloat(button, "scaleY", 1.0f, 0.0f).setDuration(300).start();
			ObjectAnimator.ofFloat(button, "scaleX", 1.0f, 0.0f).setDuration(300).start();
			button.setVisibility(View.GONE);
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button:
			ClipPageTwo clipPage = new ClipPageTwo();
			clipPage.setCx(button.getLeft()+button.getWidth()/2);
			clipPage.setCy(button.getTop()+button.getHeight()/2);
			this.getClipLayout().pushClipPage(clipPage);
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
				showButton();
			}
			
		}, 200);
	}

	@Override
	public void onClipPageLeaveStackTop() {
		// TODO Auto-generated method stub
		Log.e(TAG,"onClipPageLeaveStackTop");
		hiddeButton();
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
