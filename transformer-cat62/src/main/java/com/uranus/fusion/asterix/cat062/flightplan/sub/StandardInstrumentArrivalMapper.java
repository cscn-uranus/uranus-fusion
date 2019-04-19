package com.uranus.fusion.asterix.cat062.flightplan.sub;

import com.google.common.primitives.Bytes;
import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.StandardInstrumentArrival;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * StandardInstrumentArrivalMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class StandardInstrumentArrivalMapper {

  public static StandardInstrumentArrival read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_DRN);

      StandardInstrumentArrival standardInstrumentArrival = new StandardInstrumentArrival();

      byte[] characters =
          Bytes.toArray(
              uap.subList(
                  index, index + FlightPlanRelatedDataConfig.STANDARD_INSTRUMENT_ARRIVAL_SIZE - 1));

      String procedure = StringUtil.asciiValueOf(characters);

      standardInstrumentArrival.setProcedure(procedure);
      return standardInstrumentArrival;
    }
    return null;
  }
}
