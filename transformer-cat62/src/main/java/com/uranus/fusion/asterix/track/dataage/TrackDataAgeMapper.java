package com.uranus.fusion.asterix.track.dataage;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;
import java.util.List;

/**
 * TrackAngleAgeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
public class TrackDataAgeMapper {

  public static TrackDataAge readByDrn(List<Byte> uap, DataSpec dataSpec, int drn) {
    final int length = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      TrackDataAge age = new TrackDataAge();
      int mflValue = IntegerUtil.valueOf(uap.get(index));

      age.setAge(DecimalUtil.multiply(mflValue, 0.25));
      return age;

    }
    return null;
  }
}
