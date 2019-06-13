package com.uranus.transition.common.asterix.uap.flightplan;

import lombok.Data;

/**
 * TypeOfAircraft
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class TypeOfAircraft {

  /**
   * NOTES 1. Each one of the four Octets composing the type of an aircraft contains an ASCII
   * Character (upper-case alphanumeric characters with trailing spaces). 2. The types of aircraft
   * are defined in [Ref.4]
   */
  private String type;
}
