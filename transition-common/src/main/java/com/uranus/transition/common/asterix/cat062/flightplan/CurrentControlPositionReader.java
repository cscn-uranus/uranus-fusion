package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.flightplan.ControlPosition;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
class CurrentControlPositionReader {

  public static ControlPosition read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.CURRENT_CONTROL_POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.CURRENT_CONTROL_POSITION_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.CURRENT_CONTROL_POSITION_DRN);

      ControlPosition controlPosition = new ControlPosition();

      String centreCode = ByteUtil.toString(uap.get(index));
      String positionCode = ByteUtil.toString(uap.get(index + 1));

      controlPosition.setCentreCode(centreCode);
      controlPosition.setPositionCode(positionCode);

      return controlPosition;
    }
    return null;
  }
}
