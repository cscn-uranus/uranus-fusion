package com.uranus.transition.common.asterix.cat062.aircraftdata.sub;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.datainfo.DataAvailableEnum;
import com.uranus.transition.common.asterix.uap.datainfo.DataValidEnum;
import com.uranus.transition.common.asterix.uap.trajectory.TrajectoryIntentStatus;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * TrajectoryDataMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/25
 */
public class TrajectoryStatusMapper {

  public static TrajectoryIntentStatus read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.TRAJECTORY_INTENT_STATUS_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TRAJECTORY_INTENT_STATUS_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TRAJECTORY_INTENT_STATUS_DRN);

      TrajectoryIntentStatus trajectoryIntentStatus = new TrajectoryIntentStatus();

      String dataAvailableValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      trajectoryIntentStatus.setDataAvailableStatus(
          ByteUtil.ZERO_BIT.equals(dataAvailableValue)
              ? DataAvailableEnum.AVAILABLE
              : DataAvailableEnum.NOT_AVAILABLE);

      String dataValidValue = ByteUtil.toString(uap.get(index)).substring(1, 2);
      trajectoryIntentStatus.setDataValidStatus(
          ByteUtil.ZERO_BIT.equals(dataValidValue) ? DataValidEnum.VALID : DataValidEnum.NOT_VALID);

      return trajectoryIntentStatus;
    }
    return null;
  }
}
