package com.uranus.transition.common.asterix.cat062.flightplan.sub;

import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.flightplan.DestinationAirport;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * DestinationAirportMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class DestinationAirportMapper {

  public static DestinationAirport read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_DRN);

      DestinationAirport destinationAirport = new DestinationAirport();
      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_SIZE));

      String icaoName = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);

      destinationAirport.setIcaoName(icaoName);
      return destinationAirport;
    }
    return null;
  }
}
