package com.uranus.transition.common.asterix.dto.flightplan;

import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanRelatedData;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanTime;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/5/21 14:47
 */
@Slf4j
public class FlightPlanDataParser {
  public static FlightPlanDataDTO parse(FlightPlanRelatedData input) {
    if (null == input) {
      return null;
    }
    FlightPlanDataDTO flightPlanDataDTO = new FlightPlanDataDTO();

    if (null != input.getFppsIdentificationTag()) {
      flightPlanDataDTO.setFppsId(
          input.getFppsIdentificationTag().getSac() + input.getFppsIdentificationTag().getSic());
    }

    if (null != input.getCallsign()) {
      flightPlanDataDTO.setCallsign(input.getCallsign().getSign());
    }

    if (null != input.getIfpsFlightId()) {
      flightPlanDataDTO.setIfpsId(input.getIfpsFlightId().getNumber());
    }

    if (null != input.getTypeOfAircraft()) {
      flightPlanDataDTO.setAircraftType(input.getTypeOfAircraft().getType());
    }

    if (null != input.getWakeTurbulenceCategory()) {
      flightPlanDataDTO.setWakeTurbulenceCategory(input.getWakeTurbulenceCategory().getCategory());
    }

    if (null != input.getDepartureAirport()) {
      flightPlanDataDTO.setDepartureAerodrome(input.getDepartureAirport().getIcaoName());
    }

    if (null != input.getDestinationAirport()) {
      flightPlanDataDTO.setDestinationAerodrome(input.getDestinationAirport().getIcaoName());
    }

    if (null != input.getRunwayDesignation()) {
      flightPlanDataDTO.setRunwayDesignation(input.getRunwayDesignation().getIcaoName());
    }

    if (null != input.getCurrentClearedFlightLevel()) {
      flightPlanDataDTO.setCurrentClearedFlightLevel(input.getCurrentClearedFlightLevel().getFl());
    }

    if (null != input.getFlightPlanTimeData()) {
      if (null!=input.getFlightPlanTimeData().getFlightPlanTimes()) {
        List<FlightPlanTime> flightPlanTimes = input.getFlightPlanTimeData().getFlightPlanTimes();
        copyFlightPlanTime(flightPlanDataDTO,flightPlanTimes);
      }
    }

    if (null!=input.getAircraftStand()) {
      flightPlanDataDTO.setAircraftStand(input.getAircraftStand().getStand());
    }

    if (null!=input.getStandardInstrumentDeparture()) {
      flightPlanDataDTO.setStandardInstrumentDeparture(input.getStandardInstrumentDeparture().getProcedure());
    }

    if (null!=input.getStandardInstrumentArrival()) {
      flightPlanDataDTO.setStandardInstrumentArrival(input.getStandardInstrumentArrival().getProcedure());
    }

    if (null!=input.getPreEmergencyMode3()) {
      flightPlanDataDTO.setPreEmergencyMode3Code(input.getPreEmergencyMode3().getCode());
    }

    if (null!=input.getPreEmergencyCallsign()) {
      flightPlanDataDTO.setPreEmergencyCallsign(input.getPreEmergencyCallsign().getSign());
    }
    return flightPlanDataDTO;
  }

  private static void copyFlightPlanTime(
      FlightPlanDataDTO flightPlanDataDTO, List<FlightPlanTime> flightPlanTimes) {

    for (FlightPlanTime flightPlanTime : flightPlanTimes) {
      switch (flightPlanTime.getFlightPlanTimeTypeEnum()) {
        case SOBT:
          flightPlanDataDTO.setScheduledOffBlockTime(parseFlightPlanTime(flightPlanTime));
          break;
        case EOBT:
          flightPlanDataDTO.setEstimatedOffBlockTime(parseFlightPlanTime(flightPlanTime));
          break;
        case ETOT:
          flightPlanDataDTO.setEstimatedTakeOffTime(parseFlightPlanTime(flightPlanTime));
          break;
        case AOBT:
          flightPlanDataDTO.setActualOffBlockTime(parseFlightPlanTime(flightPlanTime));
          break;
        case PTRH:
          flightPlanDataDTO.setPredictedTimeAtRunwayHold(parseFlightPlanTime(flightPlanTime));
          break;
        case ATRH:
          flightPlanDataDTO.setActualTimeAtRunwayHold(parseFlightPlanTime(flightPlanTime));
          break;
        case ALUT:
          flightPlanDataDTO.setActualLineUpTime(parseFlightPlanTime(flightPlanTime));
          break;
        case ATOT:
          flightPlanDataDTO.setActualTakeOffTime(parseFlightPlanTime(flightPlanTime));
          break;
        case ETA:
          flightPlanDataDTO.setEstimatedTimeOfArrival(parseFlightPlanTime(flightPlanTime));
          break;
        case PLDT:
          flightPlanDataDTO.setPredictedLandingTime(parseFlightPlanTime(flightPlanTime));
          break;
        case ALDT:
          flightPlanDataDTO.setActualLandingTime(parseFlightPlanTime(flightPlanTime));
          break;
        case ATOR:
          flightPlanDataDTO.setActualTimeOffRunway(parseFlightPlanTime(flightPlanTime));
          break;
        case PTTG:
          flightPlanDataDTO.setPredictedTimeToGate(parseFlightPlanTime(flightPlanTime));
          break;
        case AIBT:
          flightPlanDataDTO.setActualInBlockTime(parseFlightPlanTime(flightPlanTime));
          break;
        default:
          flightPlanDataDTO.setScheduledOffBlockTime(LocalDateTime.now());
          break;
      }
    }
  }

  private static LocalDateTime parseFlightPlanTime(FlightPlanTime flightPlanTime) {
    LocalDate today = LocalDate.now();
    LocalDate yesterday = LocalDate.now().minusDays(1);
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    LocalTime time =
        LocalTime.of(
            flightPlanTime.getHour(), flightPlanTime.getMinute(), flightPlanTime.getSecond());

    switch (flightPlanTime.getFlightPlanDayEnum()) {
      case TODAY:
        return LocalDateTime.of(today, time);
      case YESTERDAY:
        return LocalDateTime.of(yesterday, time);
      case TOMORROW:
        return LocalDateTime.of(tomorrow, time);
      case INVALID:
        log.warn("invalid");
        return LocalDateTime.now();
      default:
        log.error("error flightPlanTime");
        return LocalDateTime.now();
    }
  }
}
