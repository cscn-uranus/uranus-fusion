package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.altitude.GeometricVerticalRate;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class GeometricVerticalRateReader {

  public static GeometricVerticalRate read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_DRN);

      GeometricVerticalRate geometricVerticalRate = new GeometricVerticalRate();

      int geometricVerticalRateValue =
          IntegerUtil.signedValueOf(uap.get(index), uap.get(index + 1));
      geometricVerticalRate.setRate(DecimalUtil.multiply(geometricVerticalRateValue, 6.25));

      return geometricVerticalRate;
    }
    return null;
  }
}
