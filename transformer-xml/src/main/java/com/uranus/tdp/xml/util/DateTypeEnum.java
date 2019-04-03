/*
 * Copyright (c) 2017. Cscn and/or its affiliates. All rights reserved.
 * Cscn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.uranus.tdp.xml.util;

/**
 * 日期类型枚举
 *
 * <p>分为14位，12位，8位日期三种类型
 */
public enum DateTypeEnum {
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
