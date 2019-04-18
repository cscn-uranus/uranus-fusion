package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.measure.speed.CartesianAcceleration;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class CartesianCalculatedTrackAccelerationMapper {

  public static CartesianAcceleration readCartesianCalculatedAcceleration(
      List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Calculated Acceleration (Cartesian): frn=8, size=2
    final int frn = Cat062Config.CARTESIAN_CALCULATED_ACCELERATION_FRN;
    final int length = Cat062Config.CARTESIAN_CALCULATED_ACCELERATION_SIZE;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(length);

      int index = fieldSpec.calculateIndexByFrn(frn);
      CartesianAcceleration acceleration = new CartesianAcceleration();

      // acceleration x value
      int accelerationXValue = IntegerUtil.valueOf(uapOctetList.get(index));

      // acceleration y value
      int accelerationYValue = IntegerUtil.valueOf(uapOctetList.get(index + 1));

      double accelerationX = DecimalUtil.multiply(accelerationXValue, 0.25);
      double accelerationY = DecimalUtil.multiply(accelerationYValue, 0.25);

      // acceleration
      acceleration.setAccelerationX(accelerationX);
      acceleration.setAccelerationY(accelerationY);
      return acceleration;
    }
    return null;
  }
}
