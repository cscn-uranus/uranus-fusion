package com.uranus.fusion.asterix.uap.measure.altitude;

import lombok.Data;

/**
 * GeometricAltitude
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
@Data
public class GeometricAltitude {

  private GeometricAltitudeEnum geometricAltitudeEnum;
  private Double altitude;

  public GeometricAltitude(GeometricAltitudeEnum geometricAltitudeEnum) {
    this.geometricAltitudeEnum = geometricAltitudeEnum;
  }
}
