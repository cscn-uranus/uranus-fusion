package com.uranus.transition.common.util;

/**
 * TransversalMoveEnum
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
public enum DateTypeEnum {
  //
  DateTimeToMinute("yyyyMMddHHmm"),
  DateTimeToSecond("yyyyMMddHHmmss"),
  Date("yyyyMMdd"),
  ShortDate("yyMMdd"),
  TimeToMinute("HHmm"),
  TimeToSecond("HHmmss");

  private String formatString;

  DateTypeEnum(String formatString) {
    this.formatString = formatString;
  }

  public String getFormatString() {
    return formatString;
  }

  public void setFormatString(String formatString) {
    this.formatString = formatString;
  }
}
