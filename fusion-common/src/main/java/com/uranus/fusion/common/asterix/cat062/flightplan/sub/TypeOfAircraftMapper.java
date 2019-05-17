package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.flightplan.AircraftType;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.StringUtil;

import java.util.List;

/**
 * TypeOfAircraftMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class TypeOfAircraftMapper {

  public static AircraftType read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_DRN);

      AircraftType aircraftType = new AircraftType();

      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_SIZE));

      String type = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);
      aircraftType.setType(type);
      return aircraftType;
    }
    return null;
  }
}
