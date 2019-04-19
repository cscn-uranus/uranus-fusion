package com.uranus.fusion.asterix.cat062.accuracy.sub;

import com.uranus.fusion.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.accuracy.CartesianAccelerationAccuracy;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * CartesianAccelerationAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class CartesianAccelerationAccuracyMapper {

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
