package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.track.TrackNumber;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * TrackNumberMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
public class TrackNumberMapper {

  public static TrackNumber readTrackNumber(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.TRACK_NUMBER_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.TRACK_NUMBER_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TRACK_NUMBER_FRN);
      TrackNumber trackNumber = new TrackNumber();
      int number = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      trackNumber.setNumber(number);
      return trackNumber;
    }
    return null;
  }
}
