package com.uranus.fusion.common.asterix.message.accuracy;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;
import java.util.List;

/**
 * VerticalRateAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class VerticalRateAccuracyMapper {

  public static VerticalRateAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 8;
    final int size = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      VerticalRateAccuracy verticalRateAccuracy = new VerticalRateAccuracy();

      double rateAccuracy = DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index)), 6.25);

      verticalRateAccuracy.setRateAccuracy(rateAccuracy);

      return verticalRateAccuracy;

    }
    return null;
  }

}
