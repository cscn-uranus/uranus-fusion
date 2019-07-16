package com.uranus.transition.reader.eucat062.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.flightplan.RunwayDesignation;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
 class RunwayDesignationReader {

  public static RunwayDesignation read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.RUNWAY_DESIGNATION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.RUNWAY_DESIGNATION_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.RUNWAY_DESIGNATION_DRN);

      RunwayDesignation runwayDesignation = new RunwayDesignation();

      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.RUNWAY_DESIGNATION_SIZE));

      String icaoName = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);
      runwayDesignation.setIcaoName(icaoName);
      return runwayDesignation;
    }
    return null;
  }
}
