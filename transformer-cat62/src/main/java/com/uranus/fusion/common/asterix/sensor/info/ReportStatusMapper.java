package com.uranus.fusion.common.asterix.sensor.info;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.track.status.type.TargetTypeEnum;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import java.util.List;

/**
 * ReportStatusMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class ReportStatusMapper {

  public static ReportStatus read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 6;
    final int size = 1;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      ReportStatus reportStatus = new ReportStatus();

      String typBits = ByteUtil.toString(uap.get(index)).substring(0, 3);
      switch (typBits) {
        case "000":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.NO_DETECTION);
          break;
        case "001":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.SINGLE_PSR);
          break;
        case "010":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.SINGLE_SSR);
          break;
        case "011":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.SSR_PSR);
          break;
        case "100":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.SINGLE_MODES_AC);
          break;
        case "101":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.SINGLE_MODES_RC);
          break;
        case "110":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.MODES_AC_PSR);
          break;
        case "111":
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.MODES_RC_PSR);
          break;
        default:
          reportStatus.setReportDetectionEnum(ReportDetectionEnum.NO_DETECTION);
          break;
      }

      String simBit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      reportStatus.setTargetTypeEnum(
          zeroBit.equals(simBit) ? TargetTypeEnum.ACTUAL : TargetTypeEnum.SIMULATED
      );

      String rabBit = ByteUtil.toString(uap.get(index)).substring(4, 5);
      reportStatus.setReportSourceEnum(
          zeroBit.equals(rabBit) ? ReportSourceEnum.TRANSPONDER : ReportSourceEnum.MONITOR
      );

      String tstBit = ByteUtil.toString(uap.get(index)).substring(5, 6);
      reportStatus.setReportTestEnum(
          zeroBit.equals(tstBit) ? ReportTestEnum.REAL : ReportTestEnum.TEST
      );

      return reportStatus;


    }
    return null;
  }

}
