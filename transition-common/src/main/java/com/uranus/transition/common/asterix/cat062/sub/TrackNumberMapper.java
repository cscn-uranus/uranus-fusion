package com.uranus.transition.common.asterix.cat062.sub;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.track.TrackNumber;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackNumberMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
public class TrackNumberMapper {

  public static TrackNumber readTrackNumber(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.TRACK_NUMBER_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.TRACK_NUMBER_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TRACK_NUMBER_FRN);
      TrackNumber trackNumber = new TrackNumber();
      int number = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      trackNumber.setNumber(number);
      return trackNumber;
    }
    return null;
  }
}
