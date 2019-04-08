package com.uranus.fusion.common.asterix.aircraft.transponder.acas;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;

import java.util.List;

/**
 * AcasResolutionReportMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class AcasResolutionReportMapper {

  public static AcasResolutionReport readAcasResolutionAdvisoryReport(List<Byte> uap,
      DataSpec dataSpec) {
    final int drn = 12;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(7);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

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
