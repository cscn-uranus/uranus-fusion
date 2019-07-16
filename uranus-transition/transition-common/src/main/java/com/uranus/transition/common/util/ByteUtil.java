package com.uranus.transition.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * ByteUtil
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public final class ByteUtil {

  public static final Byte ZERO_BYTE = (byte) 0b00000000;
  public static final Byte MAX_BYTE = (byte) 0b11111111;
  public static final String ZERO_BIT = "0";
  public static final String ONE_BIT = "1";
  public static final Integer BITS_OF_BYTE = 8;

  public static String toString(Byte octet) {
    return String.valueOf((octet >> 7) & 0x1)
        + ((octet >> 6) & 0x1)
        + ((octet >> 5) & 0x1)
        + ((octet >> 4) & 0x1)
        + ((octet >> 3) & 0x1)
        + ((octet >> 2) & 0x1)
        + ((octet >> 1) & 0x1)
        + ((octet) & 0x1);
  }

  public static String toString(List<Byte> octets) {
    StringBuilder bitStringBuilder = new StringBuilder();
    for (Byte byteItem : octets) {
      bitStringBuilder.append(toString(byteItem));
    }
    return bitStringBuilder.toString();
  }

  public static Byte unsignedValueOf(String bitString) {
    return Integer.valueOf(bitString, 2).byteValue();
  }

  public static Byte signedValueOf(String bitString) {
    if (bitString.startsWith(ZERO_BIT)) {
      return unsignedValueOf(bitString);
    }
    int complementBitsCount = BITS_OF_BYTE - bitString.length();
    StringBuilder complementBitsBuilder = new StringBuilder();
    for (int i = 0; i < complementBitsCount; i++) {
      complementBitsBuilder.append("1");
    }
    return Integer.valueOf(complementBitsBuilder.toString() + bitString, 2).byteValue();
  }

  public static String getBitByIndex(Byte octet, int index) {
    return toString(octet).substring(index, index + 1);
  }

  public static List<Byte> asList(byte[] octets) {
    List<Byte> byteList = new ArrayList<>();
    for (byte octet: octets) {
      byteList.add(octet);
    }
    return byteList;
  }
}
