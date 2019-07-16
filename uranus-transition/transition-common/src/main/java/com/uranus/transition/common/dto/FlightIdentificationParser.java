package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;
import com.uranus.transition.common.asterix.uap.eucat062.AircraftDerivedData;
import com.uranus.transition.common.asterix.uap.eucat062.FlightPlanRelatedData;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetIdentification;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 22:03
 */

public class FlightIdentificationParser {
  public static String parse(EuCat062DataBlock euCat062DataBlock) {
    String identification;
    if (null==euCat062DataBlock) {
      return null;
    }

    identification = parse(euCat062DataBlock.getFlightPlanRelatedData());
    if (null!=identification) {
      return identification;
    }

    identification=parse(euCat062DataBlock.getAircraftDerivedData());
    if (null!=identification) {
      return identification;
    }

    identification= parse(euCat062DataBlock.getTargetIdentification());
    return identification;

  }
  private static String parse(TargetIdentification targetIdentification) {
    if (null==targetIdentification) {
      return null;
    }
    return targetIdentification.getIdentification();
  }
  private static String parse(AircraftDerivedData aircraftDerivedData) {
    if (null==aircraftDerivedData) {
      return null;
    }
    if (null==aircraftDerivedData.getTargetIdentification()) {
      return null;
    }
    return aircraftDerivedData.getTargetIdentification().getIdentification();
  }
  private static String parse(FlightPlanRelatedData flightPlanRelatedData) {
    if (null==flightPlanRelatedData) {
      return null;
    }
    if (null==flightPlanRelatedData.getCallsign()) {
      return null;
    }
    return flightPlanRelatedData.getCallsign().getSign();
  }
}
