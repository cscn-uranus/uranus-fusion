package com.uranus.transition.common.asterix.uap.flightplan;

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

  /** bits-40/33 (REP) Repetition Factor */
  private int repeatIndicator;

  /**
   * bits-32/28 (TYP) = 0 Scheduled off-block time = 1 Estimated off-block time = 2 Estimated
   * take-off time = 3 Actual off-block time = 4 Predicted time at runway hold = 5 Actual time at
   * runway hold = 6 Actual line-up time = 7 Actual take-off time = 8 Estimated time of arrival = 9
   * Predicted landing time = 10 Actual landing time = 11 Actual time off runway = 12 Predicted time
   * to gate = 13 Actual on-block time bits-27/26
   *
   * <p>(DAY) = 00 Today = 01 Yesterday = 10 Tomorrow = 11 Invalid bits-25/22 spare bits set to zero
   * bits-21/17
   *
   * <p>(HOR) Hours, from 0 to 23 bits-16/15 spare bits set to zero bits-14/9
   *
   * <p>(MIN) Minutes, from 0 to 59 bit-8
   *
   * <p>(AVS) = 0 Seconds available = 1 Seconds not available bit-7 spare bits set to zero bits-6/1
   *
   * <p>(SEC) Seconds, from 0 to 59
   */
  private List<FlightPlanTime> flightPlanTimes = new ArrayList<>();

  public void add(FlightPlanTime flightPlanTime) {
    flightPlanTimes.add(flightPlanTime);
  }
}
