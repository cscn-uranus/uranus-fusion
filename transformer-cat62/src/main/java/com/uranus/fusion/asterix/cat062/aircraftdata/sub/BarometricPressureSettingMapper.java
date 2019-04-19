package com.uranus.fusion.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.meteorology.BarometricPressureSetting;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * BarometricPressureSettingMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class BarometricPressureSettingMapper {

  public static BarometricPressureSetting readBarometricPressureSetting(
      List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.BAROMETRIC_PRESSURE_SETTING_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index =
          dataSpec.calculateOctetIndexByDrn(
              AircraftDerivedDataConfig.BAROMETRIC_PRESSURE_SETTING_DRN);

      dpIndicator.setSize(AircraftDerivedDataConfig.BAROMETRIC_PRESSURE_SETTING_SIZE);

      BarometricPressureSetting barometricPressureSetting = new BarometricPressureSetting();
      int barometricPressureSettingValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      barometricPressureSetting.setPressure(
          DecimalUtil.multiply(barometricPressureSettingValue, 0.1));
      return barometricPressureSetting;
    }
    return null;
  }
}
