package com.uranus.fusion.transformer.asterix.track;

import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * TrackNumberMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/8
 */
public class TrackNumberMapper {

  public static TrackNumber readTrackNumber(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 12;
    final int length = 2;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);
      TrackNumber trackNumber = new TrackNumber();
      int number = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      trackNumber.setNumber(number);
      return trackNumber;
    }
    return null;
  }
}
