package com.uranus.fusion.transformer.asterix.flightplan;

/**
 * FlightCategory
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class FlightCategory {

  private AirTrafficEnum airTrafficEnum;
  private FlightRuleEnum flightRuleEnum;
  private RvsmEnum rvsmEnum;
  private FlightPriorityEnum flightPriorityEnum;

  public AirTrafficEnum getAirTrafficEnum() {
    return airTrafficEnum;
  }

  public void setAirTrafficEnum(AirTrafficEnum airTrafficEnum) {
    this.airTrafficEnum = airTrafficEnum;
  }

  public FlightRuleEnum getFlightRuleEnum() {
    return flightRuleEnum;
  }

  public void setFlightRuleEnum(FlightRuleEnum flightRuleEnum) {
    this.flightRuleEnum = flightRuleEnum;
  }

  public RvsmEnum getRvsmEnum() {
    return rvsmEnum;
  }

  public void setRvsmEnum(RvsmEnum rvsmEnum) {
    this.rvsmEnum = rvsmEnum;
  }

  public FlightPriorityEnum getFlightPriorityEnum() {
    return flightPriorityEnum;
  }

  public void setFlightPriorityEnum(FlightPriorityEnum flightPriorityEnum) {
    this.flightPriorityEnum = flightPriorityEnum;
  }
}
