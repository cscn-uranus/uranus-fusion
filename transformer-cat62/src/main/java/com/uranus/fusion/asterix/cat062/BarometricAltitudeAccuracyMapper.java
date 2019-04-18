package com.uranus.fusion.asterix.cat062;

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
    final int drn = 5;
    final int size = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      BarometricAltitudeAccuracy barometricAltitudeAccuracy = new BarometricAltitudeAccuracy();
      int accuracyAltitudeValue = IntegerUtil.valueOf(uap.get(index));
      double accuracyAltitude = DecimalUtil.multiply(accuracyAltitudeValue, 0.25);

      barometricAltitudeAccuracy.setAccuracyAltitude(accuracyAltitude);

      return barometricAltitudeAccuracy;
    }
    return null;
  }
}
