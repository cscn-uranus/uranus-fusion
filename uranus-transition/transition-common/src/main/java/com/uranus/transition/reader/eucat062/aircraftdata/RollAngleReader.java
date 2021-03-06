package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.RollAngle;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * RollAngleReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class RollAngleReader {

  public static RollAngle read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.ROLL_ANGLE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.ROLL_ANGLE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.ROLL_ANGLE_DRN);

      RollAngle rollAngle = new RollAngle();

      int rollAngleValue = IntegerUtil.signedValueOf(uap.get(index), uap.get(index + 1));
      rollAngle.setAngle(DecimalUtil.multiply(rollAngleValue, 0.01));

      return rollAngle;
    }
    return null;
  }
}
