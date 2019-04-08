package com.uranus.fusion.common.asterix.aircraft.pfd;

import com.uranus.fusion.common.asterix.measure.RollAngle;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * RollAngleMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class RollAngleMapper {

  public static RollAngle readRollAngle(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 15;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(2);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      RollAngle rollAngle = new RollAngle();

      int rollAngleValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      rollAngle.setAngle(DecimalUtil.multiply(rollAngleValue, 0.01));

      return rollAngle;
    }
    return null;
  }
}
