package com.uranus.fusion.common.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.identification.TargetIdentification;
import com.uranus.fusion.common.asterix.uap.identification.TargetIdentificationEnum;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.StringUtil;

import java.util.List;

/**
 * TargetIdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class TargetIdentificationMapper {

  public static TargetIdentification read(List<Byte> message, DataSpec fieldSpec) {

    DpIndicator dpIndicator =
        fieldSpec.getDpIndicator(AircraftDerivedDataConfig.TARGET_IDENTIFICATION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TARGET_IDENTIFICATION_SIZE);

      int index =
          fieldSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TARGET_IDENTIFICATION_DRN);

      TargetIdentification targetIdentification = new TargetIdentification();
      targetIdentification.setTargetIdentificationEnum(TargetIdentificationEnum.AIRCRAFT_DERIVED);

      String bitString =
          ByteUtil.toString(
              message.subList(index, index + AircraftDerivedDataConfig.TARGET_IDENTIFICATION_SIZE));

      String identification = StringUtil.sixBitsAsciiValueOf(bitString, 6);

      targetIdentification.setIdentification(identification);
      return targetIdentification;
    }
    return null;
  }
}
