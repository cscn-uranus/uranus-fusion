package com.uranus.fusion.common.asterix.aircraft.identity;

import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.StringUtil;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.FpIndicator;

import java.util.List;

/**
 * TargetIdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class TargetIdentificationMapper {

  public static TargetIdentification read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 10;
    final int size = 7;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(size);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      TargetIdentification targetIdentification = new TargetIdentification();

      String targetIdentificationEnumValue = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (targetIdentificationEnumValue) {
        case "00":
          targetIdentification.setTargetIdentificationEnum(
              TargetIdentificationEnum.CALLSIGN_REGISTRATION_DOWNLINKED);
          break;
        case "01":
          targetIdentification
              .setTargetIdentificationEnum(TargetIdentificationEnum.CALLSIGN_NOT_DOWNLINKED);
          break;
        case "10":
          targetIdentification
              .setTargetIdentificationEnum(TargetIdentificationEnum.REGISTRATION_NOT_DOWNLINKED);
          break;
        case "11":
          targetIdentification.setTargetIdentificationEnum(TargetIdentificationEnum.INVALID);
          break;
        default:
          targetIdentification.setTargetIdentificationEnum(TargetIdentificationEnum.INVALID);
          break;
      }

      String character1Value = ByteUtil.toString(uap.get(index + 1)).substring(0, 6);
      String character2Value =
          ByteUtil.toString(uap.get(index + 1)).substring(6, 8)
              + ByteUtil.toString(uap.get(index + 2)).substring(0, 4);
      String character3Value =
          ByteUtil.toString(uap.get(index + 2)).substring(4, 8)
              + ByteUtil.toString(uap.get(index + 3)).substring(0, 2);
      String character4Value = ByteUtil.toString(uap.get(index + 3)).substring(2, 8);
      String character5Value = ByteUtil.toString(uap.get(index + 4)).substring(0, 6);
      String character6Value =
          ByteUtil.toString(uap.get(index + 4)).substring(6, 8)
              + ByteUtil.toString(uap.get(index + 5)).substring(0, 4);
      String character7Value =
          ByteUtil.toString(uap.get(index + 5)).substring(4, 8)
              + ByteUtil.toString(uap.get(index + 6)).substring(0, 2);
      String character8Value = ByteUtil.toString(uap.get(index + 6)).substring(2, 8);

      String character1 = StringUtil.asciiValueOf(ByteUtil.valueOf(character1Value));
      String character2 = StringUtil.asciiValueOf(ByteUtil.valueOf(character2Value));
      String character3 = StringUtil.asciiValueOf(ByteUtil.valueOf(character3Value));
      String character4 = StringUtil.asciiValueOf(ByteUtil.valueOf(character4Value));
      String character5 = StringUtil.asciiValueOf(ByteUtil.valueOf(character5Value));
      String character6 = StringUtil.asciiValueOf(ByteUtil.valueOf(character6Value));
      String character7 = StringUtil.asciiValueOf(ByteUtil.valueOf(character7Value));
      String character8 = StringUtil.asciiValueOf(ByteUtil.valueOf(character8Value));

      targetIdentification.setIdentification(
          character1
              + character2
              + character3
              + character4
              + character5
              + character6
              + character7
              + character8);
      return targetIdentification;
    }
    return null;
  }

  public static TargetIdentification read(List<Byte> uap, DataSpec fieldSpec) {
    final int drn = 2;
    final int length = 6;

    DpIndicator dpIndicator = fieldSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByDrn(drn);

      TargetIdentification targetIdentification = new TargetIdentification();
      targetIdentification.setTargetIdentificationEnum(TargetIdentificationEnum.AIRCRAFT_DERIVED);

      String character1Value = ByteUtil.toString(uap.get(index)).substring(0, 6);
      String character2Value =
          ByteUtil.toString(uap.get(index)).substring(6, 8)
              + ByteUtil.toString(uap.get(index + 1)).substring(0, 4);
      String character3Value =
          ByteUtil.toString(uap.get(index + 1)).substring(4, 8)
              + ByteUtil.toString(uap.get(index + 2)).substring(0, 2);
      String character4Value = ByteUtil.toString(uap.get(index + 2)).substring(2, 8);
      String character5Value = ByteUtil.toString(uap.get(index + 3)).substring(0, 6);
      String character6Value =
          ByteUtil.toString(uap.get(index + 3)).substring(6, 8)
              + ByteUtil.toString(uap.get(index + 4)).substring(0, 4);
      String character7Value =
          ByteUtil.toString(uap.get(index + 4)).substring(4, 8)
              + ByteUtil.toString(uap.get(index + 5)).substring(0, 2);
      String character8Value = ByteUtil.toString(uap.get(index + 5)).substring(2, 8);

      String character1 = StringUtil.asciiValueOf(ByteUtil.valueOf(character1Value));
      String character2 = StringUtil.asciiValueOf(ByteUtil.valueOf(character2Value));
      String character3 = StringUtil.asciiValueOf(ByteUtil.valueOf(character3Value));
      String character4 = StringUtil.asciiValueOf(ByteUtil.valueOf(character4Value));
      String character5 = StringUtil.asciiValueOf(ByteUtil.valueOf(character5Value));
      String character6 = StringUtil.asciiValueOf(ByteUtil.valueOf(character6Value));
      String character7 = StringUtil.asciiValueOf(ByteUtil.valueOf(character7Value));
      String character8 = StringUtil.asciiValueOf(ByteUtil.valueOf(character8Value));

      targetIdentification.setIdentification(
          character1
              + character2
              + character3
              + character4
              + character5
              + character6
              + character7
              + character8);
      return targetIdentification;
    }
    return null;
  }
}
