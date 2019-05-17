package com.uranus.fusion.common.asterix.uap.flightplan;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * FlightPlanTimeData
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class FlightPlanTimeData {

  private int repeatIndicator;
  private List<FlightPlanTime> flightPlanTimes = new ArrayList<>();

  public void add(FlightPlanTime flightPlanTime) {
    flightPlanTimes.add(flightPlanTime);
  }
}
