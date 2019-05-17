package com.uranus.fusion.common.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.angle.RollAngle;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * RollAngleMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class RollAngleMapper {

  public static RollAngle read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.ROLL_ANGLE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.ROLL_ANGLE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.ROLL_ANGLE_DRN);

      RollAngle rollAngle = new RollAngle();

      int rollAngleValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      rollAngle.setAngle(DecimalUtil.multiply(rollAngleValue, 0.01));

      return rollAngle;
    }
    return null;
  }
}
