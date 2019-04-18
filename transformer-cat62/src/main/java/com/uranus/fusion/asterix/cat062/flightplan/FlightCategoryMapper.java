package com.uranus.fusion.asterix.cat062.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.*;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * FlightCategoryMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public class FlightCategoryMapper {

  public static FlightCategory read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 4;
    final int length = 1;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      FlightCategory flightCategory = new FlightCategory();
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      String airTrafficBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (airTrafficBits) {
        case "00":
          flightCategory.setAirTrafficEnum(AirTrafficEnum.UNKNOWN);
          break;
        case "01":
          flightCategory.setAirTrafficEnum(AirTrafficEnum.GENERAL);
          break;
        case "10":
          flightCategory.setAirTrafficEnum(AirTrafficEnum.OPERATIONAL);
          break;
        case "11":
          flightCategory.setAirTrafficEnum(AirTrafficEnum.NOT_APPLICABLE);
          break;
        default:
          flightCategory.setAirTrafficEnum(AirTrafficEnum.UNKNOWN);
          break;
      }

      String flightRuleBits = ByteUtil.toString(uap.get(index)).substring(2, 4);
      switch (flightRuleBits) {
        case "00":
          flightCategory.setFlightRuleEnum(FlightRuleEnum.INSTRUMENT);
          break;
        case "01":
          flightCategory.setFlightRuleEnum(FlightRuleEnum.VISUAL);
          break;
        case "10":
          flightCategory.setFlightRuleEnum(FlightRuleEnum.NOT_APPLICABLE);
          break;
        case "11":
          flightCategory.setFlightRuleEnum(FlightRuleEnum.CONTROLLED_VISUAL);
          break;
        default:
          flightCategory.setFlightRuleEnum(FlightRuleEnum.NOT_APPLICABLE);
          break;
      }

      String rvsmBits = ByteUtil.toString(uap.get(index)).substring(4, 6);
      switch (rvsmBits) {
        case "00":
          flightCategory.setRvsmEnum(RvsmEnum.UNKNOWN);
          break;
        case "01":
          flightCategory.setRvsmEnum(RvsmEnum.APPROVED);
          break;
        case "10":
          flightCategory.setRvsmEnum(RvsmEnum.EXEMPT);
          break;
        case "11":
          flightCategory.setRvsmEnum(RvsmEnum.NOT_APPROVED);
          break;
        default:
          flightCategory.setRvsmEnum(RvsmEnum.NOT_APPROVED);
          break;
      }

      String hprBit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      flightCategory.setFlightPriorityEnum(
          zeroBit.equals(hprBit) ? FlightPriorityEnum.NORMAL : FlightPriorityEnum.HIGH);

      return flightCategory;
    }
    return null;
  }
}
