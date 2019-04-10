package com.uranus.fusion.asterix.measure;

/**
 * IndicatedAirspeed
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/17
 */
public class IndicatedAirspeed {

  private Double speed;
  private SpeedUnitEnum speedUnitEnum;

  public IndicatedAirspeed(SpeedUnitEnum speedUnitEnum) {
    this.speedUnitEnum = speedUnitEnum;
  }

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public SpeedUnitEnum getSpeedUnitEnum() {
    return speedUnitEnum;
  }

  public void setSpeedUnitEnum(SpeedUnitEnum speedUnitEnum) {
    this.speedUnitEnum = speedUnitEnum;
  }
}
