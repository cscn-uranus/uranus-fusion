package com.uranus.fusion.common.asterix.flightplan;

import java.util.HashSet;
import java.util.Set;

/**
 * FlightPlanTimeData
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class FlightPlanTimeData {

  private int repeatIndicator;
  private Set<FlightPlanTime> flightPlanTimes;

  public FlightPlanTimeData() {
    this.flightPlanTimes = new HashSet<>();
  }

  public int getRepeatIndicator() {
    return repeatIndicator;
  }

  public void setRepeatIndicator(int repeatIndicator) {
    this.repeatIndicator = repeatIndicator;
  }

  public Set<FlightPlanTime> getFlightPlanTimes() {
    return flightPlanTimes;
  }

  public void setFlightPlanTimes(
      Set<FlightPlanTime> flightPlanTimes) {
    this.flightPlanTimes = flightPlanTimes;
  }

  public void add(FlightPlanTime flightPlanTime) {
    this.flightPlanTimes.add(flightPlanTime);
  }
}
