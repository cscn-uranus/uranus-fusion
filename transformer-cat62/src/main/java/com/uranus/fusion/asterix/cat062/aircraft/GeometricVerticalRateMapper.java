package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricVerticalRate;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * GeometricVerticalRateMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class GeometricVerticalRateMapper {

  public static GeometricVerticalRate readGeometricVerticalRate(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.GEOMETRIC_VERTICAL_RATE_DRN);

      GeometricVerticalRate geometricVerticalRate = new GeometricVerticalRate();

      int geometricVerticalRateValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      geometricVerticalRate.setRate(DecimalUtil.multiply(geometricVerticalRateValue, 6.25));

      return geometricVerticalRate;
    }
    return null;
  }
}
