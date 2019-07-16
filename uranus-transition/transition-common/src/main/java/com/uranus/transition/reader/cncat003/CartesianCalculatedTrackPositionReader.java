package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.position.CartesianPosition;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class CartesianCalculatedTrackPositionReader {

  public static CartesianPosition read(List<Byte> message, FieldSpec fieldSpec) {
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.CARTESIAN_CALCULATED_TRACK_POSITION_FRN);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(CnCat003Config.CARTESIAN_CALCULATED_TRACK_POSITION_SIZE);

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.CARTESIAN_CALCULATED_TRACK_POSITION_FRN);

      CartesianPosition position = new CartesianPosition();

      // x value
      int xValue =
          IntegerUtil.signedValueOf(message.get(index), message.get(index + 1));

      // y value
      int yValue =
          IntegerUtil.signedValueOf(message.get(index + 2), message.get(index + 3));

      double x = DecimalUtil.multiply(xValue, 0.03125);
      double y = DecimalUtil.multiply(yValue, 0.03125);

      // position
      position.setX(x);
      position.setY(y);
      return position;
    }
    return null;
  }
}
