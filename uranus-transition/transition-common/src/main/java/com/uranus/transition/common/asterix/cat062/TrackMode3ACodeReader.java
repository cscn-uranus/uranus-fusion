package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeChangeStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeValidatedStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.Mode3Code;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * TrackMode3ACodeReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class TrackMode3ACodeReader {

  public static Mode3Code read(List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Track Mode 3/A Code: frn=9, size=2
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.TRACK_MODE_3A_CODE_FRN);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.TRACK_MODE_3A_CODE_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TRACK_MODE_3A_CODE_FRN);
      Mode3Code mode3Code = new Mode3Code();
      String codeValidatedBit = ByteUtil.getBitByIndex(uapOctetList.get(index), 0);
      String codeGarbledBit = ByteUtil.getBitByIndex(uapOctetList.get(index), 1);
      String codeChangedBit = ByteUtil.getBitByIndex(uapOctetList.get(index), 2);

      mode3Code.setCodeValidatedStatusEnum(
          ByteUtil.ZERO_BIT.equals(codeValidatedBit)
              ? CodeValidatedStatusEnum.VALIDATED
              : CodeValidatedStatusEnum.NOT_VALIDATED);

      mode3Code.setCodeGarbledStatusEnum(
          ByteUtil.ZERO_BIT.equals(codeGarbledBit)
              ? CodeGarbledStatusEnum.DEFAULT
              : CodeGarbledStatusEnum.GARBLED);

      mode3Code.setCodeChangeStatusEnum(
          ByteUtil.ZERO_BIT.equals(codeChangedBit)
              ? CodeChangeStatusEnum.NO_CHANGE
              : CodeChangeStatusEnum.CHANGED);

      String codeBits =
          ByteUtil.toString(uapOctetList.get(index)).substring(3, 7)
              + ByteUtil.toString(uapOctetList.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);

      mode3Code.setCode(code);
      return mode3Code;
    }
    return null;
  }
}
