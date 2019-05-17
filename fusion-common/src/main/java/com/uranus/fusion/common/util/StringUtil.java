package com.uranus.fusion.common.util;

/**
 * StringUtil
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/25
 */
public class StringUtil {

  private static final Integer SIX_BITS_ASCII_BREAKPOINT = 32;
  private static final Integer SIX_BITS_ASCII_OFFSET = 64;

  public static String standardAsciiValueOf(String bitString, int radix) {
    StringBuilder asciiBuilder = new StringBuilder();
    int[] intArray = toIntArray(bitString, radix);

    for (int intItem : intArray) {
      asciiBuilder.append((char) intItem);
    }
    return asciiBuilder.toString();
  }

  public static String sixBitsAsciiValueOf(String bitString, int radix) {
    StringBuilder asciiBuilder = new StringBuilder();
    int[] intArray = toIntArray(bitString, radix);
    for (int intItem : intArray) {
      if (intItem < SIX_BITS_ASCII_BREAKPOINT) {
        intItem += SIX_BITS_ASCII_OFFSET;
      }
      asciiBuilder.append((char) intItem);
    }
    return asciiBuilder.toString();
  }

  public static int[] toIntArray(String bitString, int radix) {
    int length = (int) Math.ceil(bitString.length() / radix);
    int[] intArray = new int[length];

    for (int i = 0; i < length; i++) {
      int beginIndex = i * radix;
      int endIndex = i * radix + radix;
      endIndex = endIndex < bitString.length() ? i * radix + radix : bitString.length();

      byte byteItem = ByteUtil.unsignedValueOf(bitString.substring(beginIndex, endIndex));
      intArray[i] = IntegerUtil.unsignedValueOf(byteItem);
    }
    return intArray;
  }

  public static String valueOf(int... intArray) {
    StringBuilder intBuilder = new StringBuilder();
    for (int intItem : intArray) {
      intBuilder.append(intItem);
    }
    return intBuilder.toString();
  }

  public static String valueOf(String bitString, int radix) {
    return valueOf(toIntArray(bitString, radix));
  }
}
