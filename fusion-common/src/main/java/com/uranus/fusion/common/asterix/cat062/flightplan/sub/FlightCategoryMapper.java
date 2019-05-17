package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.flightplan.*;
import com.uranus.fusion.common.util.ByteUtil;

import java.util.List;

/**
 * FlightCategoryMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public class FlightCategoryMapper {

  public static FlightCategory read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.FLIGHT_CATEGORY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.FLIGHT_CATEGORY_SIZE);

      FlightCategory flightCategory = new FlightCategory();
      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.FLIGHT_CATEGORY_DRN);

      String airTrafficBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (airTrafficBits) {
        case "01":
          flightCategory.setAirTrafficEnum(AirTrafficEnum.GENERAL);
          break;
        case "10":
          flightCategory.setAirTrafficEnum(AirTrafficEnum.OPERATIONAL);
          break;
        case "11":
          flightCategory.setAirTrafficEnum(AirTrafficEnum.NOT_APPLICABLE);
          break;
        case "00":
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
        case "11":
          flightCategory.setFlightRuleEnum(FlightRuleEnum.CONTROLLED_VISUAL);
          break;
        case "10":
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
        default:
          flightCategory.setRvsmEnum(RvsmEnum.NOT_APPROVED);
          break;
      }

      String hprBit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      flightCategory.setFlightPriorityEnum(
          ByteUtil.ZERO_BIT.equals(hprBit) ? FlightPriorityEnum.NORMAL : FlightPriorityEnum.HIGH);

      return flightCategory;
    }
    return null;
  }
}
