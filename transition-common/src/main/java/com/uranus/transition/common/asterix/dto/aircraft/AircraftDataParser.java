package com.uranus.transition.common.asterix.dto.aircraft;

import com.uranus.transition.common.asterix.uap.aircraft.AircraftDerivedData;
import com.uranus.transition.common.asterix.dto.Wgs84CoordinateParser;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 20:49
 */

public class AircraftDataParser {
  public static AircraftDataDTO parse(AircraftDerivedData input) {

    if (null==input) {
      return null;
    }

    AircraftDataDTO aircraftDataDTO = new AircraftDataDTO();

    if (null!=input.getTargetAddress()) {
      aircraftDataDTO.setTargetAddress(input.getTargetAddress().getAddress());
    }

    if (null!=input.getTargetIdentification()) {
      aircraftDataDTO.setTargetIdentification(input.getTargetIdentification().getIdentification());
    }

    if (null!=input.getMagneticHeading()) {
      aircraftDataDTO.setMagneticHeading(input.getMagneticHeading().getDegree());
    }

    if (null!=input.getIndicatedAirspeed()) {
      aircraftDataDTO.setIndicatedAirspeed(input.getIndicatedAirspeed().getSpeed());
    }

    if (null!=input.getMachNumber()) {
      aircraftDataDTO.setMachNumber(input.getMachNumber().getSpeed());
    }

    if (null!=input.getTrueAirspeed()) {
      aircraftDataDTO.setTrueAirspeed(input.getTrueAirspeed().getSpeed());
    }

    if (null!=input.getSelectedAltitude()) {
      aircraftDataDTO.setSelectedAltitude(input.getSelectedAltitude().getAltitude());
    }

    if (null!=input.getFinalStateSelectedAltitude()) {
      aircraftDataDTO.setFinalStateSelectedAltitude(input.getFinalStateSelectedAltitude().getAltitude());
    }

    if (null!=input.getBarometricVerticalRate()) {
      aircraftDataDTO.setBaroVerticalRate(input.getBarometricVerticalRate().getRate());
    }

    if (null!=input.getGeometricVerticalRate()) {
      aircraftDataDTO.setGeoVerticalRate(input.getGeometricVerticalRate().getRate());
    }

    if (null!=input.getRollAngle()) {
      aircraftDataDTO.setRollAngle(input.getRollAngle().getAngle());
    }

    if (null!=input.getTrackAngleRate()) {
      aircraftDataDTO.setTrackAngleRate(input.getTrackAngleRate().getRate());
    }

    if (null!=input.getTrackAngle()) {
      aircraftDataDTO.setTrackAngle(input.getTrackAngle().getAngle());
    }

    if (null!=input.getGroundSpeed()) {
      aircraftDataDTO.setGroundSpeed(input.getGroundSpeed().getSpeed());
    }

    if (null!=input.getEmitterCategory()) {
      aircraftDataDTO.setEmitterCategory(input.getEmitterCategory().toString());
    }

    aircraftDataDTO.setWgs84Coordinate(Wgs84CoordinateParser.parse(input));

    if (null!=input.getBarometricPressureSetting()) {
      aircraftDataDTO.setBaroPressureSetting(input.getBarometricPressureSetting().getPressure());
    }

    return aircraftDataDTO;
  }
}
