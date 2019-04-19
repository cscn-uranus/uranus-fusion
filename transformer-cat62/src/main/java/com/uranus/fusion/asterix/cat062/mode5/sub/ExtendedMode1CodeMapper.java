package com.uranus.fusion.asterix.cat062.mode5.sub;

import com.uranus.fusion.asterix.cat062.mode5.Mode5AndMode1Config;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.emitter.mode1.ExtendedMode1Code;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * ExtendedMode1CodeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class ExtendedMode1CodeMapper {

  public static ExtendedMode1Code read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.EXTENDED_MODE1_CODE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.EXTENDED_MODE1_CODE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.EXTENDED_MODE1_CODE_DRN);

      ExtendedMode1Code extendedMode1Code = new ExtendedMode1Code();
      String codeBits =
          ByteUtil.toString(uap.get(index)).substring(4, 7) + ByteUtil.toString(uap.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);

      extendedMode1Code.setCode(code);

      return extendedMode1Code;
    }
    return null;
  }
}
