package com.uranus.transition.common.asterix.cat062.mode5;

import com.uranus.transition.common.asterix.cat062.mode5.Mode5AndMode1Config;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.emitter.mode1.ExtendedMode1Code;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
 class ExtendedMode1CodeReader {

  public static ExtendedMode1Code read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.EXTENDED_MODE1_CODE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.EXTENDED_MODE1_CODE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.EXTENDED_MODE1_CODE_DRN);

      ExtendedMode1Code extendedMode1Code = new ExtendedMode1Code();
      String codeBits =
          ByteUtil.toString(uap.get(index)).substring(3, 7) + ByteUtil.toString(uap.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);

      extendedMode1Code.setCode(code);

      return extendedMode1Code;
    }
    return null;
  }
}
