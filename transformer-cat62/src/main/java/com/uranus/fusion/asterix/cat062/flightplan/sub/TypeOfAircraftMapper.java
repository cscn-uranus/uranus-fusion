package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.AircraftType;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * TypeOfAircraftMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class TypeOfAircraftMapper {

  public static AircraftType read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.TYPE_OF_AIRCRAFT_DRN);

      AircraftType aircraftType = new AircraftType();

      String character1 = StringUtil.asciiValueOf(uap.get(index));
      String character2 = StringUtil.asciiValueOf(uap.get(index + 1));
      String character3 = StringUtil.asciiValueOf(uap.get(index + 2));
      String character4 = StringUtil.asciiValueOf(uap.get(index + 3));

      String type = character1 + character2 + character3 + character4;
      aircraftType.setType(type);
      return aircraftType;
    }
    return null;
  }
}
