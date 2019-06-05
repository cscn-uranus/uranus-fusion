package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.uap.aircraft.AircraftDerivedData;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */
public class Wgs84CoordinateParser {
  public static Wgs84CoordinateDTO parse(AsterixDataBlock asterixDataBlock) {

    if (null == asterixDataBlock) {
      return null;
    }
    if (null==asterixDataBlock.getWgs84Position()&&null==asterixDataBlock.getTrackGeometricAltitude()) {
      return null;
    }
    Wgs84CoordinateDTO wgs84CoordinateDTO = new Wgs84CoordinateDTO();

    if (null != asterixDataBlock.getWgs84Position()) {
      wgs84CoordinateDTO.setLatitude(asterixDataBlock.getWgs84Position().getLatitude());
      wgs84CoordinateDTO.setLongitude(asterixDataBlock.getWgs84Position().getLongitude());
    }

    if (null != asterixDataBlock.getTrackGeometricAltitude()) {
      wgs84CoordinateDTO.setAltitude(asterixDataBlock.getTrackGeometricAltitude().getAltitude());
    }
    return wgs84CoordinateDTO;
  }

  public static Wgs84CoordinateDTO parse(AircraftDerivedData aircraftDerivedData) {
    if (null==aircraftDerivedData) {
      return null;
    }
    if (null==aircraftDerivedData.getPosition()&&null==aircraftDerivedData.getGeometricAltitude()) {
      return null;
    }
    Wgs84CoordinateDTO wgs84CoordinateDTO = new Wgs84CoordinateDTO();

    if (null!=aircraftDerivedData.getPosition()) {
      wgs84CoordinateDTO.setLatitude(aircraftDerivedData.getPosition().getLatitude());
      wgs84CoordinateDTO.setLongitude(aircraftDerivedData.getPosition().getLongitude());
    }

    if (null!=aircraftDerivedData.getGeometricAltitude()) {
      wgs84CoordinateDTO.setAltitude(aircraftDerivedData.getGeometricAltitude().getAltitude());
    }
    return wgs84CoordinateDTO;
  }
}
