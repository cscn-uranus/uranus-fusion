package com.uranus.fusion.common.util;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

/**
 * IntegerUtil
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/23
 */
public final class IntegerUtil {

  public static Integer unsignedValueOf(Byte b1) {
    return Ints.fromBytes(ByteUtil.ZERO_BYTE, ByteUtil.ZERO_BYTE, ByteUtil.ZERO_BYTE, b1);
  }

  public static Integer unsignedValueOf(Byte b1, Byte b2) {

    return Ints.fromBytes(ByteUtil.ZERO_BYTE, ByteUtil.ZERO_BYTE, b1, b2);
  }

  public static Integer unsignedValueOf(Byte b1, Byte b2, Byte b3) {
    return Ints.fromBytes(ByteUtil.ZERO_BYTE, b1, b2, b3);
  }

  public static Long unsignedValueOf(Byte b1, Byte b2, Byte b3, Byte b4) {
    return Longs.fromBytes(
        ByteUtil.ZERO_BYTE,
        ByteUtil.ZERO_BYTE,
        ByteUtil.ZERO_BYTE,
        ByteUtil.ZERO_BYTE,
        b1,
        b2,
        b3,
        b4);
  }

  public static Integer signedValueOf(Byte b1) {
    if (ByteUtil.toString(b1).startsWith(ByteUtil.ZERO_BIT)) {
      return unsignedValueOf(b1);
    }
    return Ints.fromBytes(ByteUtil.MAX_BYTE, ByteUtil.MAX_BYTE, ByteUtil.MAX_BYTE, b1);
  }

  public static Integer signedValueOf(Byte b1, Byte b2) {
    if (ByteUtil.toString(b1).startsWith(ByteUtil.ZERO_BIT)) {
      return unsignedValueOf(b1, b2);
    }
    return Ints.fromBytes(ByteUtil.MAX_BYTE, ByteUtil.MAX_BYTE, b1, b2);
  }

  public static Integer signedValueOf(Byte b1, Byte b2, Byte b3) {
    if (ByteUtil.toString(b1).startsWith(ByteUtil.ZERO_BIT)) {
      return unsignedValueOf(b1, b2, b3);
    }
    return Ints.fromBytes(ByteUtil.MAX_BYTE, b1, b2, b3);
  }

  public static Integer signedValueOf(Byte b1, Byte b2, Byte b3, Byte b4) {
    return Ints.fromBytes(b1, b2, b3, b4);
  }
}
