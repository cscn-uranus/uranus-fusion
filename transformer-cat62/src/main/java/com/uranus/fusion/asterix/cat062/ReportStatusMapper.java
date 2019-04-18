package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.datainfo.*;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * ReportStatusMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class ReportStatusMapper {

  public static ReportType read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 6;
    final int size = 1;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      ReportType reportType = new ReportType();

      String typBits = ByteUtil.toString(uap.get(index)).substring(0, 3);
      switch (typBits) {
        case "000":
          reportType.setReportDetectionEnum(ReportDetectionEnum.NO_DETECTION);
          break;
        case "001":
          reportType.setReportDetectionEnum(ReportDetectionEnum.SINGLE_PSR);
          break;
        case "010":
          reportType.setReportDetectionEnum(ReportDetectionEnum.SINGLE_SSR);
          break;
        case "011":
          reportType.setReportDetectionEnum(ReportDetectionEnum.SSR_PSR);
          break;
        case "100":
          reportType.setReportDetectionEnum(ReportDetectionEnum.SINGLE_MODES_AC);
          break;
        case "101":
          reportType.setReportDetectionEnum(ReportDetectionEnum.SINGLE_MODES_RC);
          break;
        case "110":
          reportType.setReportDetectionEnum(ReportDetectionEnum.MODES_AC_PSR);
          break;
        case "111":
          reportType.setReportDetectionEnum(ReportDetectionEnum.MODES_RC_PSR);
          break;
        default:
          reportType.setReportDetectionEnum(ReportDetectionEnum.NO_DETECTION);
          break;
      }

      String simBit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      reportType.setTargetTypeEnum(
          zeroBit.equals(simBit) ? TargetTypeEnum.ACTUAL : TargetTypeEnum.SIMULATED);

      String rabBit = ByteUtil.toString(uap.get(index)).substring(4, 5);
      reportType.setReportSourceEnum(
          zeroBit.equals(rabBit) ? ReportSourceEnum.TRANSPONDER : ReportSourceEnum.MONITOR);

      String tstBit = ByteUtil.toString(uap.get(index)).substring(5, 6);
      reportType.setReportTestEnum(
          zeroBit.equals(tstBit) ? ReportTestEnum.REAL : ReportTestEnum.TEST);

      return reportType;
    }
    return null;
  }
}
