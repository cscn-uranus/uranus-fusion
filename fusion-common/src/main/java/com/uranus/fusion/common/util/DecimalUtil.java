package com.uranus.fusion.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * DecimalUtil
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class DecimalUtil {

  public static final int DECIMAL_LEN_0 = 0;
  public static final int DECIMAL_LEN_2 = 2;
  public static final int DECIMAL_LEN_4 = 4;
  public static final int DECIMAL_LEN_8 = 8;
  public static final int DECIMAL_LEN_16 = 16;
  public static final int DECIMAL_LEN_32 = 32;

  public static Double divide(double a, double b) {
    BigDecimal leftValue = BigDecimal.valueOf(a);
    BigDecimal rightValue = BigDecimal.valueOf(b);
    return leftValue.divide(rightValue, DECIMAL_LEN_32, RoundingMode.HALF_UP).doubleValue();
  }

  public static Double multiply(double a, double b) {
    BigDecimal leftValue = BigDecimal.valueOf(a);
    BigDecimal rightValue = BigDecimal.valueOf(b);
    return leftValue
        .multiply(rightValue)
        .setScale(DECIMAL_LEN_4, RoundingMode.HALF_UP)
        .doubleValue();
  }
}
