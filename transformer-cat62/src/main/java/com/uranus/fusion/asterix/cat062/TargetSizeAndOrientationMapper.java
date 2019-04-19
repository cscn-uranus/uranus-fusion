package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.vehicle.TargetSizeAndOrientation;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * TargetSizeAndOrientationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class TargetSizeAndOrientationMapper {

  public static TargetSizeAndOrientation read(List<Byte> uap, FieldSpec fieldSpec) {
    FpIndicator fpIndicator =
        fieldSpec.getFpIndicator(Cat062Config.TARGET_SIZE_AND_ORIENTATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int sizeCount = Cat062Config.TARGET_SIZE_AND_ORIENTATION_EX_SIZE;
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TARGET_SIZE_AND_ORIENTATION_FRN);

      TargetSizeAndOrientation targetSizeAndOrientation = new TargetSizeAndOrientation();

      String lengthBits = ByteUtil.toString(uap.get(index)).substring(0, 7);
      int length = IntegerUtil.valueOf(ByteUtil.valueOf(lengthBits));
      targetSizeAndOrientation.setLength(length);
      String fx0Bit = ByteUtil.toString(uap.get(index)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx0Bit)) {
        fpIndicator.setSize(sizeCount);
        return targetSizeAndOrientation;
      }

      sizeCount++;

      String orientationBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 7);
      int orientationValue = IntegerUtil.valueOf(ByteUtil.valueOf(orientationBits));
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
      int width = IntegerUtil.valueOf(ByteUtil.valueOf(widthBits));
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
