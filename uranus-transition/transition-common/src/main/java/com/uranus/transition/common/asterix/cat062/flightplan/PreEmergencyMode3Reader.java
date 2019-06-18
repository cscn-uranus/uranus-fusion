package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.datainfo.DataValidEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.PreEmergencyMode3;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
 class PreEmergencyMode3Reader {

  public static PreEmergencyMode3 read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.PRE_EMERGENCY_MODE3A_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.PRE_EMERGENCY_MODE3A_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.PRE_EMERGENCY_MODE3A_DRN);

      PreEmergencyMode3 preEmergencyMode3 = new PreEmergencyMode3();

      String vaBit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      preEmergencyMode3.setDataValidEnum(
          ByteUtil.ZERO_BIT.equals(vaBit) ? DataValidEnum.NOT_VALID : DataValidEnum.VALID);

      String codeBits =
          ByteUtil.toString(uap.get(index)).substring(3, 7) + ByteUtil.toString(uap.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);

      preEmergencyMode3.setCode(code);
      return preEmergencyMode3;
    }
    return null;
  }
}
