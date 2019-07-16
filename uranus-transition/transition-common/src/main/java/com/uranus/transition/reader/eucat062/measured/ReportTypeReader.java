package com.uranus.transition.reader.eucat062.measured;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.datainfo.*;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class ReportTypeReader {

  public static ReportType read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(MeasuredInformationConfig.REPORT_TYPE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(MeasuredInformationConfig.REPORT_TYPE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(MeasuredInformationConfig.REPORT_TYPE_DRN);

      ReportType reportType = new ReportType();

      String typBits = ByteUtil.toString(uap.get(index)).substring(0, 3);
      switch (typBits) {
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
        case "000":
        default:
          reportType.setReportDetectionEnum(ReportDetectionEnum.NO_DETECTION);
          break;
      }

      String simBit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      reportType.setTargetTypeEnum(
          ByteUtil.ZERO_BIT.equals(simBit) ? TargetTypeEnum.ACTUAL : TargetTypeEnum.SIMULATED);

      String rabBit = ByteUtil.toString(uap.get(index)).substring(4, 5);
      reportType.setReportSourceEnum(
          ByteUtil.ZERO_BIT.equals(rabBit)
              ? ReportSourceEnum.TRANSPONDER
              : ReportSourceEnum.MONITOR);

      String tstBit = ByteUtil.toString(uap.get(index)).substring(5, 6);
      reportType.setReportTestEnum(
          ByteUtil.ZERO_BIT.equals(tstBit) ? ReportTestEnum.REAL : ReportTestEnum.TEST);

      return reportType;
    }
    return null;
  }
}
