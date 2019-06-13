package com.uranus.transition.common.asterix.uap.flightplan;

import lombok.Data;

/**
 * FlightCategory
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class FlightCategory {

  /**
   * bits 8/7 (GAT/OAT) = 00 Unknown = 01 General Air Traffic = 10 Operational Air Traffic = 11 Not
   * applicable
   */
  private AirTrafficEnum airTrafficEnum;

  /**
   * bits 6/5 (FR1/FR2) = 00 Instrument Flight Rules = 01 Visual Flight rules = 10 Not applicable =
   * 11 Controlled Visual Flight Rules
   */
  private FlightRuleEnum flightRuleEnum;

  /** bits 4/3 (RVSM) = 00 Unknown = 01 Approved = 10 Exempt = 11 Not Approved */
  private RvsmEnum rvsmEnum;

  /** bit 2 (HPR) = 0 Normal Priority Flight = 1 High Priority Flight */
  private FlightPriorityEnum flightPriorityEnum;
}
