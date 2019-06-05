package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.uap.measure.altitude.BarometricAltitude;

/**
 * @author tellxp@github.com
 * @date 2019/5/24 18:05
 */

public class BaroAltitudeParser {
  public static Double parse(BarometricAltitude barometricAltitude) {
    if (null==barometricAltitude) {
      return null;
    }
    return barometricAltitude.getAltitude();
  }
}
