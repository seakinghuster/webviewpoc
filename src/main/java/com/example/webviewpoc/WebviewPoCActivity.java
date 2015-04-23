package com.example.webviewpoc;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import java.io.InputStream;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class WebviewPoCActivity extends Activity {
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    
    // Some intro.
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    // Read HTML file from resources
    Resources resources = getResources();
    InputStream inputStream = resources.openRawResource(R.raw.test);
    Scanner scanner = new Scanner(inputStream, "utf-8").useDelimiter("\\A");
    String html = scanner.hasNext() ? scanner.next() : "";
    
    // Clean the HTML
    Whitelist whitelist = Whitelist
    .relaxed()
    .addTags(
      "header",
      "nav",
      "section",
      "article",
      "aside",
      "footer",
      "form",
      "input",
      "fieldset",
      "title",
      "time",
      "noscript"
    );
    html = Jsoup.clean(html, whitelist);
    
    // Display in web view
    WebView webView = (WebView) findViewById(R.id.webview);
    webView.setVerticalScrollBarEnabled(true);
    webView.loadData(html, "text/html", "utf-8");
  }
}
