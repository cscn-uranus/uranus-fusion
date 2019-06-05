package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.uap.aircraft.AircraftDerivedData;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanRelatedData;
import com.uranus.transition.common.asterix.uap.identification.TargetIdentification;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 22:03
 */

public class FlightIdentificationParser {
  public static String parse(AsterixDataBlock asterixDataBlock) {
    String identification;
    if (null==asterixDataBlock) {
      return null;
    }

    identification = parse(asterixDataBlock.getFlightPlanRelatedData());
    if (null!=identification) {
      return identification;
    }

    identification=parse(asterixDataBlock.getAircraftDerivedData());
    if (null!=identification) {
      return identification;
    }

    identification= parse(asterixDataBlock.getTargetIdentification());
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
