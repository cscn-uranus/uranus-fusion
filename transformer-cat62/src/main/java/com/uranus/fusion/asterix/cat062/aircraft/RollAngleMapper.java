package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.angle.RollAngle;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * RollAngleMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class RollAngleMapper {

  public static RollAngle readRollAngle(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.ROLL_ANGLE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.ROLL_ANGLE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.ROLL_ANGLE_DRN);

      RollAngle rollAngle = new RollAngle();

      int rollAngleValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      rollAngle.setAngle(DecimalUtil.multiply(rollAngleValue, 0.01));

      return rollAngle;
    }
    return null;
  }
}
