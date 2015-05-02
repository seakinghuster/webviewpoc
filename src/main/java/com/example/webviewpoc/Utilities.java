package com.example.webviewpoc;

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
}
