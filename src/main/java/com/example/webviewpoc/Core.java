package com.example.webviewpoc;

import android.content.Context;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

public class Core {

  public static String reformatHtml(String html, String css) {
    String cleanHtml = cleanHtml(html);
    String reformattedHtml = injectCss(html, css);
    return reformattedHtml;
  }

  private static String cleanHtml(String html) {
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
    return Jsoup.clean(html, whitelist);
  }

  private static String injectCss(String html, String css) {
    Document document = Jsoup.parse(html);
    Element head = document.getElementsByTag("head").first();
    if (head != null) {
      Element styleElement = head.appendElement("style");
      styleElement.attr("type", "text/css");
      styleElement.appendText(css);
    }
    return document.outerHtml();
  }
}
