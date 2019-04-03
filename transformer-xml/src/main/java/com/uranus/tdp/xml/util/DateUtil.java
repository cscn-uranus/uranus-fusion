/*
 * Copyright (c) 2017. Cscn and/or its affiliates. All rights reserved.
 * Cscn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.uranus.tdp.xml.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 日期转换工具
 *
 * <p>将字符串转换为日期对象
 *
 * <p>将日期对象转换为字符串
 */
public class DateUtil {

  public static LocalDateTime String2Date(String dateString, DateTypeEnum dateTypeEnum) {
    if (dateString == null) {
      return null;
    } else {
      DateTimeFormatter dateFormat = generateDateFormatter(dateTypeEnum);
      return LocalDateTime.parse(dateString, dateFormat);
    }
  }

  public static String Date2String(LocalDateTime date, DateTypeEnum type) {
    String dateString;
    DateTimeFormatter dateFormat = generateDateFormatter(type);
    dateString = date.format(dateFormat);
    return dateString;
  }
  public static LocalDateTime now() {
    return LocalDateTime.now();
  }

  public static long nano() {
    return System.nanoTime();
  }

  public static boolean isValidDateTimeString(String dateTimeString) {
    if (dateTimeString == null) {
      return false;
    } else {
      return dateTimeString.matches(
          "(?<year>[0-9]){4}"
              + "(?<month>[0-1][0-9])"
              + "(?<day>[0-3][0-9])"
              + "(?<hour>[0-2][0-9])"
              + "(?<minute>[0-6][0-9])"
              + "(?<second>[0-6][0-9])?");
    }
  }

  private static DateTimeFormatter generateDateFormatter(DateTypeEnum type) {
    return DateTimeFormatter.ofPattern(type.getFormatString(), Locale.CHINA);
  }
}
