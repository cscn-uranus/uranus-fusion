package com.uranus.transition.common.asterix.cat062.accuracy;

import com.uranus.transition.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.accuracy.CartesianPositionAccuracy;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * CartesianPositionAccuracyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
class CartesianPositionAccuracyReader {

  public static CartesianPositionAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.CARTESIAN_POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.CARTESIAN_POSITION_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.CARTESIAN_POSITION_DRN);

      CartesianPositionAccuracy cartesianPositionAccuracy = new CartesianPositionAccuracy();

      double accuracyX =
          DecimalUtil.multiply(
              IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1)), 0.5);
      cartesianPositionAccuracy.setAccuracyX(accuracyX);

      double accuracyY =
          DecimalUtil.multiply(
              IntegerUtil.unsignedValueOf(uap.get(index + 2), uap.get(index + 3)), 0.5);
      cartesianPositionAccuracy.setAccuracyY(accuracyY);

      return new CartesianPositionAccuracy();
    }
    return null;
  }
}
