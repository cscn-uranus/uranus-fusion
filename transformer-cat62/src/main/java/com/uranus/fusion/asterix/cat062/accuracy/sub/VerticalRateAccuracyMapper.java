package com.uranus.fusion.asterix.cat062.accuracy.sub;

import com.uranus.fusion.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.accuracy.VerticalRateAccuracy;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * VerticalRateAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class VerticalRateAccuracyMapper {

  public static VerticalRateAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(EstimatedAccuracyConfig.VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.VERTICAL_RATE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.VERTICAL_RATE_DRN);

      VerticalRateAccuracy verticalRateAccuracy = new VerticalRateAccuracy();

      double rateAccuracy = DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index)), 6.25);

      verticalRateAccuracy.setRateAccuracy(rateAccuracy);

      return verticalRateAccuracy;
    }
    return null;
  }
}
