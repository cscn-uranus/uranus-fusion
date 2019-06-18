package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.identification.TargetIdentification;
import com.uranus.transition.common.asterix.uap.identification.TargetIdentificationEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * TargetIdentificationReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class TargetIdentificationReader {

  public static TargetIdentification read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.TARGET_IDENTIFICATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.TARGET_IDENTIFICATION_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TARGET_IDENTIFICATION_FRN);

      TargetIdentification targetIdentification = new TargetIdentification();

      String targetIdentificationEnumValue = ByteUtil.toString(message.get(index)).substring(0, 2);
      switch (targetIdentificationEnumValue) {
        case "00":
          targetIdentification.setTargetIdentificationEnum(
              TargetIdentificationEnum.CALLSIGN_REGISTRATION_DOWNLINKED);
          break;
        case "01":
          targetIdentification.setTargetIdentificationEnum(
              TargetIdentificationEnum.CALLSIGN_NOT_DOWNLINKED);
          break;
        case "10":
          targetIdentification.setTargetIdentificationEnum(
              TargetIdentificationEnum.REGISTRATION_NOT_DOWNLINKED);
          break;
        case "11":
        default:
          targetIdentification.setTargetIdentificationEnum(TargetIdentificationEnum.INVALID);
          break;
      }

      String bitString =
          ByteUtil.toString(
              message.subList(index + 1, index + Cat062Config.TARGET_IDENTIFICATION_SIZE));

      String identification = StringUtil.sixBitsAsciiValueOf(bitString, 6);

      targetIdentification.setIdentification(identification);
      return targetIdentification;
    }
    return null;
  }
}
