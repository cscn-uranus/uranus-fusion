package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.emitter.mode2.Mode2Code;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * TrackMode2CodeReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
public class TrackMode2CodeReader {

  public static Mode2Code read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.TRACK_MODE2_CODE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.TRACK_MODE2_CODE_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TRACK_MODE2_CODE_FRN);

      Mode2Code mode2Code = new Mode2Code();
      String codeBits =
          ByteUtil.toString(uap.get(index)).substring(3, 7) + ByteUtil.toString(uap.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);
      mode2Code.setCode(code);

      return mode2Code;
    }
    return null;
  }
}
