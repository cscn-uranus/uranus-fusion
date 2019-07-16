package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.track.TrackNumber;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackNumberReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
class TrackNumberReader {

  static TrackNumber readTrackNumber(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(EuCat062Config.TRACK_NUMBER_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(EuCat062Config.TRACK_NUMBER_SIZE);

      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.TRACK_NUMBER_FRN);
      TrackNumber trackNumber = new TrackNumber();
      int number = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      trackNumber.setNumber(number);
      return trackNumber;
    }
    return null;
  }
}
