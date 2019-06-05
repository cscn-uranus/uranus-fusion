package com.uranus.transition.common.util;

import java.io.*;

/**
 * FileUtil
 *
 * @author tellxp@github.com
 * @date 2018/11/26
 */
public class FileUtil {

  private static String inputStreamToString(InputStream is) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();
    return sb.toString();
  }

  public static String readStringFromFile(String filePath) {
    File file = new File(filePath);
    try {
      return inputStreamToString(new FileInputStream(file));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
