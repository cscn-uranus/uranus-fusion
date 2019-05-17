package com.uranus.fusion.common.asterix.cat062.updateage.sub;

import com.uranus.fusion.common.asterix.cat062.updateage.SystemTrackUpdateAgeConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.track.UpdateAge;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * UpdateAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
public class AdscUpdateAgeMapper {

  public static UpdateAge read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(SystemTrackUpdateAgeConfig.ADSC_AGE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(SystemTrackUpdateAgeConfig.ADSC_AGE_DRN);
      UpdateAge updateAge = new UpdateAge();
      dpIndicator.setSize(SystemTrackUpdateAgeConfig.ADSC_AGE_SIZE);

      int ageValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      Double age = DecimalUtil.multiply(ageValue, 0.25);

      updateAge.setAge(age);
      return updateAge;
    }
    return null;
  }
}
