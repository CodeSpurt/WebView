package com.codespurt.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by CodeSpurt on 11-08-2017.
 */

public class MyWebViewClient extends WebViewClient {

    private Context context;
    private String MATCHING_URL = "www.google.co.in";

    public MyWebViewClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().contains(MATCHING_URL)) {
            // open in same webView
            return false;
        }
        // open in device's default app
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
        return true;
    }
}
