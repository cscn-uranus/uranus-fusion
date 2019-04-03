package com.uranus.fusion.transformer.asterix.sensor;

import com.uranus.fusion.transformer.asterix.measure.GeometricAltitude;
import com.uranus.fusion.transformer.asterix.measure.GeometricAltitudeEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * TrackGeometricAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class TrackGeometricAltitudeMapper {

  public static GeometricAltitude read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 18;
    final int length = 2;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      GeometricAltitude trackGeometricAltitude = new GeometricAltitude(
          GeometricAltitudeEnum.CALCULATED);
      int altitudeValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      trackGeometricAltitude.setAltitude(DecimalUtil.multiply(altitudeValue, 6.25));
      return trackGeometricAltitude;

    }
    return null;
  }

}
