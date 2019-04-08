package com.uranus.fusion.common.asterix.measure;

/**
 * GeometricAltitude
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class GeometricAltitude {

  private GeometricAltitudeEnum geometricAltitudeEnum;
  private Double altitude;

  public GeometricAltitude(GeometricAltitudeEnum geometricAltitudeEnum) {
    this.geometricAltitudeEnum = geometricAltitudeEnum;
  }

  public GeometricAltitudeEnum getGeometricAltitudeEnum() {
    return geometricAltitudeEnum;
  }

  public void setGeometricAltitudeEnum(
      GeometricAltitudeEnum geometricAltitudeEnum) {
    this.geometricAltitudeEnum = geometricAltitudeEnum;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }
}
