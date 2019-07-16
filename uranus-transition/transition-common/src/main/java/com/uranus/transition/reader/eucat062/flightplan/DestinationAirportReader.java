package com.uranus.transition.reader.eucat062.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.flightplan.DestinationAirport;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
 class DestinationAirportReader {

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
