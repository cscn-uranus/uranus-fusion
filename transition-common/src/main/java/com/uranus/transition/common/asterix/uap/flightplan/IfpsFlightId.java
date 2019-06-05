package com.uranus.transition.common.asterix.uap.flightplan;

import lombok.Data;

/**
 * IfpsFlightId
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class IfpsFlightId {

  private IfpsFlightIdEnum ifpsFlightIdEnum;
  private Integer number;
}
