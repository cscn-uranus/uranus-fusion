package com.uranus.fusion.common.asterix;

import com.uranus.fusion.common.asterix.measure.CartesianAcceleration;
import com.uranus.fusion.common.asterix.measure.CartesianPosition;
import com.uranus.fusion.common.asterix.measure.CartesianVelocity;
import com.uranus.fusion.common.asterix.measure.Wgs84Position;
import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.FpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class CalculatedTrackMapper {

  public static Wgs84Position readWgs84CalculatedTrackPosition(
      List<Byte> uap, FieldSpec fieldSpec) {
    // Calculated Track Position (WGS-84) frn=5
    final int frn = 5;
    final int length = 8;
    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      // 固定长度
      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      // resolution
      double resolution =
          DecimalUtil.divide(180, Math.pow(2, 25));

      // latitude value
      int latitudeValue = IntegerUtil
          .valueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2),
              uap.get(index + 3));
      double latitude = DecimalUtil.multiply(latitudeValue, resolution);

      // longitude value
      int longitudeValue = IntegerUtil
          .valueOf(uap.get(index + 4), uap.get(index + 5), uap.get(index + 6), uap.get(index + 7));
      double longitude = DecimalUtil.multiply(longitudeValue, resolution);

      Wgs84Position position = new Wgs84Position();
      position.setLatitude(latitude);
      position.setLongitude(longitude);
      return position;
    }
    return null;
  }

  public static CartesianAcceleration readCartesianCalculatedAcceleration(
      List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Calculated Acceleration (Cartesian) frn=8
    final int frn = 8;
    final int length = 2;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);
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

  public static CartesianPosition readCartesianCalculatedTrackPosition(
      List<Byte> uap, FieldSpec fieldSpec) {

    // Calculated Track Position (Cartesian) frn=6
    final int frn = 6;
    final int length = 6;
    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);
      CartesianPosition position = new CartesianPosition();

      // x value
      int xValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2));

      // y value
      int yValue = IntegerUtil.valueOf(uap.get(index + 3), uap.get(index + 4), uap.get(index + 5));

      double x =DecimalUtil.multiply(xValue,0.5);
      double y =DecimalUtil.multiply(yValue,0.5);

      // position
      position.setX(x);
      position.setY(y);
      return position;
    }
    return null;
  }

  public static CartesianVelocity readCartesianCalculatedTrackVelocity(
      List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Calculated Track Velocity (Cartesian) frn=7
    final int frn = 7;
    final int length = 4;
    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

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
