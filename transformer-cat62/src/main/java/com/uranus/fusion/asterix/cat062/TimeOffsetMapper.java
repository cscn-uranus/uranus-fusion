package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.emitter.mode5.TimeOffset;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * TimeOffsetMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class TimeOffsetMapper {

  public static TimeOffset read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 6;
    final int size = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      TimeOffset timeOffset = new TimeOffset();

      int tosValue = IntegerUtil.valueOf(uap.get(index));
      double resolution = DecimalUtil.divide(1, 128);
      double offset = DecimalUtil.multiply(tosValue, resolution);
      timeOffset.setOffset(offset);

      return timeOffset;
    }
    return null;
  }
}
