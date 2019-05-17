package com.uranus.fusion.common.asterix.cat062.mode5.sub;

import com.uranus.fusion.common.asterix.cat062.mode5.Mode5AndMode1Config;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.emitter.mode5.TimeOffset;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * TimeOffsetMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class TimeOffsetMapper {

  public static TimeOffset read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.TIME_OFFSET_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.TIME_OFFSET_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.TIME_OFFSET_DRN);

      TimeOffset timeOffset = new TimeOffset();

      int tosValue = IntegerUtil.unsignedValueOf(uap.get(index));
      double resolution = DecimalUtil.divide(1, 128);
      double offset = DecimalUtil.multiply(tosValue, resolution);
      timeOffset.setOffset(offset);

      return timeOffset;
    }
    return null;
  }
}
