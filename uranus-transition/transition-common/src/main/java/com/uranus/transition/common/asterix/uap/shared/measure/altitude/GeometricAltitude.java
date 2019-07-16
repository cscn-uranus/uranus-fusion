package com.uranus.transition.common.asterix.uap.shared.measure.altitude;

import lombok.Data;

/**
 * GeometricAltitude
 *
 * <p>Data Item I062/130, Calculated Track Geometric Altitude
 *
 * <p>Definition : Vertical distance between the target and the projection of its position on the
 * earth’s ellipsoid, as defined by WGS84, in two’s complement form.
 *
 * <p>Format : Two-Octet fixed length data item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
@Data
public class GeometricAltitude {

  /**
   * 地理高度
   */
  private GeometricAltitudeEnum geometricAltitudeEnum;

  /** bits- 16/1
   *
   * Altitude
   *
   * (LSB) = 6.25 ft Vmin = -1500 ft Vmax = 150000 ft */
  private Double altitude;

  public GeometricAltitude(GeometricAltitudeEnum geometricAltitudeEnum) {
    this.geometricAltitudeEnum = geometricAltitudeEnum;
  }
}
