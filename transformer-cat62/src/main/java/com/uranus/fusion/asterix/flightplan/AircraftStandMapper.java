package com.uranus.fusion.asterix.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.StringUtil;

import java.util.List;

/**
 * AircraftStandMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class AircraftStandMapper {

  public static AircraftStand read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 13;
    final int length = 6;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      AircraftStand aircraftStand = new AircraftStand();

      String character1 = StringUtil.asciiValueOf(uap.get(index));
      String character2 = StringUtil.asciiValueOf(uap.get(index + 1));
      String character3 = StringUtil.asciiValueOf(uap.get(index + 2));
      String character4 = StringUtil.asciiValueOf(uap.get(index + 3));
      String character5 = StringUtil.asciiValueOf(uap.get(index + 4));
      String character6 = StringUtil.asciiValueOf(uap.get(index + 5));

      String stand = character1 + character2 + character3 + character4 + character5 + character6;
      aircraftStand.setStand(stand);
      return aircraftStand;

    }
    return null;
  }

}
