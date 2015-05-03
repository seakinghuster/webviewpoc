package com.example.webviewpoc;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class WebviewPoCActivity extends Activity {
  
  @Override
  public void onCreate(Bundle savedInstanceState) {

    try {
      // Some intro.
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      // Display in web view
      WebView webView = (WebView) findViewById(R.id.webview);
      webView.setWebViewClient(new DxWebViewClient());
      webView.setVerticalScrollBarEnabled(true);
      String html = Utilities.inputStreamToString(getAssets().open("html/test.html"));
      String css = Utilities.getRawResourceAsString(R.raw.testcss, webView.getContext());
      html = Core.reformatHtml(html, css);
      webView.loadDataWithBaseURL("file:///", html, "text/html", "utf-8", null);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
