package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.identification.TargetIdentification;
import com.uranus.fusion.asterix.uap.identification.TargetIdentificationEnum;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * TargetIdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class TargetIdentificationMapper {

  public static TargetIdentification read(List<Byte> uap, DataSpec fieldSpec) {

    DpIndicator dpIndicator =
        fieldSpec.getDpIndicator(AircraftDerivedDataConfig.TARGET_IDENTIFICATION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TARGET_IDENTIFICATION_SIZE);

      int index =
          fieldSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TARGET_IDENTIFICATION_DRN);

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
