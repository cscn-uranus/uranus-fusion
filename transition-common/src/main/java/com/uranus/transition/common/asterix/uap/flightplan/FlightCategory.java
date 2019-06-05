package com.uranus.transition.common.asterix.uap.flightplan;

import lombok.Data;

/**
 * FlightCategory
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class FlightCategory {

  private AirTrafficEnum airTrafficEnum;
  private FlightRuleEnum flightRuleEnum;
  private RvsmEnum rvsmEnum;
  private FlightPriorityEnum flightPriorityEnum;
}
