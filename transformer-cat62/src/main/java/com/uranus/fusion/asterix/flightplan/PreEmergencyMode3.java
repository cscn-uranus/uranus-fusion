package com.uranus.fusion.asterix.flightplan;

import com.uranus.fusion.asterix.aircraft.type.DataValidEnum;

/**
 * PreEmergencyMode3
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class PreEmergencyMode3 {

  private DataValidEnum dataValidEnum;
  private String code;

  public DataValidEnum getDataValidEnum() {
    return dataValidEnum;
  }

  public void setDataValidEnum(DataValidEnum dataValidEnum) {
    this.dataValidEnum = dataValidEnum;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
