package com.uranus.transition.common.asterix.uap.flightplan;

import lombok.Data;

/**
 * PreEmergencyCallsign
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class PreEmergencyCallsign {

  /**
   * NOTES 1. Each one of the seven Octets contains an ASCII Character. The Callsign is always left
   * adjusted. It contains up to seven upper-case alphanumeric characters, the remaining character
   * positions (if any) are padded with space characters 2. This subfield is used only when an
   * emergency Mode 3/A is associated with the track (I062/390 Subfield #17)
   */
  private String sign;
}
