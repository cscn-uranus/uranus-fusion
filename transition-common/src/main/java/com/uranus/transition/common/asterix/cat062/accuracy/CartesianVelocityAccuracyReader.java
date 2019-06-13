package com.uranus.transition.common.asterix.cat062.accuracy;

import com.uranus.transition.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.accuracy.CartesianVelocityAccuracy;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * CartesianVelocityAccuracyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class CartesianVelocityAccuracyReader {

  public static CartesianVelocityAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.CARTESIAN_VELOCITY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.CARTESIAN_VELOCITY_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.CARTESIAN_VELOCITY_DRN);

      CartesianVelocityAccuracy cartesianVelocityAccuracy = new CartesianVelocityAccuracy();

      double accuracyX = DecimalUtil.multiply(IntegerUtil.unsignedValueOf(uap.get(index)), 0.25);
      cartesianVelocityAccuracy.setAccuracyX(accuracyX);

      double accuracyY =
          DecimalUtil.multiply(IntegerUtil.unsignedValueOf(uap.get(index + 1)), 0.25);
      cartesianVelocityAccuracy.setAccuracyY(accuracyY);

      return cartesianVelocityAccuracy;
    }
    return null;
  }
}
