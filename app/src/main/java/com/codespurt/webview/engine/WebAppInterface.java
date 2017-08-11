package com.codespurt.webview.engine;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by CodeSpurt on 11-08-2017.
 */

public class WebAppInterface {

    private Context context;

    public WebAppInterface(Context context) {
        this.context = context;
        showToast("Web page is loading...");
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
