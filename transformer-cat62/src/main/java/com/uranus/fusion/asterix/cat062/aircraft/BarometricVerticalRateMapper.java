package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.altitude.BarometricVerticalRate;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * BarometricVerticalRateMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class BarometricVerticalRateMapper {

  public static BarometricVerticalRate readBarometricVerticalRate(
      List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.BAROMETRIC_VERTICAL_RATE_DRN);

      BarometricVerticalRate barometricVerticalRate = new BarometricVerticalRate();

      int barometricVerticalRateValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      barometricVerticalRate.setRate(DecimalUtil.multiply(barometricVerticalRateValue, 6.25));

      return barometricVerticalRate;
    }
    return null;
  }
}
