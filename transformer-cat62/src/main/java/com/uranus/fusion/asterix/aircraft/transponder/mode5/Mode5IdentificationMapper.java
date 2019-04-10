package com.uranus.fusion.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.ByteUtil;

import java.util.List;

/**
 * Mode5IdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5IdentificationMapper {

  public static Mode5Identification read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 2;
    final int size = 4;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      Mode5Identification mode5Identification = new Mode5Identification();

      String pin =
          ByteUtil.toString(uap.get(index)).substring(2, 8) + ByteUtil.toString(uap.get(index + 1));
      mode5Identification.setPin(pin);

      String nationalOrigin = ByteUtil.toString(uap.get(index + 2)).substring(3, 8);
      mode5Identification.setNationalOrigin(nationalOrigin);

      String missionCode = ByteUtil.toString(uap.get(index + 3)).substring(2, 8);
      mode5Identification.setMissionCode(missionCode);

      return mode5Identification;
    }
    return null;
  }
}
