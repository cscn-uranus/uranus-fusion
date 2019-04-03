package com.uranus.fusion.transformer.asterix.track;

import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import java.util.List;

/**
 * ComposedTrackNumberMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/8
 */
public class ComposedTrackNumberMapper {

  public static ComposedTrackNumber read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 26;
    final String zeroBit = "0";
    final int indexStep = 3;
    int size = 3;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      int index = fieldSpec.calculateOctetIndexByFrn(frn);
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
        if (zeroBit.equals(fx)) {
          break;
        }
        size += indexStep;
        index += indexStep;

      }
      fpIndicator.setSize(size);

      composedTrackNumber.setSystemUnitIdentification(systemUniIdentificationBuilder.toString());
      composedTrackNumber.setSystemTrackNumber(systemTrackNumberBuilder.toString());

      return composedTrackNumber;
    }
    return null;
  }
}
