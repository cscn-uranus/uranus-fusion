package com.uranus.fusion.common.asterix.message.accuracy;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;
import java.util.List;

/**
 * GeometricAltitudeAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class GeometricAltitudeAccuracyMapper {

  public static GeometricAltitudeAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 4;
    final int size = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      GeometricAltitudeAccuracy geometricAltitudeAccuracy = new GeometricAltitudeAccuracy();

      int accuracyAltitudeValue = IntegerUtil.valueOf(uap.get(index));
      double accuracyAltitude = DecimalUtil.multiply(accuracyAltitudeValue, 6.25);
      geometricAltitudeAccuracy.setAccuracyAltitude(accuracyAltitude);

      return geometricAltitudeAccuracy;
    }
    return null;
  }

}
