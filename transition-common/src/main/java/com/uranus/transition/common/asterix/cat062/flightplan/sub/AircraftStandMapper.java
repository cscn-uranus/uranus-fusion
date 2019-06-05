package com.uranus.transition.common.asterix.cat062.flightplan.sub;

import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.flightplan.AircraftStand;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * AircraftStandMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class AircraftStandMapper {

  public static AircraftStand read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.AIRCRAFT_STAND_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.AIRCRAFT_STAND_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.AIRCRAFT_STAND_DRN);

      AircraftStand aircraftStand = new AircraftStand();

      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.AIRCRAFT_STAND_SIZE));

      String stand = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);

      aircraftStand.setStand(stand);
      return aircraftStand;
    }
    return null;
  }
}
