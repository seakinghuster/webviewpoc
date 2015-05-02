package com.example.webviewpoc;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import java.io.InputStream;
import java.util.Scanner;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class WebviewPoCActivity extends Activity {
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    
    // Some intro.
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Read HTML file from resources
    String html = getRawResourceAsString(R.raw.testhtml);
    
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
      "noscript",
      "head"
    );
    html = Jsoup.clean(html, whitelist);
    
    // Inject the styles
    Document document = Jsoup.parse(html);
    Element head = document.getElementsByTag("head").first();
    if (head != null) {
      Element styleElement = head.appendElement("style");
      styleElement.attr("type", "text/css");
      String css = getRawResourceAsString(R.raw.testcss);
      styleElement.appendText(css);
    }
    
    // Display in web view
    WebView webView = (WebView) findViewById(R.id.webview);
    webView.setWebViewClient(new DxWebViewClient());
    webView.setVerticalScrollBarEnabled(true);
    webView.loadDataWithBaseURL("file:///", document.outerHtml(), "text/html", "utf-8", null);
  }

  private String getRawResourceAsString(int resourceID) {
    Resources resources = getResources();
    InputStream inputStream = resources.openRawResource(resourceID);
    Scanner scanner = new Scanner(inputStream, "utf-8").useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }
}
