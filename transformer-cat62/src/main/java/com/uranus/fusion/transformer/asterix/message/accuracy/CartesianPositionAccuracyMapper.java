package com.uranus.fusion.transformer.asterix.message.accuracy;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * CartesianPositionAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/14
 */
public class CartesianPositionAccuracyMapper {

  public static CartesianPositionAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 1;
    final int size = 4;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

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
