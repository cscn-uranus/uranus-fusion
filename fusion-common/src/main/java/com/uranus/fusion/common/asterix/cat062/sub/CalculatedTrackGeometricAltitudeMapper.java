package com.uranus.fusion.common.asterix.cat062.sub;

import com.uranus.fusion.common.asterix.cat062.Cat062Config;
import com.uranus.fusion.common.asterix.spec.FieldSpec;
import com.uranus.fusion.common.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.FpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.altitude.GeometricAltitude;
import com.uranus.fusion.common.asterix.uap.measure.altitude.GeometricAltitudeEnum;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackGeometricAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class CalculatedTrackGeometricAltitudeMapper {

  public static GeometricAltitude read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.CALCULATED_TRACK_GEOMETRIC_ALTITUDE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.CALCULATED_TRACK_GEOMETRIC_ALTITUDE_SIZE);

      int index =
          fieldSpec.calculateIndexByFrn(Cat062Config.CALCULATED_TRACK_GEOMETRIC_ALTITUDE_FRN);

      GeometricAltitude trackGeometricAltitude =
          new GeometricAltitude(GeometricAltitudeEnum.CALCULATED);
      int altitudeValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      trackGeometricAltitude.setAltitude(DecimalUtil.multiply(altitudeValue, 6.25));
      return trackGeometricAltitude;
    }
    return null;
  }
}
