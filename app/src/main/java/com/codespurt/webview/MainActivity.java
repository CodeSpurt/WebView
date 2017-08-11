package com.codespurt.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.codespurt.webview.engine.WebAppInterface;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String URL = "https://www.google.co.in/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);

        // enable javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // add interface
        webView.addJavascriptInterface(new WebAppInterface(this), "android");

        // add custom client
        webView.setWebViewClient(new MyWebViewClient(this));

        // load webPage in webView
        webView.loadUrl(URL);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // handle back navigation
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



















