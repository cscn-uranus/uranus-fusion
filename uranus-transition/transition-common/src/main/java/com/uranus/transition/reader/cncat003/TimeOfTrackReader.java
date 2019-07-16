package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.track.TimeOfTrack;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2019/7/4
 */
public class TimeOfTrackReader {

  public static TimeOfTrack read(List<Byte> message, FieldSpec fieldSpec) {
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.TIME_OF_TRACK_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      // 固定长度
      fpIndicator.setSize(CnCat003Config.TIME_OF_TRACK_SIZE);
      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.TIME_OF_TRACK_FRN);

      TimeOfTrack timeOfTrack = new TimeOfTrack();
      double timeValue =
          IntegerUtil.unsignedValueOf(
              message.get(index), message.get(index + 1), message.get(index + 2));

      double resolution = DecimalUtil.divide(1, 128);
      double time = DecimalUtil.multiply(timeValue, resolution);
      timeOfTrack.setTime(time);

      return timeOfTrack;
    }
    return null;
  }
}
