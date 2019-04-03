package com.uranus.fusion.transformer.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * TimeOffsetMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
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
