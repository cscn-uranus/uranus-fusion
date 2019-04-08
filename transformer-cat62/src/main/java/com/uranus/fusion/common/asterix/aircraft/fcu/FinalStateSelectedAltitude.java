package com.uranus.fusion.common.asterix.aircraft.fcu;

import com.uranus.fusion.common.asterix.aircraft.type.ModeActiveEnum;

/**
 * FinalStateSelectedAltitude
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/10/18
 */
public class FinalStateSelectedAltitude {

  private Double altitude;
  private ModeActiveEnum manageVerticalMode;
  private ModeActiveEnum altitudeHold;
  private ModeActiveEnum approachMode;

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

  public ModeActiveEnum getManageVerticalMode() {
    return manageVerticalMode;
  }

  public void setManageVerticalMode(ModeActiveEnum manageVerticalMode) {

    this.manageVerticalMode = manageVerticalMode;
  }

  public ModeActiveEnum getAltitudeHold() {
    return altitudeHold;
  }

  public void setAltitudeHold(ModeActiveEnum altitudeHold) {
    this.altitudeHold = altitudeHold;
  }

  public ModeActiveEnum getApproachMode() {
    return approachMode;
  }

  public void setApproachMode(ModeActiveEnum approachMode) {
    this.approachMode = approachMode;
  }
}
