package com.uranus.fusion.asterix.measure;

import com.uranus.fusion.asterix.aircraft.pfd.TurnDirectionEnum;

/**
 * TrackAngleRate
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class TrackAngleRate {

  private TurnDirectionEnum turnDirectionEnum;
  private Double rate;

  public TurnDirectionEnum getTurnDirectionEnum() {
    return turnDirectionEnum;
  }

  public void setTurnDirectionEnum(
      TurnDirectionEnum turnDirectionEnum) {
    this.turnDirectionEnum = turnDirectionEnum;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }
}
