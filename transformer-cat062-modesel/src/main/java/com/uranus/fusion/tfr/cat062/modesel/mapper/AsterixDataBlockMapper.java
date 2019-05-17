package com.uranus.fusion.tfr.cat062.modesel.mapper;

import com.uranus.fusion.common.asterix.AsterixDataBlock;
import com.uranus.fusion.common.asterix.uap.aircraft.AircraftDerivedData;
import com.uranus.fusion.tfr.cat062.modesel.dto.AircraftDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author tellxp@github.com
 * @date 2019/5/13 12:04
 */
public class AsterixDataBlockMapper {
  public static AircraftDTO toAircraftDTO(AsterixDataBlock asterixDataBlock) {
    AircraftDTO aircraftDTO = new AircraftDTO();
    AircraftDerivedData aircraftDerivedData = asterixDataBlock.getAircraftDerivedData();

    LocalDateTime timeOfTrack =
        LocalDateTime.of(
            LocalDate.now(),
            LocalTime.ofSecondOfDay(asterixDataBlock.getTimeOfTrack().getTime().longValue()));

    String aircraftAddress = aircraftDerivedData.getTargetAddress().getAddress();
    String flightIdentification = aircraftDerivedData.getTargetIdentification().getIdentification();
    Double selectedAltitude = aircraftDerivedData.getSelectedAltitude().getAltitude();
    Double finalStateSelectedAltitude = aircraftDerivedData.getFinalStateSelectedAltitude().getAltitude();
    Double trueAirspeed = aircraftDerivedData.getTrueAirspeed().getSpeed();
    Double indicatedAirspeed = aircraftDerivedData.getIndicatedAirspeed().getSpeed();
    Double machNumber = aircraftDerivedData.getMachNumber().getSpeed();

    aircraftDTO.setTimeOfTrack(timeOfTrack);
    aircraftDTO.setAircraftAddress(aircraftAddress);
    aircraftDTO.setFlightIdentification(flightIdentification);
    aircraftDTO.setSelectedAltitude(selectedAltitude);
    aircraftDTO.setFinalStateSelectedAltitude(finalStateSelectedAltitude);
    aircraftDTO.setTrueAirspeed(trueAirspeed);
    aircraftDTO.setIndicatedAirspeed(indicatedAirspeed);
    aircraftDTO.setMachNumber(machNumber);

    return aircraftDTO;
  }
}
