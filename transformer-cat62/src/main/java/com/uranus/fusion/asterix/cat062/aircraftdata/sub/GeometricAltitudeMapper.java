package com.uranus.fusion.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricAltitude;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricAltitudeEnum;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * GeometricAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class GeometricAltitudeMapper {

  public static GeometricAltitude readGeometricAltitude(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.GEOMETRIC_ALTITUDE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.GEOMETRIC_ALTITUDE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.GEOMETRIC_ALTITUDE_DRN);

      GeometricAltitude geometricAltitude =
          new GeometricAltitude(GeometricAltitudeEnum.AIRCRAFT_DERIVED);

      int altitude = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      geometricAltitude.setAltitude(DecimalUtil.multiply(altitude, 6.25));

      return geometricAltitude;
    }
    return null;
  }
}
