package com.uranus.transition.reader.eucat062.dataage;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.track.DataAge;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
 class GeometricalVerticalRateDataAgeReader {

  public static DataAge read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(TrackDataAgeConfig.GEOMETRIC_VERTICAL_RATE_AGE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(TrackDataAgeConfig.GEOMETRIC_VERTICAL_RATE_AGE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(TrackDataAgeConfig.GEOMETRIC_VERTICAL_RATE_AGE_DRN);

      DataAge age = new DataAge();
      int ageValue = IntegerUtil.unsignedValueOf(uap.get(index));

      age.setAge(DecimalUtil.multiply(ageValue, 0.25));
      return age;
    }
    return null;
  }
}
