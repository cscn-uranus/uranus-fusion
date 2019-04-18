package com.uranus.fusion.util;

/**
 * ByteUtil
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public final class ByteUtil {

  public static final Byte ZERO_BYTE = 0b00000000;
  public static final String ZERO_BIT = "0";

  public static String toString(Byte singleByte) {
    return String.valueOf((singleByte >> 7) & 0x1)
        + ((singleByte >> 6) & 0x1)
        + ((singleByte >> 5) & 0x1)
        + ((singleByte >> 4) & 0x1)
        + ((singleByte >> 3) & 0x1)
        + ((singleByte >> 2) & 0x1)
        + ((singleByte >> 1) & 0x1)
        + ((singleByte) & 0x1);
  }

  public static Byte valueOf(String byteString) {
    return (byte) Integer.parseInt(byteString, 2);
  }

  public static String getBitByIndex(Byte singleByte, int index) {
    return toString(singleByte).substring(index, index + 1);
  }

  public static String getB0(Byte singleByte) {
    return toString(singleByte).substring(0, 1);
  }

  public static String getB1(Byte singleByte) {
    return toString(singleByte).substring(1, 2);
  }

  public static String getB2(Byte singleByte) {
    return toString(singleByte).substring(2, 3);
  }

  public static String getB3(Byte singleByte) {
    return toString(singleByte).substring(3, 4);
  }

  public static String getB4(Byte singleByte) {
    return toString(singleByte).substring(4, 5);
  }

  public static String getB5(Byte singleByte) {
    return toString(singleByte).substring(5, 6);
  }

  public static String getB6(Byte singleByte) {
    return toString(singleByte).substring(6, 7);
  }

  public static String getB7(Byte singleByte) {
    return toString(singleByte).substring(7, 8);
  }
}
