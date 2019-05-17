package com.uranus.fusion.common.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.altitude.BarometricVerticalRate;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * BarometricVerticalRateMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class BarometricVerticalRateMapper {

  public static BarometricVerticalRate read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_DRN);

      BarometricVerticalRate barometricVerticalRate = new BarometricVerticalRate();

      int barometricVerticalRateValue =
          IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      barometricVerticalRate.setRate(DecimalUtil.multiply(barometricVerticalRateValue, 6.25));

      return barometricVerticalRate;
    }
    return null;
  }
}
