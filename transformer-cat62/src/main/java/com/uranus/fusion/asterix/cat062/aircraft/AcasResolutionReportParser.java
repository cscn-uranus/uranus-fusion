package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.comm.AcasResolutionReport;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * AcasResolutionReportParser
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class AcasResolutionReportParser {

  public static AcasResolutionReport readAcasResolutionAdvisoryReport(
      List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.ACAS_RESOLUTION_ADVISORY_REPORT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.ACAS_RESOLUTION_ADVISORY_REPORT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              AircraftDerivedDataConfig.ACAS_RESOLUTION_ADVISORY_REPORT_DRN);

      AcasResolutionReport acasResolutionReport = new AcasResolutionReport();

      String bdsBits =
          ByteUtil.toString(uap.get(index))
              + ByteUtil.toString(uap.get(index + 1))
              + ByteUtil.toString(uap.get(index + 2))
              + ByteUtil.toString(uap.get(index + 3))
              + ByteUtil.toString(uap.get(index + 4))
              + ByteUtil.toString(uap.get(index + 5))
              + ByteUtil.toString(uap.get(index + 6));
      acasResolutionReport.setBds(bdsBits);

      return acasResolutionReport;
    }
    return null;
  }
}
