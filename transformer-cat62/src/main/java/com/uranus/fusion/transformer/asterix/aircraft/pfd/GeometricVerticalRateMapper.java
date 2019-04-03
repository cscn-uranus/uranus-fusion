package com.uranus.fusion.transformer.asterix.aircraft.pfd;

import com.uranus.fusion.transformer.asterix.measure.GeometricVerticalRate;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * GeometricVerticalRateMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class GeometricVerticalRateMapper {

  public static GeometricVerticalRate readGeometricVerticalRate(
      List<Byte> uap, DataSpec dataSpec) {
    final int drn = 14;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(2);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      GeometricVerticalRate geometricVerticalRate = new GeometricVerticalRate();

      int geometricVerticalRateValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      geometricVerticalRate.setRate(DecimalUtil.multiply(geometricVerticalRateValue, 6.25));

      return geometricVerticalRate;
    }
    return null;
  }
}
