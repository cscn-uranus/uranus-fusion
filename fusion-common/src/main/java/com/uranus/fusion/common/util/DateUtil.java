package com.uranus.fusion.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * DateUtil
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
public class DateUtil {

  public static LocalDate String2Date(String dateString, DateTypeEnum format) {
    if (dateString == null) {
      return null;
    } else {
      DateTimeFormatter formatter = generateDateFormatter(format);
      return LocalDate.parse(dateString, formatter);
    }
  }

  public static LocalTime String2Time(String timeString, DateTypeEnum format) {
    if (timeString == null) {
      return null;
    } else {
      DateTimeFormatter formatter = generateDateFormatter(format);
      return LocalTime.parse(timeString, formatter);
    }
  }

  public static LocalDateTime String2DateTime(String dateTimeString, DateTypeEnum format) {
    if (!isValidDateTimeString(dateTimeString)) {
      return null;
    } else {
      DateTimeFormatter formatter = generateDateFormatter(format);
      return LocalDateTime.parse(dateTimeString, formatter);
    }
  }

  public static String DateTime2String(LocalDateTime date, DateTypeEnum type) {
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
