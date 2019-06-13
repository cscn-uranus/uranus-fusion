package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.vehicle.TargetSizeAndOrientation;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TargetSizeAndOrientationReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class TargetSizeAndOrientationReader {

  public static TargetSizeAndOrientation read(List<Byte> uap, FieldSpec fieldSpec) {
    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.TARGET_SIZE_AND_ORIENTATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int sizeCount = Cat062Config.TARGET_SIZE_AND_ORIENTATION_EX_SIZE;
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TARGET_SIZE_AND_ORIENTATION_FRN);

      TargetSizeAndOrientation targetSizeAndOrientation = new TargetSizeAndOrientation();

      String lengthBits = ByteUtil.toString(uap.get(index)).substring(0, 7);
      int length = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(lengthBits));
      targetSizeAndOrientation.setLength(length);
      String fx0Bit = ByteUtil.toString(uap.get(index)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx0Bit)) {
        fpIndicator.setSize(sizeCount);
        return targetSizeAndOrientation;
      }

      sizeCount++;

      String orientationBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 7);
      int orientationValue = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(orientationBits));
      double resolution = DecimalUtil.divide(360, 128);
      double orientation = DecimalUtil.multiply(orientationValue, resolution);
      targetSizeAndOrientation.setOrientation(orientation);
      String fx1Bit = ByteUtil.toString(uap.get(index + 1)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx1Bit)) {
        fpIndicator.setSize(sizeCount);
        return targetSizeAndOrientation;
      }

      sizeCount++;

      String widthBits = ByteUtil.toString(uap.get(index + 2)).substring(0, 7);
      int width = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(widthBits));
      targetSizeAndOrientation.setWidth(width);
      String fx2Bit = ByteUtil.toString(uap.get(index + 2)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx2Bit)) {
        fpIndicator.setSize(sizeCount);
        return targetSizeAndOrientation;
      }
    }
    return null;
  }
}
