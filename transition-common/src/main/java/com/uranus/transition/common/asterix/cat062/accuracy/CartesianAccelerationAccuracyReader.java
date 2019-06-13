package com.uranus.transition.common.asterix.cat062.accuracy;

import com.uranus.transition.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.accuracy.CartesianAccelerationAccuracy;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * CartesianAccelerationAccuracyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class CartesianAccelerationAccuracyReader {

  public static CartesianAccelerationAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.CARTESIAN_ACCELERATION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.CARTESIAN_ACCELERATION_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.CARTESIAN_ACCELERATION_DRN);

      CartesianAccelerationAccuracy cartesianAccelerationAccuracy =
          new CartesianAccelerationAccuracy();

      double accuracyAccelerationX =
          DecimalUtil.multiply(IntegerUtil.unsignedValueOf(uap.get(index)), 0.25);
      cartesianAccelerationAccuracy.setAccuracyX(accuracyAccelerationX);

      double accuracyAccelerationY =
          DecimalUtil.multiply(IntegerUtil.unsignedValueOf(uap.get(index + 1)), 0.25);
      cartesianAccelerationAccuracy.setAccuracyY(accuracyAccelerationY);

      return cartesianAccelerationAccuracy;
    }
    return null;
  }
}
