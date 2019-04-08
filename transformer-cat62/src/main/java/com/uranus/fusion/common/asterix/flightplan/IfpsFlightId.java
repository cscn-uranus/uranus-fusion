package com.uranus.fusion.common.asterix.flightplan;

/**
 * IfpsFlightId
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class IfpsFlightId {

  private IfpsFlightIdEnum ifpsFlightIdEnum;
  private Integer number;

  public IfpsFlightIdEnum getIfpsFlightIdEnum() {
    return ifpsFlightIdEnum;
  }

  public void setIfpsFlightIdEnum(IfpsFlightIdEnum ifpsFlightIdEnum) {
    this.ifpsFlightIdEnum = ifpsFlightIdEnum;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }
}
