package com.uranus.transition.common.asterix.uap.flightplan;

import lombok.Data;

/**
 * WakeTurbulenceCategory
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class WakeTurbulenceCategory {

  /**
   * bits 8/1 Wake Turbulence Category is an ASCII character code which should be one of the
   * following values: L = Light M = Medium H = Heavy J = “Super”
   */
  private String category;
}
