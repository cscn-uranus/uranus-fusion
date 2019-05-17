package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.flightplan.StandardInstrumentArrival;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.StringUtil;

import java.util.List;

/**
 * StandardInstrumentArrivalMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class StandardInstrumentArrivalMapper {

  public static StandardInstrumentArrival read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_DRN);

      StandardInstrumentArrival standardInstrumentArrival = new StandardInstrumentArrival();

      String bitString =
          ByteUtil.toString(
              message.subList(
                  index, index + FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_SIZE));

      String procedure = StringUtil.standardAsciiValueOf(bitString, ByteUtil.BITS_OF_BYTE);
      standardInstrumentArrival.setProcedure(procedure);
      return standardInstrumentArrival;
    }
    return null;
  }
}
