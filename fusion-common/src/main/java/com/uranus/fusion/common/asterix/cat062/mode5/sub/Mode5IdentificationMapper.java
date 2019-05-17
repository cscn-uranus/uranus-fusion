package com.uranus.fusion.common.asterix.cat062.mode5.sub;

import com.uranus.fusion.common.asterix.cat062.mode5.Mode5AndMode1Config;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.emitter.mode5.Mode5Identification;
import com.uranus.fusion.common.util.ByteUtil;

import java.util.List;

/**
 * Mode5IdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class Mode5IdentificationMapper {

  public static Mode5Identification read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.MODE5_IDENTIFICATION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.MODE5_IDENTIFICATION_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.MODE5_IDENTIFICATION_DRN);

      Mode5Identification mode5Identification = new Mode5Identification();

      String pin =
          ByteUtil.toString(message.get(index)).substring(2, 8)
              + ByteUtil.toString(message.get(index + 1));
      mode5Identification.setPin(pin);

      String nationalOrigin = ByteUtil.toString(message.get(index + 2)).substring(3, 8);
      mode5Identification.setNationalOrigin(nationalOrigin);

      String missionCode = ByteUtil.toString(message.get(index + 3)).substring(2, 8);
      mode5Identification.setMissionCode(missionCode);

      return mode5Identification;
    }
    return null;
  }
}
