package com.uranus.transition.common.asterix.cat062.accuracy;

import com.uranus.transition.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.accuracy.BarometricAltitudeAccuracy;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * BarometricAltitudeAccuracyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class BarometricAltitudeAccuracyReader {

  public static BarometricAltitudeAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.BAROMETRIC_ALTITUDE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.BAROMETRIC_ALTITUDE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.BAROMETRIC_ALTITUDE_DRN);

      BarometricAltitudeAccuracy barometricAltitudeAccuracy = new BarometricAltitudeAccuracy();
      int accuracyAltitudeValue = IntegerUtil.unsignedValueOf(uap.get(index));
      double accuracyAltitude = DecimalUtil.multiply(accuracyAltitudeValue, 0.25);

      barometricAltitudeAccuracy.setAccuracyAltitude(accuracyAltitude);

      return barometricAltitudeAccuracy;
    }
    return null;
  }
}
