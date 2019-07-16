package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.position.CartesianPosition;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.PolarVelocity;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class PolarVelocityReader {

  public static PolarVelocity read(List<Byte> message, FieldSpec fieldSpec) {
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.POLAR_CALCULATED_TRACK_VELOCITY_FRN);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(CnCat003Config.POLAR_CALCULATED_TRACK_VELOCITY_SIZE);

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.POLAR_CALCULATED_TRACK_VELOCITY_FRN);

      PolarVelocity polarVelocity = new PolarVelocity();

      int groundSpeedValue =
          IntegerUtil.signedValueOf(message.get(index), message.get(index + 1));

      int angleValue =
          IntegerUtil.signedValueOf(message.get(index + 2), message.get(index + 3));

      double groundSpeed = DecimalUtil.multiply(groundSpeedValue, DecimalUtil.divide(1,Math.pow(2,13)));
      double angle = DecimalUtil.multiply(angleValue, DecimalUtil.divide(360,Math.pow(2,16)));

     polarVelocity.setGroundSpeed(groundSpeed);
     polarVelocity.setAngle(angle);
     return polarVelocity;
    }
    return null;
  }
}
