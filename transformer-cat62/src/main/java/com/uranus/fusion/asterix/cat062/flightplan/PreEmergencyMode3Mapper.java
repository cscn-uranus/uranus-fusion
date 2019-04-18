package com.uranus.fusion.asterix.cat062.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.datainfo.DataValidEnum;
import com.uranus.fusion.asterix.uap.emitter.mode3.PreEmergencyMode3;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.IntegerUtil;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * PreEmergencyMode3Mapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class PreEmergencyMode3Mapper {

  public static PreEmergencyMode3 read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 17;
    final int length = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      PreEmergencyMode3 preEmergencyMode3 = new PreEmergencyMode3();

      String vaBit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      preEmergencyMode3.setDataValidEnum(
          zeroBit.equals(vaBit) ? DataValidEnum.NOT_VALID : DataValidEnum.VALID);

      String codeBitsA = ByteUtil.toString(uap.get(index)).substring(4, 7);
      String codeBitsB =
          ByteUtil.toString(uap.get(index)).substring(7, 8)
              + ByteUtil.toString(uap.get(index + 1)).substring(0, 2);
      String codeBitsC = ByteUtil.toString(uap.get(index + 1)).substring(2, 5);
      String codeBitsD = ByteUtil.toString(uap.get(index + 1)).substring(5, 8);

      int codeA = IntegerUtil.valueOf(ByteUtil.valueOf(codeBitsA));
      int codeB = IntegerUtil.valueOf(ByteUtil.valueOf(codeBitsB));
      int codeC = IntegerUtil.valueOf(ByteUtil.valueOf(codeBitsC));
      int codeD = IntegerUtil.valueOf(ByteUtil.valueOf(codeBitsD));

      String code =
          StringUtil.valueOf(codeA)
              + StringUtil.valueOf(codeB)
              + StringUtil.valueOf(codeC)
              + StringUtil.valueOf(codeD);

      preEmergencyMode3.setCode(code);
      return preEmergencyMode3;
    }
    return null;
  }
}
