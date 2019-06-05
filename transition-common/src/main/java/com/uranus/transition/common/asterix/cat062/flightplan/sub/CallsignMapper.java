package com.uranus.transition.common.asterix.cat062.flightplan.sub;

import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.flightplan.Callsign;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * CallsignMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public class CallsignMapper {

  public static Callsign read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.CALLSIGN_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.CALLSIGN_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.CALLSIGN_DRN);

      Callsign callsign = new Callsign();

      String bitString =
          ByteUtil.toString(
              message.subList(index, index + FlightPlanRelatedDataConfig.CALLSIGN_SIZE));

      String sign = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);
      callsign.setSign(sign);
      return callsign;
    }
    return null;
  }
}
