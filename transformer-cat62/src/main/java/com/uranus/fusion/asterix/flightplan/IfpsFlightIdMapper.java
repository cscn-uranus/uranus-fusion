package com.uranus.fusion.asterix.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.ByteUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;

/**
 * IfpsFlightIdMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class IfpsFlightIdMapper {

  public static IfpsFlightId read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 3;
    final int length = 4;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      IfpsFlightId ifpsFlightId = new IfpsFlightId();
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      String typBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (typBits) {
        case "00":
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.PLAN);
          break;
        case "01":
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.UNIT1);
          break;
        case "10":
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.UNIT2);
          break;
        case "11":
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.UNIT3);
          break;
        default:
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.PLAN);
          break;
      }

      String numberBits1 = ByteUtil.toString(uap.get(index)).substring(5, 8);
      Byte number1 = ByteUtil.valueOf(numberBits1);
      int number = IntegerUtil.valueOf(number1, uap.get(index + 1), uap.get(index + 2));
      ifpsFlightId.setNumber(number);

      return ifpsFlightId;

    }
    return null;
  }
}
