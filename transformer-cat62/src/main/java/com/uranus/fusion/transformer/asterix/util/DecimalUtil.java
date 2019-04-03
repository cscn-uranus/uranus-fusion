package com.uranus.fusion.transformer.asterix.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * DecimalUtil
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class DecimalUtil {

  public static final int DECIMAL_LEN_0 = 0;
  public static final int DECIMAL_LEN_2 = 2;
  public static final int DECIMAL_LEN_4 = 4;
  public static final int DECIMAL_LEN_8 = 8;
  public static final int DECIMAL_LEN_16 = 16;
  public static final int DECIMAL_LEN_32 = 32;

  public static Double divide(double left, double right) {
    BigDecimal leftValue = BigDecimal.valueOf(left);
    BigDecimal rightValue = BigDecimal.valueOf(right);
    return leftValue.divide(rightValue, DECIMAL_LEN_32, RoundingMode.HALF_UP).doubleValue();
  }

  public static Double multiply(double left, double right) {
    BigDecimal leftValue = BigDecimal.valueOf(left);
    BigDecimal rightValue = BigDecimal.valueOf(right);
    return leftValue.multiply(rightValue).setScale(DECIMAL_LEN_4, RoundingMode.HALF_UP)
        .doubleValue();
  }

  public static Double calculateByResolution(Byte b1, double resolution) {
    return multiply(IntegerUtil.valueOf(b1), resolution);
  }

  public static Double calculateByResolution(Byte b1, Byte b2, double resolution) {
    return multiply(IntegerUtil.valueOf(b1, b2), resolution);
  }

  public static Double calculateByResolution(Byte b1, Byte b2, Byte b3, double resolution) {
    return multiply(IntegerUtil.valueOf(b1, b2, b3), resolution);
  }

  public static Double calculateByResolution(Byte b1, Byte b2, Byte b3, Byte b4,
      double resolution) {
    return multiply(IntegerUtil.valueOf(b1, b2, b3, b4), resolution);
  }
}
