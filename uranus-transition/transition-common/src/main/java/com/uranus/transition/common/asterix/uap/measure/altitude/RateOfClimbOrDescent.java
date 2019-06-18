package com.uranus.transition.common.asterix.uap.measure.altitude;

import lombok.Data;

/**
 * RateOfClimbOrDescent
 *
 * <p>Data Item I062/220, Calculated Rate Of Climb/Descent
 *
 * Definition : Calculated rate of
 * Climb/Descent of an aircraft in two’s complement form.
 *
 * Format : Two-Octet fixed length data item.
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
@Data
public class RateOfClimbOrDescent {

  /** bit 16/1 Rate of Climb/Descent
   *
   * (LSB) = 6.25 feet/minute */
  private Double rate;
}
