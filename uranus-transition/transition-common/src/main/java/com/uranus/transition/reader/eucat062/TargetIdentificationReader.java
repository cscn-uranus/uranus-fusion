package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetIdentification;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetIdentificationEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * TargetIdentificationReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
class TargetIdentificationReader {

  static TargetIdentification read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.TARGET_IDENTIFICATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(EuCat062Config.TARGET_IDENTIFICATION_SIZE);

      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.TARGET_IDENTIFICATION_FRN);

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
              message.subList(index + 1, index + EuCat062Config.TARGET_IDENTIFICATION_SIZE));

      String identification = StringUtil.sixBitsAsciiValueOf(bitString, 6);

      targetIdentification.setIdentification(identification);
      return targetIdentification;
    }
    return null;
  }
}
