package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.track.TrackAccuracy;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/7/4
 */
public class TrackAccuracyReader {
  public static TrackAccuracy read(List<Byte> message, FieldSpec fieldSpec) {
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.TRACK_ACCURACY_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      int sizeCount = CnCat003Config.TRACK_ACCURACY_EX_SIZE;

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.TRACK_ACCURACY_FRN);
      TrackAccuracy trackAccuracy = new TrackAccuracy();

      StringBuilder accuracyBuilder = new StringBuilder();

      while (true) {
        String accuracyBit = ByteUtil.toString(message.get(index)).substring(0, 7);
        accuracyBuilder.append(accuracyBit);

        String fxBit = ByteUtil.toString(message.get(index)).substring(7, 8);
        if (ByteUtil.ZERO_BIT.equals(fxBit)) {
          trackAccuracy.setAccuracy(accuracyBuilder.toString());
          fpIndicator.setSize(sizeCount);
          return trackAccuracy;
        }
        sizeCount += CnCat003Config.TRACK_ACCURACY_EX_SIZE;
      }
    }
    return null;
  }
}
