package com.uranus.fusion.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.ByteUtil;
import com.uranus.fusion.asterix.util.StringUtil;

import java.util.List;

/**
 * ExtendedMode1CodeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class ExtendedMode1CodeMapper {

  public static ExtendedMode1Code read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 5;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      ExtendedMode1Code extendedMode1Code = new ExtendedMode1Code();
      String codeABits = ByteUtil.toString(uap.get(index)).substring(4, 7);
      String codeBBits =
          ByteUtil.toString(uap.get(index)).substring(7, 8)
              + ByteUtil.toString(uap.get(index + 1)).substring(0, 2);
      String codeCBits = ByteUtil.toString(uap.get(index + 1)).substring(2, 5);
      String codeDBits = ByteUtil.toString(uap.get(index + 1)).substring(5, 8);

      String codeA = StringUtil.asciiValueOf(ByteUtil.valueOf(codeABits));
      String codeB = StringUtil.asciiValueOf(ByteUtil.valueOf(codeBBits));
      String codeC = StringUtil.asciiValueOf(ByteUtil.valueOf(codeCBits));
      String codeD = StringUtil.asciiValueOf(ByteUtil.valueOf(codeDBits));

      String code = codeA + codeB + codeC + codeD;

      extendedMode1Code.setCode(code);

      return extendedMode1Code;
    }
    return null;
  }
}
