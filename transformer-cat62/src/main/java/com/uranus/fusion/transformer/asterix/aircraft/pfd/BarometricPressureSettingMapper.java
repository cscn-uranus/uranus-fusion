package com.uranus.fusion.transformer.asterix.aircraft.pfd;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * BarometricPressureSettingMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class BarometricPressureSettingMapper {

  public static BarometricPressureSetting readBarometricPressureSetting(
      List<Byte> uap, DataSpec dataSpec) {
    final int drn = 28;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(28);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      dpIndicator.setSize(2);

      BarometricPressureSetting barometricPressureSetting = new BarometricPressureSetting();
      int barometricPressureSettingValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      barometricPressureSetting.setPressure(
          DecimalUtil.multiply(barometricPressureSettingValue, 0.1));
      return barometricPressureSetting;
    }
    return null;
  }
}
