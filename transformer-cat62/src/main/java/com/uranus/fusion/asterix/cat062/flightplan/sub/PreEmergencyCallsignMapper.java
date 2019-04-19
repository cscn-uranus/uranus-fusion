package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.google.common.primitives.Bytes;
import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.PreEmergencyCallsign;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * PreEmergencyCallsignMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public class PreEmergencyCallsignMapper {

  public static PreEmergencyCallsign read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_DRN);

      PreEmergencyCallsign preEmergencyCallsign = new PreEmergencyCallsign();

      byte[] characters =
          Bytes.toArray(
              uap.subList(
                  index, index + FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_SIZE - 1));

      String sign = StringUtil.asciiValueOf(characters);
      preEmergencyCallsign.setSign(sign);
      return preEmergencyCallsign;
    }
    return null;
  }
}
