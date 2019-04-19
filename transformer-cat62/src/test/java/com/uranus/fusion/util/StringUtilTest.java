package com.uranus.fusion.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

  @Test
  public void valueOf() {
    String bitString = "010011111000";
    String value = StringUtil.valueOf(bitString,3);
    System.out.println(value);
  }
}