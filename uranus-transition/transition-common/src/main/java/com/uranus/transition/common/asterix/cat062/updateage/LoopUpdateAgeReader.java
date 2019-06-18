package com.uranus.transition.common.asterix.cat062.updateage;

import com.uranus.transition.common.asterix.cat062.updateage.SystemTrackUpdateAgeConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.track.UpdateAge;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * UpdateAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
 class LoopUpdateAgeReader {

  public static UpdateAge read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(SystemTrackUpdateAgeConfig.LOOP_AGE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(SystemTrackUpdateAgeConfig.LOOP_AGE_DRN);
      UpdateAge updateAge = new UpdateAge();

      dpIndicator.setSize(SystemTrackUpdateAgeConfig.LOOP_AGE_SIZE);

      int ageValue = IntegerUtil.unsignedValueOf(uap.get(index));
      Double age = DecimalUtil.multiply(ageValue, 0.25);

      updateAge.setAge(age);
      return updateAge;
    }
    return null;
  }
}
