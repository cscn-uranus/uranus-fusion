package com.uranus.fusion.asterix.accuracy;

/**
 * Wgs84PositionAccuracy
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/14
 */
public class Wgs84PositionAccuracy {

  private Double accuracyLatitude;
  private Double accuracyLongitude;

  public Double getAccuracyLatitude() {
    return accuracyLatitude;
  }

  public void setAccuracyLatitude(Double accuracyLatitude) {
    this.accuracyLatitude = accuracyLatitude;
  }

  public Double getAccuracyLongitude() {
    return accuracyLongitude;
  }

  public void setAccuracyLongitude(Double accuracyLongitude) {
    this.accuracyLongitude = accuracyLongitude;
  }
}
