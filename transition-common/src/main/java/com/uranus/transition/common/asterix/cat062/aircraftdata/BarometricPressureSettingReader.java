package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.meteorology.BarometricPressureSetting;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * BarometricPressureSettingReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class BarometricPressureSettingReader {

  public static BarometricPressureSetting read(
      List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.BAROMETRIC_PRESSURE_SETTING_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index =
          dataSpec.calculateOctetIndexByDrn(
              AircraftDerivedDataConfig.BAROMETRIC_PRESSURE_SETTING_DRN);

      dpIndicator.setSize(AircraftDerivedDataConfig.BAROMETRIC_PRESSURE_SETTING_SIZE);

      BarometricPressureSetting barometricPressureSetting = new BarometricPressureSetting();
      int barometricPressureSettingValue =
          IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      barometricPressureSetting.setPressure(
          DecimalUtil.multiply(barometricPressureSettingValue, 0.1));
      return barometricPressureSetting;
    }
    return null;
  }
}
