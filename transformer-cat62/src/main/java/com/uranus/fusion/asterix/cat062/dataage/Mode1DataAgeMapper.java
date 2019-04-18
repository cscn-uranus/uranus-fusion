package com.uranus.fusion.asterix.cat062.dataage;

import com.uranus.fusion.asterix.cat062.config.TrackDataAgeConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.track.DataAge;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
class Mode1DataAgeMapper {

  public static DataAge read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(TrackDataAgeConfig.MODE1_AGE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(TrackDataAgeConfig.MODE1_AGE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(TrackDataAgeConfig.MODE1_AGE_DRN);

      DataAge age = new DataAge();
      int ageValue = IntegerUtil.valueOf(uap.get(index));

      age.setAge(DecimalUtil.multiply(ageValue, 0.25));
      return age;
    }
    return null;
  }
}
