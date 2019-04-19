package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.IfpsFlightId;
import com.uranus.fusion.asterix.uap.flightplan.IfpsFlightIdEnum;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * IfpsFlightIdMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public class IfpsFlightIdMapper {

  public static IfpsFlightId read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.IFPS_FLIGHT_ID_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.IFPS_FLIGHT_ID_SIZE);

      IfpsFlightId ifpsFlightId = new IfpsFlightId();
      int index = dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.IFPS_FLIGHT_ID_DRN);

      String typBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (typBits) {
        case "01":
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.UNIT1);
          break;
        case "10":
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.UNIT2);
          break;
        case "11":
          ifpsFlightId.setIfpsFlightIdEnum(IfpsFlightIdEnum.UNIT3);
          break;
        case "00":
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
