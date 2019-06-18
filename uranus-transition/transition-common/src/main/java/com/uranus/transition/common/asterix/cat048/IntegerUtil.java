package com.uranus.transition.common.asterix.cat048;

import com.google.common.primitives.Ints;

/**
 * IntegerUtil
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/23
 */
public final class IntegerUtil {

  public static Integer valueOf(Byte b1) {
    return Ints.fromBytes(ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, b1);
  }

  public static Integer valueOf(Byte b1, Byte b2) {
    return Ints.fromBytes(ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, b1, b2);
  }

  public static Integer valueOf(Byte b1, Byte b2, Byte b3) {
    return Ints.fromBytes(ByteUtil.BYTE_ZERO, b1, b2, b3);
  }

  public static Integer valueOf(Byte b1, Byte b2, Byte b3, Byte b4) {
    return Ints.fromBytes(b1, b2, b3, b4);
  }
}
