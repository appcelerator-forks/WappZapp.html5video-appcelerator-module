/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package tv.wappzapp.html5video;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;
import html5video.wappzapp.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import android.app.Activity;

@Kroll.proxy(creatableInModule=Html5videoModule.class)
public class WebVideoProxy extends TiViewProxy {
	// Standard Debugging variables
	private static final String TAG = "HTML5AndroidVideo";
	
    //private VideoEnabledWebView webView;
    private VideoEnabledWebChromeClient webChromeClient;
	private String url;
	private TiUIView view;
	
	private class WebVideoView extends TiUIView
	{
		public WebVideoView(TiViewProxy proxy) {
			super(proxy);

	        Html5videoModule.webView = new VideoEnabledWebView(proxy.getActivity());

	        webChromeClient = new VideoEnabledWebChromeClient(Html5videoModule.webView) // See all available constructors...

	        {
	            // Subscribe to standard events, such as onProgressChanged()...
	            /*@Override
	            public void onProgressChanged(WebView view, int progress)
	            {
	                // Your code...
	            }*/
	        };
	        webChromeClient.setOnToggledFullscreen(new VideoEnabledWebChromeClient.ToggledFullscreenCallback()
	        {
	            @Override
	            public void toggledFullscreen(boolean fullscreen)
	            {
	                // Your code to handle the full-screen change, for example showing and hiding the title bar. Example:
	                if (fullscreen)
	                {
	                	// sent fullscreen event
	                }
	                else
	                {
	                	// sent not full screen event
	                }

	            }
	        });
	        Html5videoModule.webView.setWebChromeClient(webChromeClient);

        	// Navigate everywhere you want, this classes have only been tested on YouTube's mobile site
			setNativeView(Html5videoModule.webView);
		}

		@Override
		public void processProperties(KrollDict d)
		{
			super.processProperties(d);
		}
	}

	// Constructor
	public WebVideoProxy()
	{
		super();
	}

	@Kroll.method
    public void clearWebView()
    {
    	Html5videoModule.webView.onPause();
		Log.d(TAG, "[PROXY LIFECYCLE EVENT] clearWebView called");
    }

	@Override
	public TiUIView createView(Activity activity)
	{
		view = new WebVideoView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);
		if (options.containsKey("url")) {
			url = (String) options.get("url");
			Html5videoModule.webView.loadUrl(url);
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setUrl(String _url) {
		url = _url;
		Html5videoModule.webView.loadUrl(url);
	}
}