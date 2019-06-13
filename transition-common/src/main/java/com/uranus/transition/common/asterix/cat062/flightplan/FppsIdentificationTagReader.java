package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
 class FppsIdentificationTagReader {

  public static SystemIdentification read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.FPPS_IDENTIFICATION_TAG_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.FPPS_IDENTIFICATION_TAG_SIZE);

      SystemIdentification fppsIdentificationTag = new SystemIdentification();
      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.FPPS_IDENTIFICATION_TAG_DRN);
      String systemAreaCode = ByteUtil.toString(uap.get(index));
      String systemIdentityCode = ByteUtil.toString(uap.get(index + 1));

      fppsIdentificationTag.setSac(systemAreaCode);
      fppsIdentificationTag.setSic(systemIdentityCode);

      return fppsIdentificationTag;
    }
    return null;
  }
}
