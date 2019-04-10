package com.uranus.fusion.asterix;

import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;

/**
 * TrackTimeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class TrackTimeMapper {

  public static TimeOfTrack readTimeOfTrackInformation(List<Byte> uapOctetList,
      FieldSpec fieldSpec) {
    // Time Of Track Information frn=4
    final int frn = 4;
    final int length = 3;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      // 固定长度
      fpIndicator.setSize(length);
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      TimeOfTrack timeOfTrack = new TimeOfTrack();
      double timeValue =
          IntegerUtil.valueOf(
              uapOctetList.get(index), uapOctetList.get(index + 1), uapOctetList.get(index + 2));

      double resolution = DecimalUtil.divide(1, 128);
      double time = DecimalUtil.multiply(timeValue, resolution);
      timeOfTrack.setTime(time);

      return timeOfTrack;
    }
    return null;
  }
}
