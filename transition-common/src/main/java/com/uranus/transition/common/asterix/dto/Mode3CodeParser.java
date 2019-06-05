package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.uap.emitter.mode3.Mode3Code;

/**
 * @author tellxp@github.com
 * @date 2019/5/24 15:06
 */
public class Mode3CodeParser {
  public static String parse(Mode3Code mode3Code) {
    if (null==mode3Code) {
      return null;
    }
    return mode3Code.getCode();
  }
}
