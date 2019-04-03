package com.uranus.fusion.transformer.asterix.track.status.type;

/**
 * CaculatedAltitudeSourceEnum
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
public enum CalculatedAltitudeSourceEnum {
  // no
  NO_SOURCE,
  GNSS,
  D3_RADAR,
  TRIANGULATION,
  HEIGHT_FROM_COVERAGE,
  SPEED_LOOKUP_TABLE,
  DEFAULT,
  MULTILATERATION
}
