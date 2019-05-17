package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.altitude.FlightLevel;
import com.uranus.fusion.common.asterix.uap.measure.altitude.FlightLevelEnum;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * CurrentClearedFlightLevelMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class CurrentClearedFlightLevelMapper {

  public static FlightLevel read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.CURRENT_CLEARED_FLIGHT_LEVEL_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.CURRENT_CLEARED_FLIGHT_LEVEL_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.CURRENT_CLEARED_FLIGHT_LEVEL_DRN);

      FlightLevel currentClearedFlightLevel = new FlightLevel(FlightLevelEnum.CLEARED);

      int cflValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      currentClearedFlightLevel.setFl(DecimalUtil.multiply(cflValue, 0.25));
      return currentClearedFlightLevel;
    }
    return null;
  }
}
