package com.uranus.transition.common.asterix.uap.flightplan;

import lombok.Data;

/**
 * RunwayDesignation
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class RunwayDesignation {

  /**
   * bits 24/17
   *
   * <p>(NU1) First number bits 16/9
   *
   * <p>(NU2) Second number bits 8/1 (LTR) Letter
   *
   * <p>NOTES 1. NU1, NU2 and LTR each contain an ASCII character 2. For details refer to.[5]
   * Section 5
   */
  private String icaoName;
}
