package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.BarometricVerticalRate;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * BarometricVerticalRateReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class BarometricVerticalRateReader {

  public static BarometricVerticalRate read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_DRN);

      BarometricVerticalRate barometricVerticalRate = new BarometricVerticalRate();

      int barometricVerticalRateValue =
          IntegerUtil.signedValueOf(uap.get(index), uap.get(index + 1));
      barometricVerticalRate.setRate(DecimalUtil.multiply(barometricVerticalRateValue, 6.25));

      return barometricVerticalRate;
    }
    return null;
  }
}
