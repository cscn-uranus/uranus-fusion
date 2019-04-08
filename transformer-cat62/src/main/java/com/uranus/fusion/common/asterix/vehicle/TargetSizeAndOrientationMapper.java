package com.uranus.fusion.common.asterix.vehicle;

import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.FpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * TargetSizeAndOrientationMapper
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/11/12
 */
public class TargetSizeAndOrientationMapper {

  public static TargetSizeAndOrientation read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 22;
    final String zeroBit = "0";

    int size = 1;
    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      TargetSizeAndOrientation targetSizeAndOrientation = new TargetSizeAndOrientation();

      String lengthBits = ByteUtil.toString(uap.get(index)).substring(0, 7);
      int length = IntegerUtil.valueOf(ByteUtil.valueOf(lengthBits));
      targetSizeAndOrientation.setLength(length);
      String fx0Bit = ByteUtil.toString(uap.get(index)).substring(7, 8);
      if (zeroBit.equals(fx0Bit)) {
        fpIndicator.setSize(size);
        return targetSizeAndOrientation;
      }

      size++;

      String orientationBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 7);
      int orientationValue = IntegerUtil.valueOf(ByteUtil.valueOf(orientationBits));
      double resolution = DecimalUtil.divide(360, 128);
      double orientation = DecimalUtil.multiply(orientationValue, resolution);
      targetSizeAndOrientation.setOrientation(orientation);
      String fx1Bit = ByteUtil.toString(uap.get(index + 1)).substring(7, 8);
      if (zeroBit.equals(fx1Bit)) {
        fpIndicator.setSize(size);
        return targetSizeAndOrientation;
      }

      size++;

      String widthBits = ByteUtil.toString(uap.get(index + 2)).substring(0, 7);
      int width = IntegerUtil.valueOf(ByteUtil.valueOf(widthBits));
      targetSizeAndOrientation.setWidth(width);
      String fx2Bit = ByteUtil.toString(uap.get(index + 2)).substring(7, 8);
      if (zeroBit.equals(fx2Bit)) {
        fpIndicator.setSize(size);
        return targetSizeAndOrientation;
      }

    }
    return null;
  }

}
