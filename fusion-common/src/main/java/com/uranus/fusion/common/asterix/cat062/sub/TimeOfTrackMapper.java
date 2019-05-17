package com.uranus.fusion.common.asterix.cat062.sub;

import com.uranus.fusion.common.asterix.cat062.Cat062Config;
import com.uranus.fusion.common.asterix.spec.FieldSpec;
import com.uranus.fusion.common.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.FpIndicator;
import com.uranus.fusion.common.asterix.uap.track.TimeOfTrack;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * TimeOfTrackMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class TimeOfTrackMapper {

  public static TimeOfTrack read(List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Time Of Track Information: frn=4, size=3
    final int frn = Cat062Config.TIME_OF_TRACK_INFORMATION_FRN;
    final int size = Cat062Config.TIME_OF_TRACK_INFORMATION_SIZE;

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      // 固定长度
      fpIndicator.setSize(size);
      int index = fieldSpec.calculateIndexByFrn(frn);

      TimeOfTrack timeOfTrack = new TimeOfTrack();
      double timeValue =
          IntegerUtil.unsignedValueOf(
              uapOctetList.get(index), uapOctetList.get(index + 1), uapOctetList.get(index + 2));

      double resolution = DecimalUtil.divide(1, 128);
      double time = DecimalUtil.multiply(timeValue, resolution);
      timeOfTrack.setTime(time);

      return timeOfTrack;
    }
    return null;
  }
}
