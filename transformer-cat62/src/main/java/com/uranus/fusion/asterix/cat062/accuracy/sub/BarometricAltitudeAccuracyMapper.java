package com.uranus.fusion.asterix.cat062.accuracy.sub;

import com.uranus.fusion.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.accuracy.BarometricAltitudeAccuracy;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

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
      int accuracyAltitudeValue = IntegerUtil.valueOf(uap.get(index));
      double accuracyAltitude = DecimalUtil.multiply(accuracyAltitudeValue, 0.25);

      barometricAltitudeAccuracy.setAccuracyAltitude(accuracyAltitude);

      return barometricAltitudeAccuracy;
    }
    return null;
  }
}
