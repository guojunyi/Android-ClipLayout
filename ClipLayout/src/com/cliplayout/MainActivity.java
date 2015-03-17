package com.cliplayout;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.cliplayout.widget.CircleButton;
import com.cliplayout.widget.ClipLayout;

public class MainActivity extends FragmentActivity{

	ClipLayout layout_clip;
	CircleButton button;
	
	
	@Override
	public void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		
		setContentView(R.layout.activity_main);
		
		layout_clip = (ClipLayout) findViewById(R.id.layout_clip);
		button = (CircleButton) findViewById(R.id.button);
		
		findViewById(R.id.button).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ClipPageOne clipPage = new ClipPageOne(MainActivity.this);
				clipPage.setCx(button.getLeft()+button.getWidth()/2);
				clipPage.setCy(button.getTop()+button.getHeight()/2);
				layout_clip.pushClipPage(clipPage);
			}
			
		});
		

	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		
	}
}
