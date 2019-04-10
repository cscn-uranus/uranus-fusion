package com.uranus.fusion.asterix.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.StringUtil;

import java.util.List;

/**
 * AircraftTypeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class AircraftTypeMapper {

  public static AircraftType read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 5;
    final int length = 4;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      AircraftType aircraftType = new AircraftType();

      String character1 = StringUtil.asciiValueOf(uap.get(index));
      String character2 = StringUtil.asciiValueOf(uap.get(index + 1));
      String character3 = StringUtil.asciiValueOf(uap.get(index + 2));
      String character4 = StringUtil.asciiValueOf(uap.get(index + 3));

      String type = character1 + character2 + character3 + character4;
      aircraftType.setType(type);
      return aircraftType;

    }
    return null;
  }

}
