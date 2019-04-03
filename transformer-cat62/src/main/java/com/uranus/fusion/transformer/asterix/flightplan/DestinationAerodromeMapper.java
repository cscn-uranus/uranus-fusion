package com.uranus.fusion.transformer.asterix.flightplan;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.StringUtil;

import java.util.List;

/**
 * DestinationAerodromeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class DestinationAerodromeMapper {

  public static DestinationAerodrome readDestinationAirport(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 8;
    final int length = 4;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      DestinationAerodrome destinationAerodrome = new DestinationAerodrome();

      String character1 = StringUtil.asciiValueOf(uap.get(index));
      String character2 = StringUtil.asciiValueOf(uap.get(index + 1));
      String character3 = StringUtil.asciiValueOf(uap.get(index + 2));
      String character4 = StringUtil.asciiValueOf(uap.get(index + 3));

      String icaoName = character1 + character2 + character3 + character4;
      destinationAerodrome.setIcaoName(icaoName);
      return destinationAerodrome;
    }
    return null;
  }
}
