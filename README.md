Android-ClipLayout
================
![](https://raw.githubusercontent.com/guojunyi/Android-XListView/master/screenshot/1.gif)
![](https://raw.githubusercontent.com/guojunyi/Android-XListView/master/screenshot/2.gif)
![](https://raw.githubusercontent.com/guojunyi/Android-XListView/master/screenshot/3.gif)
![](https://raw.githubusercontent.com/guojunyi/Android-XListView/master/screenshot/4.gif)
## Sample Application
<a href="https://raw.githubusercontent.com/guojunyi/Android-ClipLayout/master/apk/ClipLayout.apk" target="_blank" title="Download From Google Play">Click to Download the simple apk</a>

## Usage
``` xml
<com.cliplayout.widget.ClipLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="@+id/layout_clip"
    android:background="#5c6bc0"
    >

</com.cliplayout.widget.ClipLayout>
```


``` java
public class TestPage extends ClipPage{

	@Override
	public View onCreateView(Context context, LayoutInflater inflater,
			ClipLayout container) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.xxxx, null);
		return view;
	}

	@Override
	public void onClipPagePushStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClipPagePushEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClipPagePopStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClipPagePopEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClipPageOnStackTop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClipPageLeaveStackTop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClipPageAttached() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClipPageDetached() {
		// TODO Auto-generated method stub
		
	}

}
```

``` java
TestPage page = new TestPage();
page.setCx(Screen.center.x);
page.setCy(Screen.center.y);
page.setDuration(300);
layout_clip.pushClipPage(clipPage);
```

## License

    Copyright 2015 guojunyi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
