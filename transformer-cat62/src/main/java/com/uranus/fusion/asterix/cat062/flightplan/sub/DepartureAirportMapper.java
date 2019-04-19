package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.google.common.primitives.Bytes;
import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.DepartureAerodrome;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * TypeOfAircraftMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class DepartureAirportMapper {

  public static DepartureAerodrome read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_DRN);

      DepartureAerodrome departureDepartureAerodrome = new DepartureAerodrome();

      byte[] characters =
          Bytes.toArray(
              uap.subList(index, index + FlightPlanRelatedDataConfig.DEPARTURE_AIRPORT_SIZE - 1));

      String icaoName = StringUtil.asciiValueOf(characters);
      departureDepartureAerodrome.setIcaoName(icaoName);
      return departureDepartureAerodrome;
    }
    return null;
  }
}
