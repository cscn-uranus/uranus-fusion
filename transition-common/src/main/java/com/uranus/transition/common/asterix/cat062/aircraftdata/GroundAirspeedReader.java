package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.speed.GroundSpeed;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class GroundAirspeedReader {

  public static GroundSpeed read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.GROUND_SPEED_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.GROUND_SPEED_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.GROUND_SPEED_DRN);

      int groundSpeedValue = IntegerUtil.signedValueOf(uap.get(index), uap.get(index + 1));
      double resolution = DecimalUtil.divide(1, Math.pow(2, 14));

      GroundSpeed groundSpeed = new GroundSpeed();
      groundSpeed.setSpeed(DecimalUtil.multiply(groundSpeedValue, resolution));
      return groundSpeed;
    }
    return null;
  }
}
