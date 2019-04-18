package com.uranus.fusion.asterix.cat062.updateage;

import com.uranus.fusion.asterix.cat062.config.SystemTrackUpdateAgeConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.track.UpdateAge;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * UpdateAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
public class ModeSelUpdateAgeMapper {

  public static UpdateAge read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(SystemTrackUpdateAgeConfig.MODE_SEL_AGE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(SystemTrackUpdateAgeConfig.MODE_SEL_AGE_DRN);
      UpdateAge updateAge = new UpdateAge();

      dpIndicator.setSize(SystemTrackUpdateAgeConfig.MODE_SEL_AGE_SIZE);

      int ageValue = IntegerUtil.valueOf(uap.get(index));
      Double age = DecimalUtil.multiply(ageValue, 0.25);

      updateAge.setAge(age);
      return updateAge;
    }
    return null;
  }
}
