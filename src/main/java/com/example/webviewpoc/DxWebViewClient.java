package com.example.webviewpoc;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DxWebViewClient extends WebViewClient {
  
  @Override
  public boolean shouldOverrideUrlLoading(WebView webView, String urlString) {
    try {
      URL url = new URL(urlString);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      String html = Utilities.inputStreamToString(connection.getInputStream());
      connection.disconnect();
      webView.loadDataWithBaseURL("file:///", html, "text/html", "utf-8", null);
    } catch (IOException e) {
      Toast.makeText(webView.getContext(), e.toString(), Toast.LENGTH_LONG).show();
    }
    return true;
  }
}
