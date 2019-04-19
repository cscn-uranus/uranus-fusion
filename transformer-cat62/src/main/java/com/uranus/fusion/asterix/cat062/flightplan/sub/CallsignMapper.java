package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.google.common.primitives.Bytes;
import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.Callsign;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * CallsignMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public class CallsignMapper {

  public static Callsign read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.CALLSIGN_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.CALLSIGN_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.CALLSIGN_DRN);

      Callsign callsign = new Callsign();

      byte[] characters =
          Bytes.toArray(uap.subList(index, index + FlightPlanRelatedDataConfig.CALLSIGN_SIZE - 1));

      String sign = StringUtil.asciiValueOf(characters);

      callsign.setSign(sign);
      return callsign;
    }
    return null;
  }
}
