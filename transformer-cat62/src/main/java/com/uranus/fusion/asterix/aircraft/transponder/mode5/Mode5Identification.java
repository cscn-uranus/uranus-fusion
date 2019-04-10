package com.uranus.fusion.asterix.aircraft.transponder.mode5;

/**
 * Mode5Identification
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5Identification {

  private String pin;
  private String nationalOrigin;
  private String missionCode;

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getNationalOrigin() {
    return nationalOrigin;
  }

  public void setNationalOrigin(String nationalOrigin) {
    this.nationalOrigin = nationalOrigin;
  }

  public String getMissionCode() {
    return missionCode;
  }

  public void setMissionCode(String missionCode) {
    this.missionCode = missionCode;
  }
}
