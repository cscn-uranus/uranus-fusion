package com.uranus.fusion.asterix.accuracy;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;
import java.util.List;

/**
 * CartesianAccelerationAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class CartesianAccelerationAccuracyMapper {

  public static CartesianAccelerationAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 7;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      CartesianAccelerationAccuracy cartesianAccelerationAccuracy =
          new CartesianAccelerationAccuracy();

      double accuracyAccelerationX =
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index)), 0.25);
      cartesianAccelerationAccuracy.setAccuracyX(accuracyAccelerationX);

      double accuracyAccelerationY =
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index + 1)), 0.25);
      cartesianAccelerationAccuracy.setAccuracyY(accuracyAccelerationY);

      return cartesianAccelerationAccuracy;
    }
    return null;
  }
}
