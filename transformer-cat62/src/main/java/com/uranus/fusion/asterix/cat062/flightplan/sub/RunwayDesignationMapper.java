package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.Runway;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * RunwayDesignationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class RunwayDesignationMapper {

  public static Runway read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.RUNWAY_DESIGNATION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.RUNWAY_DESIGNATION_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.RUNWAY_DESIGNATION_DRN);

      Runway runway = new Runway();

      String icaoName =
          StringUtil.asciiValueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2));
      runway.setIcaoName(icaoName);
      return runway;
    }
    return null;
  }
}
