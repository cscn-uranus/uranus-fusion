package com.uranus.fusion.common.asterix.cat062.dataage.sub;

import com.uranus.fusion.common.asterix.cat062.dataage.TrackDataAgeConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.track.DataAge;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public class BarometricPressureSettingDataAgeMapper {

  public static DataAge read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(TrackDataAgeConfig.BAROMETRIC_PRESSURE_SETTING_AGE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(TrackDataAgeConfig.BAROMETRIC_PRESSURE_SETTING_AGE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(TrackDataAgeConfig.BAROMETRIC_PRESSURE_SETTING_AGE_DRN);

      DataAge age = new DataAge();
      int ageValue = IntegerUtil.unsignedValueOf(uap.get(index));

      age.setAge(DecimalUtil.multiply(ageValue, 0.25));
      return age;
    }
    return null;
  }
}
