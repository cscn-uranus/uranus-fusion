package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.shared.measure.altitude.RateOfClimbOrDescent;

/**
 * @author tellxp@github.com
 * @date 2019/5/24 18:05
 */

public class RateOfClimbOrDescentParser {
  public static Double parse(RateOfClimbOrDescent rateOfClimbOrDescent) {
    if (null==rateOfClimbOrDescent) {
      return null;
    }

    return rateOfClimbOrDescent.getRate();
  }
}
