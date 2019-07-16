package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.position.CartesianPosition;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
class CartesianCalculatedTrackPositionReader {

  static CartesianPosition read(List<Byte> uap, FieldSpec fieldSpec) {

    // Calculated Track Position (Cartesian): frn=6, size=6
    final int frn = EuCat062Config.CARTESIAN_CALCULATED_TRACK_POSITION_FRN;
    final int size = EuCat062Config.CARTESIAN_CALCULATED_TRACK_POSITION_SIZE;

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(size);

      int index = fieldSpec.calculateIndexByFrn(frn);
      CartesianPosition position = new CartesianPosition();

      // x value
      int xValue =
          IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2));

      // y value
      int yValue =
          IntegerUtil.unsignedValueOf(uap.get(index + 3), uap.get(index + 4), uap.get(index + 5));

      double x = DecimalUtil.multiply(xValue, 0.5);
      double y = DecimalUtil.multiply(yValue, 0.5);

      // position
      position.setX(x);
      position.setY(y);
      return position;
    }
    return null;
  }
}
