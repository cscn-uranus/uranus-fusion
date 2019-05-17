package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.flightplan.DepartureAerodrome;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.StringUtil;

import java.util.List;

/**
 * TypeOfAircraftMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class DepartureAirportMapper {

  public static DepartureAerodrome read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_DRN);

      DepartureAerodrome departureDepartureAerodrome = new DepartureAerodrome();
      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_SIZE));

      String icaoName = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);
      departureDepartureAerodrome.setIcaoName(icaoName);
      return departureDepartureAerodrome;
    }
    return null;
  }
}
