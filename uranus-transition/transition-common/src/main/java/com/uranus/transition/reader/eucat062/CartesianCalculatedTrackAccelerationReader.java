package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.CartesianAcceleration;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
class CartesianCalculatedTrackAccelerationReader {

  static CartesianAcceleration read(List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Calculated Acceleration (Cartesian): frn=8, size=2
    final int frn = EuCat062Config.CARTESIAN_CALCULATED_ACCELERATION_FRN;
    final int length = EuCat062Config.CARTESIAN_CALCULATED_ACCELERATION_SIZE;

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
