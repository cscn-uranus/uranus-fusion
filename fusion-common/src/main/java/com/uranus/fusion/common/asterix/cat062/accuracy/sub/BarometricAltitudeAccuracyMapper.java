package com.uranus.fusion.common.asterix.cat062.accuracy.sub;

import com.uranus.fusion.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.accuracy.BarometricAltitudeAccuracy;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * BarometricAltitudeAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class BarometricAltitudeAccuracyMapper {

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
