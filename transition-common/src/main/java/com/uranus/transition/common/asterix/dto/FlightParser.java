package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.dto.aircraft.AircraftDataDTO;
import com.uranus.transition.common.asterix.dto.aircraft.AircraftDataParser;
import com.uranus.transition.common.asterix.dto.flightplan.FlightPlanDataDTO;
import com.uranus.transition.common.asterix.dto.flightplan.FlightPlanDataParser;
import com.uranus.transition.common.asterix.dto.movement.ModeOfMovementDTO;
import com.uranus.transition.common.asterix.dto.movement.ModeOfMovementParser;

import java.time.LocalDateTime;

/**
 * @author tellxp@github.com
 * @date 2019/5/15 22:11
 */
public class FlightParser {

  public static FlightDTO parse(AsterixDataBlock asterixDataBlock) {
    if (null == asterixDataBlock) {
      return null;
    }
    FlightDTO flightDTO = new FlightDTO();
    DataIdentificationDTO dataIdentificationDTO = DataIdentificationParser.parse(asterixDataBlock);
    flightDTO.setDataIdentification(dataIdentificationDTO);

    LocalDateTime timeOfTrack = TimeOfTrackParser.parse(asterixDataBlock.getTimeOfTrack());
    flightDTO.setTimeOfTrack(timeOfTrack);

    Wgs84CoordinateDTO wgs84CoordinateDTO = Wgs84CoordinateParser.parse(asterixDataBlock);
    flightDTO.setWgs84Coordinate(wgs84CoordinateDTO);

    CartesianCoordinateDTO cartesianCoordinateDTO =
        CartesianCoordinateParser.parse(asterixDataBlock);
    flightDTO.setCartesianCoordinate(cartesianCoordinateDTO);

    String mode3Code = Mode3CodeParser.parse(asterixDataBlock.getMode3Code());
    flightDTO.setMode3Code(mode3Code);

    String flightIdentification = FlightIdentificationParser.parse(asterixDataBlock);
    flightDTO.setFlightIdentification(flightIdentification);

    AircraftDataDTO aircraftDataDTO =
        AircraftDataParser.parse(asterixDataBlock.getAircraftDerivedData());
    flightDTO.setAircraftData(aircraftDataDTO);

    Integer trackNumber = TrackNumberParser.parse(asterixDataBlock.getTrackNumber());
    flightDTO.setTrackNumber(trackNumber);

    ModeOfMovementDTO modeOfMovementDTO = ModeOfMovementParser.parse(asterixDataBlock);
    flightDTO.setModeOfMovement(modeOfMovementDTO);

    Double measuredFlightLevel =
        MeasuredFlightLevelParser.parse(asterixDataBlock.getMeasuredFlightLevel());
    flightDTO.setMeasuredFlightLevel(measuredFlightLevel);

    Double baroAltitude = BaroAltitudeParser.parse(asterixDataBlock.getTrackBarometricAltitude());
    flightDTO.setBaroAltitude(baroAltitude);

    Double rateOfClimbOrDescent =
        RateOfClimbOrDescentParser.parse(asterixDataBlock.getRateOfClimbOrDescent());
    flightDTO.setRateOfClimbOrDescent(rateOfClimbOrDescent);

    FlightPlanDataDTO flightPlanDataDTO =
        FlightPlanDataParser.parse(asterixDataBlock.getFlightPlanRelatedData());
    flightDTO.setFlightPlanData(flightPlanDataDTO);

    TargetShapeDTO targetShapeDTO = TargetShapeParser.parse(asterixDataBlock);
    flightDTO.setTargetShape(targetShapeDTO);

    return flightDTO;
  }
}
