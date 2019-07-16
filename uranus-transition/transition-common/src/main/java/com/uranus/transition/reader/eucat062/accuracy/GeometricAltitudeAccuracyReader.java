package com.uranus.transition.reader.eucat062.accuracy;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.accuracy.GeometricAltitudeAccuracy;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * GeometricAltitudeAccuracyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class GeometricAltitudeAccuracyReader {

  public static GeometricAltitudeAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.GEOMETRIC_ALTITUDE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.GEOMETRIC_ALTITUDE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.GEOMETRIC_ALTITUDE_DRN);

      GeometricAltitudeAccuracy geometricAltitudeAccuracy = new GeometricAltitudeAccuracy();

      int accuracyAltitudeValue = IntegerUtil.unsignedValueOf(uap.get(index));
      double accuracyAltitude = DecimalUtil.multiply(accuracyAltitudeValue, 6.25);
      geometricAltitudeAccuracy.setAccuracyAltitude(accuracyAltitude);

      return geometricAltitudeAccuracy;
    }
    return null;
  }
}
