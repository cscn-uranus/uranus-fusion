package com.uranus.fusion.common.asterix.cat062.sub;

import com.uranus.fusion.common.asterix.cat062.Cat062Config;
import com.uranus.fusion.common.asterix.spec.FieldSpec;
import com.uranus.fusion.common.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.FpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.speed.CartesianAcceleration;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class CartesianCalculatedTrackAccelerationMapper {

  public static CartesianAcceleration read(List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Calculated Acceleration (Cartesian): frn=8, size=2
    final int frn = Cat062Config.CARTESIAN_CALCULATED_ACCELERATION_FRN;
    final int length = Cat062Config.CARTESIAN_CALCULATED_ACCELERATION_SIZE;

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(length);

      int index = fieldSpec.calculateIndexByFrn(frn);
      CartesianAcceleration acceleration = new CartesianAcceleration();

      // acceleration x value
      int accelerationXValue = IntegerUtil.unsignedValueOf(uapOctetList.get(index));

      // acceleration y value
      int accelerationYValue = IntegerUtil.unsignedValueOf(uapOctetList.get(index + 1));

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
