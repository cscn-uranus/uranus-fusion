package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FlightLevel;

/**
 * @author tellxp@github.com
 * @date 2019/5/24 18:05
 */

public class MeasuredFlightLevelParser {
  public static Double parse(FlightLevel flightLevel) {
    if (null==flightLevel){
      return null;
    }
    return flightLevel.getFl();
  }
}
