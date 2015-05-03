package com.example.webviewpoc;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Utilities {
  public static String inputStreamToString(InputStream inputStream) throws IOException, MalformedURLException {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
    Scanner scanner = new Scanner(bufferedInputStream, "utf-8").useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }

  public static String getRawResourceAsString(int resourceID, Context context) {
    Resources resources = context.getResources();
    InputStream inputStream = resources.openRawResource(resourceID);
    Scanner scanner = new Scanner(inputStream, "utf-8").useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }
}
