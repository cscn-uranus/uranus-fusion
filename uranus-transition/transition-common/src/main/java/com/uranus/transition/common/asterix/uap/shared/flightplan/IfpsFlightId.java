package com.uranus.transition.common.asterix.uap.shared.flightplan;

import lombok.Data;

/**
 * IfpsFlightId
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class IfpsFlightId {

  /**
   * bits-32/31
   *
   * <p>(TYP) = 00 Plan Number = 01 Unit 1 internal flight number = 10 Unit 2 internal flight number
   * = 11 Unit 3 internal flight number
   */
  private IfpsFlightIdEnum ifpsFlightIdEnum;

  /**
   * bits-27/1
   *
   * (NBR) Number from 0 to 99 999 999
   */
  private Integer number;
}
