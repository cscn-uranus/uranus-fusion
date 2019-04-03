package com.uranus.fusion.transformer.asterix.util;

import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedInts;

/**
 * StringUtil
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/25
 */
public class StringUtil {

  public static String asciiValueOf(byte... byteArray) {
    StringBuilder asciiBuilder = new StringBuilder();
    for (byte byteItem : byteArray) {
      asciiBuilder.append((char) (int) byteItem);
    }
    return asciiBuilder.toString();
  }


  public static String valueOf(int... intArray) {
    StringBuilder intBuilder = new StringBuilder();
    for (int intItem: intArray) {
      intBuilder.append(intItem);
    }
    return intBuilder.toString();
  }

}
