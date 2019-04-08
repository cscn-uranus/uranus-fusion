package com.uranus.fusion.common.asterix.flightplan;

import com.uranus.fusion.common.asterix.SystemIdentifier;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;

import java.util.List;

/**
 * FppsIdentificationTagMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class FppsIdentificationTagMapper {

  public static SystemIdentifier read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 1;
    final int length = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      SystemIdentifier fppsIdentificationTag = new SystemIdentifier();
      int index = dataSpec.calculateOctetIndexByDrn(drn);
      String systemAreaCode = ByteUtil.toString(uap.get(index));
      String systemIdentityCode = ByteUtil.toString(uap.get(index + 1));

      fppsIdentificationTag.setSac(systemAreaCode);
      fppsIdentificationTag.setSic(systemIdentityCode);

      return fppsIdentificationTag;

    }
    return null;
  }
}
