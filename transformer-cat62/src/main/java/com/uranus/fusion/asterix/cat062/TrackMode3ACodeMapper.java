package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.emitter.mode3.CodeChangeStatusEnum;
import com.uranus.fusion.asterix.uap.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.fusion.asterix.uap.emitter.mode3.CodeValidatedStatusEnum;
import com.uranus.fusion.asterix.uap.emitter.mode3.Mode3Code;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * TrackMode3ACodeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class TrackMode3ACodeMapper {

  public static Mode3Code read(List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Track Mode 3/A Code: frn=9, size=2
    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.TRACK_MODE_3A_CODE_FRN);

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
          ByteUtil.toString(uapOctetList.get(index)).substring(4, 7)
              + ByteUtil.toString(uapOctetList.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);

      mode3Code.setCode(code);
      return mode3Code;
    }
    return null;
  }
}
