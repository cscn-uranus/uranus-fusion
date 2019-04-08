package com.uranus.fusion.common.asterix.aircraft.transponder.mode5;

/**
 * Mode5Altitude
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5Altitude {

  private AltitudeResolutionEnum altitudeResolutionEnum;
  private Double altitude;

  public AltitudeResolutionEnum getAltitudeResolutionEnum() {
    return altitudeResolutionEnum;
  }

  public void setAltitudeResolutionEnum(
      AltitudeResolutionEnum altitudeResolutionEnum) {
    this.altitudeResolutionEnum = altitudeResolutionEnum;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }
}
