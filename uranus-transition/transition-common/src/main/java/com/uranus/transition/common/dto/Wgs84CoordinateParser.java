package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;
import com.uranus.transition.common.asterix.uap.eucat062.AircraftDerivedData;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */
public class Wgs84CoordinateParser {
  public static Wgs84CoordinateDTO parse(EuCat062DataBlock euCat062DataBlock) {

    if (null == euCat062DataBlock) {
      return null;
    }
    if (null==euCat062DataBlock.getWgs84Position()&&null==euCat062DataBlock.getTrackGeometricAltitude()) {
      return null;
    }
    Wgs84CoordinateDTO wgs84CoordinateDTO = new Wgs84CoordinateDTO();

    if (null != euCat062DataBlock.getWgs84Position()) {
      wgs84CoordinateDTO.setLatitude(euCat062DataBlock.getWgs84Position().getLatitude());
      wgs84CoordinateDTO.setLongitude(euCat062DataBlock.getWgs84Position().getLongitude());
    }

    if (null != euCat062DataBlock.getTrackGeometricAltitude()) {
      wgs84CoordinateDTO.setAltitude(euCat062DataBlock.getTrackGeometricAltitude().getAltitude());
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
