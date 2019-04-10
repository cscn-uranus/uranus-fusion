package com.uranus.fusion.asterix.measure;

/**
 * FlightLevel
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class FlightLevel {

  private FlightLevelEnum flightLevelEnum;
  private Double fl;


  public FlightLevel(FlightLevelEnum flightLevelEnum) {
    this.flightLevelEnum = flightLevelEnum;
  }

  public FlightLevelEnum getFlightLevelEnum() {
    return flightLevelEnum;
  }

  public void setFlightLevelEnum(FlightLevelEnum flightLevelEnum) {
    this.flightLevelEnum = flightLevelEnum;
  }

  public Double getFl() {
    return fl;
  }

  public void setFl(Double fl) {
    this.fl = fl;
  }
}
