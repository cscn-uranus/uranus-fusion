package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.track.ComposedTrackNumber;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * ComposedTrackNumberReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
class ComposedTrackNumberReader {

  static ComposedTrackNumber read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.COMPOSED_TRACK_NUMBER_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.COMPOSED_TRACK_NUMBER_FRN);
      int sizeCount = 0;
      ComposedTrackNumber composedTrackNumber = new ComposedTrackNumber();

      StringBuilder systemUniIdentificationBuilder = new StringBuilder();
      StringBuilder systemTrackNumberBuilder = new StringBuilder();
      while (true) {

        String suiBits = ByteUtil.toString(uap.get(index));
        systemUniIdentificationBuilder.append(suiBits);

        String stnBits =
            ByteUtil.toString(uap.get(index + 1))
                + ByteUtil.toString(uap.get(index + 2)).substring(0, 7);
        systemTrackNumberBuilder.append(stnBits);

        String fx = ByteUtil.toString(uap.get(index + 2)).substring(7, 8);
        if (ByteUtil.ZERO_BIT.equals(fx)) {
          break;
        }
        sizeCount += EuCat062Config.COMPOSED_TRACK_NUMBER_EX_SIZE;
        index += EuCat062Config.COMPOSED_TRACK_NUMBER_EX_SIZE;
      }
      fpIndicator.setSize(sizeCount);

      composedTrackNumber.setSystemUnitIdentification(systemUniIdentificationBuilder.toString());
      composedTrackNumber.setSystemTrackNumber(systemTrackNumberBuilder.toString());

      return composedTrackNumber;
    }
    return null;
  }
}
