package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.google.common.primitives.Bytes;
import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.AircraftStand;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * AircraftStandMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class AircraftStandMapper {

  public static AircraftStand read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.AIRCRAFT_STAND_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.AIRCRAFT_STAND_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.AIRCRAFT_STAND_DRN);

      AircraftStand aircraftStand = new AircraftStand();

      byte[] characters =
          Bytes.toArray(
              uap.subList(index, index + FlightPlanRelatedDataConfig.AIRCRAFT_STAND_SIZE - 1));

      String stand = StringUtil.asciiValueOf(characters);

      aircraftStand.setStand(stand);
      return aircraftStand;
    }
    return null;
  }
}
