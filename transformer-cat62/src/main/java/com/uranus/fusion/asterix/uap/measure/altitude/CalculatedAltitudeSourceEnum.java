package com.uranus.fusion.asterix.uap.measure.altitude;

/**
 * CaculatedAltitudeSourceEnum
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public enum CalculatedAltitudeSourceEnum {
  // no
  NO_SOURCE,
  GNSS,
  RADAR_3D,
  TRIANGULATION,
  HEIGHT_FROM_COVERAGE,
  SPEED_LOOKUP_TABLE,
  DEFAULT,
  MULTILATERATION
}
