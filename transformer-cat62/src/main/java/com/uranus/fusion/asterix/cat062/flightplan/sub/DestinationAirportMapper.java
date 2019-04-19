package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.google.common.primitives.Bytes;
import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.DestinationAerodrome;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * DestinationAirportMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class DestinationAirportMapper {

  public static DestinationAerodrome read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.DESTINATION_AIRPORT_DRN);

      DestinationAerodrome destinationAerodrome = new DestinationAerodrome();

      byte[] characters =
          Bytes.toArray(
              uap.subList(index, index + FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_SIZE - 1));
      String icaoName = StringUtil.asciiValueOf(characters);

      destinationAerodrome.setIcaoName(icaoName);
      return destinationAerodrome;
    }
    return null;
  }
}
