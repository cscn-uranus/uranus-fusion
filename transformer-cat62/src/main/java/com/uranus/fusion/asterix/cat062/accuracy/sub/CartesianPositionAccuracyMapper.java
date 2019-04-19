package com.uranus.fusion.asterix.cat062.accuracy.sub;

import com.uranus.fusion.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.accuracy.CartesianPositionAccuracy;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * CartesianPositionAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
public class CartesianPositionAccuracyMapper {

  public static CartesianPositionAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.CARTESIAN_POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.CARTESIAN_POSITION_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.CARTESIAN_POSITION_DRN);

      CartesianPositionAccuracy cartesianPositionAccuracy = new CartesianPositionAccuracy();

      double accuracyX =
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index), uap.get(index + 1)), 0.5);
      cartesianPositionAccuracy.setAccuracyX(accuracyX);

      double accuracyY =
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index + 2), uap.get(index + 3)), 0.5);
      cartesianPositionAccuracy.setAccuracyY(accuracyY);

      return new CartesianPositionAccuracy();
    }
    return null;
  }
}
