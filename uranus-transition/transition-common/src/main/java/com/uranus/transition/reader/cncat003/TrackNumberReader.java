package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.track.TrackNumber;
import com.uranus.transition.common.util.IntegerUtil;
import com.uranus.transition.reader.eucat062.EuCat062Config;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/8
 */
public class TrackNumberReader {

  public static TrackNumber read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.TRACK_NUMBER_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(CnCat003Config.TRACK_NUMBER_SIZE);

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.TRACK_NUMBER_FRN);
      TrackNumber trackNumber = new TrackNumber();
      int number = IntegerUtil.unsignedValueOf(message.get(index), message.get(index + 1));
      trackNumber.setNumber(number);
      return trackNumber;
    }
    return null;
  }
}
