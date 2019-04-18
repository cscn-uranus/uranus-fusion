package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.measure.position.CartesianPosition;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class CartesianCalculatedTrackPositionMapper {

  public static CartesianPosition readCartesianCalculatedTrackPosition(
      List<Byte> uap, FieldSpec fieldSpec) {

    // Calculated Track Position (Cartesian): frn=6, size=6
    final int frn = Cat062Config.CARTESIAN_CALCULATED_TRACK_POSITION_FRN;
    final int size = Cat062Config.CARTESIAN_CALCULATED_TRACK_POSITION_SIZE;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(size);

      int index = fieldSpec.calculateIndexByFrn(frn);
      CartesianPosition position = new CartesianPosition();

      // x value
      int xValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2));

      // y value
      int yValue = IntegerUtil.valueOf(uap.get(index + 3), uap.get(index + 4), uap.get(index + 5));

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
