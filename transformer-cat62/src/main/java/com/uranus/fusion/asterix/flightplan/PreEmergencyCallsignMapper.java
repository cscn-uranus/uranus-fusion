package com.uranus.fusion.asterix.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.StringUtil;

import java.util.List;

/**
 * PreEmergencyCallsignMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class PreEmergencyCallsignMapper {

  public static PreEmergencyCallsign read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 18;
    final int length = 7;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      PreEmergencyCallsign preEmergencyCallsign = new PreEmergencyCallsign();

      String character1 = StringUtil.asciiValueOf(uap.get(index));
      String character2 = StringUtil.asciiValueOf(uap.get(index + 1));
      String character3 = StringUtil.asciiValueOf(uap.get(index + 2));
      String character4 = StringUtil.asciiValueOf(uap.get(index + 3));
      String character5 = StringUtil.asciiValueOf(uap.get(index + 4));
      String character6 = StringUtil.asciiValueOf(uap.get(index + 5));
      String character7 = StringUtil.asciiValueOf(uap.get(index + 6));

      String sign =
          character1 + character2 + character3 + character4 + character5 + character6 + character7;
      preEmergencyCallsign.setSign(sign);
      return preEmergencyCallsign;
    }
    return null;
  }

}
