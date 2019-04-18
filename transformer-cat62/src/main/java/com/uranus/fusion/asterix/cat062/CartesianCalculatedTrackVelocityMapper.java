package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.measure.speed.CartesianVelocity;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class CartesianCalculatedTrackVelocityMapper {

  public static CartesianVelocity readCartesianCalculatedTrackVelocity(
      List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Calculated Track Velocity (Cartesian): frn=7, size=4
    final int frn = Cat062Config.CARTESIAN_CALCULATED_TRACK_VELOCITY_FRN;
    final int size = Cat062Config.CARTESIAN_CALCULATED_TRACK_VELOCITY_SIZE;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(size);

      int index = fieldSpec.calculateIndexByFrn(frn);

      CartesianVelocity velocity = new CartesianVelocity();
      // velocity x value
      int vXValue = IntegerUtil.valueOf(uapOctetList.get(index), uapOctetList.get(index + 1));
      double velocityX = DecimalUtil.multiply(vXValue, 0.25);
      velocity.setVelocityX(velocityX);

      int vYValue = IntegerUtil.valueOf(uapOctetList.get(index + 2), uapOctetList.get(index + 3));
      double velocityY = DecimalUtil.multiply(vYValue, 0.25);
      velocity.setVelocityY(velocityY);

      return velocity;
    }
    return null;
  }
}
