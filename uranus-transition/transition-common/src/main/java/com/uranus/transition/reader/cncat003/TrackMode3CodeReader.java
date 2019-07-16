package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode2.Mode2Code;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeSourceTypeEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeValidatedStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.Mode3Code;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/14
 */
public class TrackMode3CodeReader {

  public static Mode3Code read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.TRACK_MODE_3A_CODE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(CnCat003Config.TRACK_MODE_3A_CODE_SIZE);

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.TRACK_MODE_3A_CODE_FRN);

      Mode3Code mode3Code = new Mode3Code();

      String vBit = ByteUtil.toString(message.get(index)).substring(0,1);
      mode3Code.setCodeValidatedStatusEnum(
        ByteUtil.ZERO_BIT.equals(vBit)? CodeValidatedStatusEnum.VALIDATED:CodeValidatedStatusEnum.NOT_VALIDATED
      );

      String gBit = ByteUtil.toString(message.get(index)).substring(1,2);
      mode3Code.setCodeGarbledStatusEnum(
        ByteUtil.ZERO_BIT.equals(gBit)? CodeGarbledStatusEnum.DEFAULT:CodeGarbledStatusEnum.GARBLED
      );

      String lBit = ByteUtil.toString(message.get(index)).substring(2,3);
      mode3Code.setCodeSourceTypeEnum(
        ByteUtil.ZERO_BIT.equals(lBit)? CodeSourceTypeEnum.DERIVED:CodeSourceTypeEnum.SMOOTHED
      );

      String codeBits =
          ByteUtil.toString(message.get(index)).substring(4, 8) + ByteUtil.toString(message.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);
      mode3Code.setCode(code);

      return mode3Code;
    }
    return null;
  }
}
