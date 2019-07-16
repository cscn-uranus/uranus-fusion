package com.uranus.transition.reader.eucat062.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FlightLevel;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
 class CurrentClearedFlightLevelReader {

  public static FlightLevel read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.CURRENT_CLEARED_FLIGHT_LEVEL_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.CURRENT_CLEARED_FLIGHT_LEVEL_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.CURRENT_CLEARED_FLIGHT_LEVEL_DRN);

      FlightLevel currentClearedFlightLevel = new FlightLevel();

      int cflValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      currentClearedFlightLevel.setFl(DecimalUtil.multiply(cflValue, 0.25));
      return currentClearedFlightLevel;
    }
    return null;
  }
}
