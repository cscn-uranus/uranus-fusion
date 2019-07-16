package com.uranus.transition.common.dto;

import com.uranus.transition.common.dto.aircraft.AircraftDataDTO;
import com.uranus.transition.common.dto.aircraft.AircraftDataParser;
import com.uranus.transition.common.dto.flightplan.FlightPlanDataDTO;
import com.uranus.transition.common.dto.flightplan.FlightPlanDataParser;
import com.uranus.transition.common.dto.movement.ModeOfMovementDTO;
import com.uranus.transition.common.dto.movement.ModeOfMovementParser;
import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;

import java.time.LocalDateTime;

/**
 * @author tellxp@github.com
 * @date 2019/5/15 22:11
 */
public class FlightParser {

  public static FlightDTO parse(EuCat062DataBlock euCat062DataBlock) {
    if (null == euCat062DataBlock) {
      return null;
    }
    FlightDTO flightDTO = new FlightDTO();
    DataIdentificationDTO dataIdentificationDTO = DataIdentificationParser.parse(euCat062DataBlock);
    flightDTO.setDataIdentification(dataIdentificationDTO);

    LocalDateTime timeOfTrack = TimeOfTrackParser.parse(euCat062DataBlock.getTimeOfTrack());
    flightDTO.setTimeOfTrack(timeOfTrack);

    Wgs84CoordinateDTO wgs84CoordinateDTO = Wgs84CoordinateParser.parse(euCat062DataBlock);
    flightDTO.setWgs84Coordinate(wgs84CoordinateDTO);

    CartesianCoordinateDTO cartesianCoordinateDTO =
        CartesianCoordinateParser.parse(euCat062DataBlock);
    flightDTO.setCartesianCoordinate(cartesianCoordinateDTO);

    String mode3Code = Mode3CodeParser.parse(euCat062DataBlock.getMode3Code());
    flightDTO.setMode3Code(mode3Code);

    String flightIdentification = FlightIdentificationParser.parse(euCat062DataBlock);
    flightDTO.setFlightIdentification(flightIdentification);

    AircraftDataDTO aircraftDataDTO =
        AircraftDataParser.parse(euCat062DataBlock.getAircraftDerivedData());
    flightDTO.setAircraftData(aircraftDataDTO);

    Integer trackNumber = TrackNumberParser.parse(euCat062DataBlock.getTrackNumber());
    flightDTO.setTrackNumber(trackNumber);

    ModeOfMovementDTO modeOfMovementDTO = ModeOfMovementParser.parse(euCat062DataBlock);
    flightDTO.setModeOfMovement(modeOfMovementDTO);

    Double measuredFlightLevel =
        MeasuredFlightLevelParser.parse(euCat062DataBlock.getMeasuredFlightLevel());
    flightDTO.setMeasuredFlightLevel(measuredFlightLevel);

    Double baroAltitude = BaroAltitudeParser.parse(euCat062DataBlock.getTrackBarometricAltitude());
    flightDTO.setBaroAltitude(baroAltitude);

    Double rateOfClimbOrDescent =
        RateOfClimbOrDescentParser.parse(euCat062DataBlock.getRateOfClimbOrDescent());
    flightDTO.setRateOfClimbOrDescent(rateOfClimbOrDescent);

    FlightPlanDataDTO flightPlanDataDTO =
        FlightPlanDataParser.parse(euCat062DataBlock.getFlightPlanRelatedData());
    flightDTO.setFlightPlanData(flightPlanDataDTO);

    TargetShapeDTO targetShapeDTO = TargetShapeParser.parse(euCat062DataBlock);
    flightDTO.setTargetShape(targetShapeDTO);

    return flightDTO;
  }
}
