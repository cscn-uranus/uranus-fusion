package com.uranus.fusion.transformer.asterix.message.accuracy;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * CartesianVelocityAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class CartesianVelocityAccuracyMapper {

  public static CartesianVelocityAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 6;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

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
