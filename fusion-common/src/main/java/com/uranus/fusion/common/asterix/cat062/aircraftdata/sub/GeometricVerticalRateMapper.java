package com.uranus.fusion.common.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.altitude.GeometricVerticalRate;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * GeometricVerticalRateMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class GeometricVerticalRateMapper {

  public static GeometricVerticalRate read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_DRN);

      GeometricVerticalRate geometricVerticalRate = new GeometricVerticalRate();

      int geometricVerticalRateValue =
          IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      geometricVerticalRate.setRate(DecimalUtil.multiply(geometricVerticalRateValue, 6.25));

      return geometricVerticalRate;
    }
    return null;
  }
}
