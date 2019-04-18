package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricAltitude;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricAltitudeEnum;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * TrackGeometricAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class TrackGeometricAltitudeMapper {

  public static GeometricAltitude read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.getFpIndicator(Cat062Config.CALCULATED_TRACK_GEOMETRIC_ALTITUDE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.CALCULATED_TRACK_GEOMETRIC_ALTITUDE_SIZE);

      int index =
          fieldSpec.calculateIndexByFrn(Cat062Config.CALCULATED_TRACK_GEOMETRIC_ALTITUDE_FRN);

      GeometricAltitude trackGeometricAltitude =
          new GeometricAltitude(GeometricAltitudeEnum.CALCULATED);
      int altitudeValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      trackGeometricAltitude.setAltitude(DecimalUtil.multiply(altitudeValue, 6.25));
      return trackGeometricAltitude;
    }
    return null;
  }
}
