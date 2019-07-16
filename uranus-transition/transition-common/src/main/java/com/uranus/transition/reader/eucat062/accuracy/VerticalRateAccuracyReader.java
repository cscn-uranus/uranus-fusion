package com.uranus.transition.reader.eucat062.accuracy;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.accuracy.VerticalRateAccuracy;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * VerticalRateAccuracyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class VerticalRateAccuracyReader {

  public static VerticalRateAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(EstimatedAccuracyConfig.VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.VERTICAL_RATE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.VERTICAL_RATE_DRN);

      VerticalRateAccuracy verticalRateAccuracy = new VerticalRateAccuracy();

      double rateAccuracy = DecimalUtil.multiply(IntegerUtil.unsignedValueOf(uap.get(index)), 6.25);

      verticalRateAccuracy.setRateAccuracy(rateAccuracy);

      return verticalRateAccuracy;
    }
    return null;
  }
}
