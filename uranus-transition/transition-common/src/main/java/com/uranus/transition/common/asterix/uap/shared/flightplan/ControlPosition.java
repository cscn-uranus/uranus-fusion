package com.uranus.transition.common.asterix.uap.shared.flightplan;

import lombok.Data;

/**
 * ControlPosition
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class ControlPosition {

  /**
   * bits 16/9 (Centre) 8-bit group Identification code
   */
  private String centreCode;

  /** bits 8/1 (Position) 8-bit Control Position identification code */
  private String positionCode;
}
