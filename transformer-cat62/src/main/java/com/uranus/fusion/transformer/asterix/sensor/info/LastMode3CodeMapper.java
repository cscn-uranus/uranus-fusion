package com.uranus.fusion.transformer.asterix.sensor.info;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeGarbledStatusEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeSourceTypeEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeValidatedStatusEnum;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import com.uranus.fusion.transformer.asterix.util.StringUtil;
import java.util.List;

/**
 * LastMode3CodeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class LastMode3CodeMapper {

  public static LastMode3Code read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 5;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      LastMode3Code lastMode3Code = new LastMode3Code();

      String vBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      lastMode3Code.setCodeValidatedStatusEnum(
          zeroBit.equals(vBit) ? CodeValidatedStatusEnum.VALIDATED
              : CodeValidatedStatusEnum.NOT_VALIDATED);

      String gBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      lastMode3Code.setCodeGarbledStatusEnum(
          zeroBit.equals(gBit) ? CodeGarbledStatusEnum.DEFAULT : CodeGarbledStatusEnum.GARBLED);

      String lBit = ByteUtil.toString(uap.get(index)).substring(2, 3);
      lastMode3Code.setCodeSourceTypeEnum(
          zeroBit.equals(lBit) ? CodeSourceTypeEnum.DERIVED : CodeSourceTypeEnum.SMOOTHED);

      String codeABits = ByteUtil.toString(uap.get(index)).substring(4, 7);
      String codeBBits =
          ByteUtil.toString(uap.get(index)).substring(7, 8)
              + ByteUtil.toString(uap.get(index + 1)).substring(0, 2);
      String codeCBits = ByteUtil.toString(uap.get(index + 1)).substring(2, 5);
      String codeDBits = ByteUtil.toString(uap.get(index + 1)).substring(5, 8);

      int codeA = IntegerUtil.valueOf(ByteUtil.valueOf(codeABits));
      int codeB = IntegerUtil.valueOf(ByteUtil.valueOf(codeBBits));
      int codeC = IntegerUtil.valueOf(ByteUtil.valueOf(codeCBits));
      int codeD = IntegerUtil.valueOf(ByteUtil.valueOf(codeDBits));

      String code = StringUtil.valueOf(codeA,codeB,codeC,codeD);

      lastMode3Code.setCode(code);

      return lastMode3Code;
    }
    return null;
  }
}
