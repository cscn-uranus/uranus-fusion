package com.uranus.fusion.asterix.flightplan;

import com.uranus.fusion.asterix.aircraft.type.DataAvailableEnum;

/**
 * FlightPlanTime
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class FlightPlanTime {

  private FlightPlanTimeTypeEnum flightPlanTimeTypeEnum;
  private FlightPlanDayEnum flightPlanDayEnum;
  private Integer hour;
  private Integer minute;
  private DataAvailableEnum secondAvailableStatus;
  private Integer second;


  public FlightPlanTimeTypeEnum getFlightPlanTimeTypeEnum() {
    return flightPlanTimeTypeEnum;
  }

  public void setFlightPlanTimeTypeEnum(
      FlightPlanTimeTypeEnum flightPlanTimeTypeEnum) {
    this.flightPlanTimeTypeEnum = flightPlanTimeTypeEnum;
  }

  public FlightPlanDayEnum getFlightPlanDayEnum() {
    return flightPlanDayEnum;
  }

  public void setFlightPlanDayEnum(
      FlightPlanDayEnum flightPlanDayEnum) {
    this.flightPlanDayEnum = flightPlanDayEnum;
  }

  public Integer getHour() {
    return hour;
  }

  public void setHour(Integer hour) {
    this.hour = hour;
  }

  public Integer getMinute() {
    return minute;
  }

  public void setMinute(Integer minute) {
    this.minute = minute;
  }

  public DataAvailableEnum getSecondAvailableStatus() {
    return secondAvailableStatus;
  }

  public void setSecondAvailableStatus(
      DataAvailableEnum secondAvailableStatus) {
    this.secondAvailableStatus = secondAvailableStatus;
  }

  public Integer getSecond() {
    return second;
  }

  public void setSecond(Integer second) {
    this.second = second;
  }
}
