package com.uranus.fusion.common.asterix.aircraft.transponder.mode2;

import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.FpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.StringUtil;

import java.util.List;

/**
 * Mode2CodeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/14
 */
public class Mode2CodeMapper {

  public static Mode2Code read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 25;
    final int size = 2;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(size);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      Mode2Code mode2Code = new Mode2Code();

      String codeABits = ByteUtil.toString(uap.get(index)).substring(4, 7);
      String codeBBits =
          ByteUtil.toString(uap.get(index)).substring(7, 8) + ByteUtil.toString(uap.get(index + 1))
              .substring(0, 2);
      String codeCBits = ByteUtil.toString(uap.get(index + 1)).substring(2, 5);
      String codeDBits = ByteUtil.toString(uap.get(index + 1)).substring(5, 8);

      String codeA = StringUtil.asciiValueOf(ByteUtil.valueOf(codeABits));
      String codeB = StringUtil.asciiValueOf(ByteUtil.valueOf(codeBBits));
      String codeC = StringUtil.asciiValueOf(ByteUtil.valueOf(codeCBits));
      String codeD = StringUtil.asciiValueOf(ByteUtil.valueOf(codeDBits));

      String code = codeA + codeB + codeC + codeD;
      mode2Code.setCode(code);

      return mode2Code;

    }
    return null;
  }

}
