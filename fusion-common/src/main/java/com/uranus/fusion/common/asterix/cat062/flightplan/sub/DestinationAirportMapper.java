package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.flightplan.DestinationAerodrome;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.StringUtil;

import java.util.List;

/**
 * DestinationAirportMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class DestinationAirportMapper {

  public static DestinationAerodrome read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_DRN);

      DestinationAerodrome destinationAerodrome = new DestinationAerodrome();
      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_DRN));

      String icaoName = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);

      destinationAerodrome.setIcaoName(icaoName);
      return destinationAerodrome;
    }
    return null;
  }
}
