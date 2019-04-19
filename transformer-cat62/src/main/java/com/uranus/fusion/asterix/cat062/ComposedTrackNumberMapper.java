package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.track.ComposedTrackNumber;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * ComposedTrackNumberMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
public class ComposedTrackNumberMapper {

  public static ComposedTrackNumber read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.COMPOSED_TRACK_NUMBER_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.COMPOSED_TRACK_NUMBER_FRN);
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
        sizeCount += Cat062Config.COMPOSED_TRACK_NUMBER_EX_SIZE;
        index += Cat062Config.COMPOSED_TRACK_NUMBER_EX_SIZE;
      }
      fpIndicator.setSize(sizeCount);

      composedTrackNumber.setSystemUnitIdentification(systemUniIdentificationBuilder.toString());
      composedTrackNumber.setSystemTrackNumber(systemTrackNumberBuilder.toString());

      return composedTrackNumber;
    }
    return null;
  }
}
