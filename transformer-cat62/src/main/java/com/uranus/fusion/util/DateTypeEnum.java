package com.uranus.fusion.util;

/**
 * TransversalMoveEnum
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public enum DateTypeEnum {
  // 14
  FOURTEEN("yyyyMMddHHmmss"),
  TWELVE("yyyyMMddHHmm"),
  EIGHT("yyyyMMdd");

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
