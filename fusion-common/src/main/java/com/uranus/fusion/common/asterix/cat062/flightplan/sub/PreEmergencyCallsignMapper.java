package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.flightplan.PreEmergencyCallsign;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.StringUtil;

import java.util.List;

/**
 * PreEmergencyCallsignMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public class PreEmergencyCallsignMapper {

  public static PreEmergencyCallsign read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_DRN);

      PreEmergencyCallsign preEmergencyCallsign = new PreEmergencyCallsign();
      String bitString =
          ByteUtil.toString(
              message.subList(
                  index, index + FlightPlanRelatedDataConfig.PRE_EMERGENCY_CALLSIGN_SIZE));

      String sign = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);
      preEmergencyCallsign.setSign(sign);
      return preEmergencyCallsign;
    }
    return null;
  }
}
