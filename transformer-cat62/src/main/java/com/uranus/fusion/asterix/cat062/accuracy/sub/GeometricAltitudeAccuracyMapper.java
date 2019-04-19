package com.uranus.fusion.asterix.cat062.accuracy.sub;

import com.uranus.fusion.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.accuracy.GeometricAltitudeAccuracy;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * GeometricAltitudeAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class GeometricAltitudeAccuracyMapper {

  public static GeometricAltitudeAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.GEOMETRIC_ALTITUDE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.GEOMETRIC_ALTITUDE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.GEOMETRIC_ALTITUDE_DRN);

      GeometricAltitudeAccuracy geometricAltitudeAccuracy = new GeometricAltitudeAccuracy();

      int accuracyAltitudeValue = IntegerUtil.valueOf(uap.get(index));
      double accuracyAltitude = DecimalUtil.multiply(accuracyAltitudeValue, 6.25);
      geometricAltitudeAccuracy.setAccuracyAltitude(accuracyAltitude);

      return geometricAltitudeAccuracy;
    }
    return null;
  }
}
