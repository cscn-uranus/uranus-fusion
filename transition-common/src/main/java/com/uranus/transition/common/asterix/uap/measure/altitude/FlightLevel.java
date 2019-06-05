package com.uranus.transition.common.asterix.uap.measure.altitude;

import lombok.Data;

/**
 * FlightLevel
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class FlightLevel {

  private FlightLevelEnum flightLevelEnum;
  private Double fl;

  public FlightLevel(FlightLevelEnum flightLevelEnum) {
    this.flightLevelEnum = flightLevelEnum;
  }
}
