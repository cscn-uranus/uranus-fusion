package com.uranus.fusion.asterix.uap.measure.speed;

import lombok.Data;

/**
 * Airspeed
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/17
 */
@Data
public class Airspeed {

  private Double speed;
  private SpeedTypeEnum speedTypeEnum;

  public Airspeed(SpeedTypeEnum speedTypeEnum) {
    this.speedTypeEnum = speedTypeEnum;
  }
}
