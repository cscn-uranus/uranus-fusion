package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.flightplan.TypeOfAircraft;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
 class TypeOfAircraftReader {

  public static TypeOfAircraft read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_DRN);

      TypeOfAircraft typeOfAircraft = new TypeOfAircraft();

      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_SIZE));

      String type = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);
      typeOfAircraft.setType(type);
      return typeOfAircraft;
    }
    return null;
  }
}
