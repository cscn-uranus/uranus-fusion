package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.cncat003.TargetReportInformation;
import com.uranus.transition.common.asterix.uap.shared.datainfo.*;
import com.uranus.transition.common.asterix.uap.shared.military.MilitaryEmergencyStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.military.MilitaryIdentificationStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.track.status.EmergencyStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.track.status.SpiStatusEnum;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * @author 肖鹏 tellxp@github.com
 * @date 2019/6/25
 */
public class TargetReportInfomationReader {

  public static TargetReportInformation read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.TARGET_REPORT_INFO_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int sizeCount = CnCat003Config.TARGET_REPORT_INFO_EX_SIZE;

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.TARGET_REPORT_INFO_FRN);

      TargetReportInformation targetReportInformation = new TargetReportInformation();

      readZeroContent(message.get(index), targetReportInformation);
      String fx0Bit = ByteUtil.toString(message.get(index)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx0Bit)) {
        fpIndicator.setSize(sizeCount);
        return targetReportInformation;
      }

      sizeCount+=CnCat003Config.TARGET_REPORT_INFO_EX_SIZE;

      readFirstContent(message.get(index+1),targetReportInformation);
      String fx1Bit = ByteUtil.toString(message.get(index+1)).substring(7,8);
      if (ByteUtil.ZERO_BIT.equals(fx1Bit)) {
        fpIndicator.setSize(sizeCount);
        return targetReportInformation;
      }
    }
    return null;
  }

  private static void readZeroContent(
      Byte octet, TargetReportInformation targetReportInformation) {
    String typBit = ByteUtil.toString(octet).substring(0, 1);
    targetReportInformation.setReportDataType(
        ByteUtil.ZERO_BIT.equals(typBit) ? ReportDataTypeEnum.DEFAULT : ReportDataTypeEnum.TRACK);

    String simBit = ByteUtil.toString(octet).substring(1, 2);
    targetReportInformation.setTargetType(
        ByteUtil.ZERO_BIT.equals(simBit) ? TargetTypeEnum.ACTUAL : TargetTypeEnum.SIMULATED);

    String ssrBit = ByteUtil.toString(octet).substring(2, 4);
    switch (ssrBit) {
      case "01":
        targetReportInformation.setReportDetectionEnum(ReportDetectionEnum.SINGLE_PSR);
        break;
      case "10":
        targetReportInformation.setReportDetectionEnum(ReportDetectionEnum.SINGLE_SSR);
        break;
      case "1":
        targetReportInformation.setReportDetectionEnum(ReportDetectionEnum.SSR_PSR);
        break;
      default:
        targetReportInformation.setReportDetectionEnum(ReportDetectionEnum.NO_DETECTION);
        break;
    }

    String spiBit = ByteUtil.toString(octet).substring(5, 6);
    targetReportInformation.setSpiStatusEnum(
        ByteUtil.ZERO_BIT.equals(spiBit) ? SpiStatusEnum.DEFAULT : SpiStatusEnum.PRESENT);

    String fipBit = ByteUtil.toString(octet).substring(6, 7);
    targetReportInformation.setReportSourceEnum(
        ByteUtil.ZERO_BIT.equals(fipBit) ? ReportSourceEnum.DEFAULT : ReportSourceEnum.MONITOR);
  }

  private static void readFirstContent(
      Byte octet, TargetReportInformation targetReportInformation) {
    String dsBit = ByteUtil.toString(octet).substring(1, 3);
    switch (dsBit) {
      case "01":
        targetReportInformation.setEmergencyStatusEnum(EmergencyStatusEnum.UNLAWFUL_INTERFERENCE);
        break;
      case "10":
        targetReportInformation.setEmergencyStatusEnum(EmergencyStatusEnum.NO_COMMUNICATIONS);
        break;
      case "11":
        targetReportInformation.setEmergencyStatusEnum(EmergencyStatusEnum.GENERAL_EMERGENCY);
        break;
      default:
        targetReportInformation.setEmergencyStatusEnum(EmergencyStatusEnum.DEFAULT);
        break;
    }

    String meBit = ByteUtil.toString(octet).substring(3,4);
    targetReportInformation.setMilitaryEmergencyStatusEnum(
      ByteUtil.ZERO_BIT.equals(meBit)? MilitaryEmergencyStatusEnum.DEFAULT:MilitaryEmergencyStatusEnum.MILITARY_EMERGENCY
    );

    String miBit = ByteUtil.toString(octet).substring(4,5);
    targetReportInformation.setMilitaryIdentificationStatusEnum(
      ByteUtil.ZERO_BIT.equals(miBit)? MilitaryIdentificationStatusEnum.DEFAULT:MilitaryIdentificationStatusEnum.MILITARY_IDENTIFICATION
    );

    String piBit = ByteUtil.toString(octet).substring(5,6);
    targetReportInformation.setFlightPlanCorrelatedStatusEnum(
      ByteUtil.ZERO_BIT.equals(piBit)? CorrelatedStatusEnum.DEFAULT:CorrelatedStatusEnum.CORRELATED
    );
  }
}
