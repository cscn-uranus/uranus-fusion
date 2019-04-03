package com.uranus.fusion.transformer.asterix.aircraft.pfd;

import com.uranus.fusion.transformer.asterix.measure.BarometricVerticalRate;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * BarometricVerticalRateMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class BarometricVerticalRateMapper {

  public static BarometricVerticalRate readBarometricVerticalRate(
      List<Byte> uap, DataSpec dataSpec) {
    final int drn = 13;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(2);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      BarometricVerticalRate barometricVerticalRate = new BarometricVerticalRate();

      int barometricVerticalRateValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      barometricVerticalRate.setRate(DecimalUtil.multiply(barometricVerticalRateValue, 6.25));

      return barometricVerticalRate;
    }
    return null;
  }
}
