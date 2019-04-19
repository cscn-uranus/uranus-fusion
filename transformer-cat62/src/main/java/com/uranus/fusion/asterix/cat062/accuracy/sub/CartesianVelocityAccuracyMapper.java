package com.uranus.fusion.asterix.cat062.accuracy.sub;

import com.uranus.fusion.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.accuracy.CartesianVelocityAccuracy;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * CartesianVelocityAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class CartesianVelocityAccuracyMapper {

  public static CartesianVelocityAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.CARTESIAN_VELOCITY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.CARTESIAN_VELOCITY_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.CARTESIAN_VELOCITY_DRN);

      CartesianVelocityAccuracy cartesianVelocityAccuracy = new CartesianVelocityAccuracy();

      double accuracyX = DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index)), 0.25);
      cartesianVelocityAccuracy.setAccuracyX(accuracyX);

      double accuracyY = DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index + 1)), 0.25);
      cartesianVelocityAccuracy.setAccuracyY(accuracyY);

      return cartesianVelocityAccuracy;
    }
    return null;
  }
}
