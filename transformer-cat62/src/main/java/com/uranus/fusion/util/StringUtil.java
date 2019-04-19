package com.uranus.fusion.util;

/**
 * StringUtil
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/25
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
    for (int intItem : intArray) {
      intBuilder.append(intItem);
    }
    return intBuilder.toString();
  }

  public static String valueOf(String bitString, int radix) {
    int length = (int) Math.ceil(bitString.length() / radix);
    int[] intArray = new int[length];

    for (int i = 0; i < length; i++) {
      int beginIndex = i * radix;
      int endIndex = i * radix + radix;
      endIndex = endIndex < bitString.length() ? i * radix + radix : bitString.length() - 1;

      byte byteItem = ByteUtil.valueOf(bitString.substring(beginIndex, endIndex));
      intArray[i] = IntegerUtil.valueOf(byteItem);
    }
    return StringUtil.valueOf(intArray);
  }
}
