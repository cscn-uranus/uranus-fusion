package com.uranus.fusion.asterix.cat062.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.StandardInstrumentArrival;
import com.uranus.fusion.asterix.uap.flightplan.StandardInstrumentDeparture;
import com.uranus.fusion.util.StringUtil;

import java.util.List;

/**
 * FlightProcedureMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class FlightProcedureMapper {

  public static StandardInstrumentDeparture readDeparture(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 15;
    final int length = 7;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      StandardInstrumentDeparture standardInstrumentDeparture = new StandardInstrumentDeparture();

      String character1 = StringUtil.asciiValueOf(uap.get(index));
      String character2 = StringUtil.asciiValueOf(uap.get(index + 1));
      String character3 = StringUtil.asciiValueOf(uap.get(index + 2));
      String character4 = StringUtil.asciiValueOf(uap.get(index + 3));
      String character5 = StringUtil.asciiValueOf(uap.get(index + 4));
      String character6 = StringUtil.asciiValueOf(uap.get(index + 5));
      String character7 = StringUtil.asciiValueOf(uap.get(index + 6));

      String procedure =
          character1 + character2 + character3 + character4 + character5 + character6 + character7;

      standardInstrumentDeparture.setProcedure(procedure);
      return standardInstrumentDeparture;
    }
    return null;
  }

  public static StandardInstrumentArrival readArrival(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 16;
    final int length = 7;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      StandardInstrumentArrival standardInstrumentArrival = new StandardInstrumentArrival();

      String character1 = StringUtil.asciiValueOf(uap.get(index));
      String character2 = StringUtil.asciiValueOf(uap.get(index + 1));
      String character3 = StringUtil.asciiValueOf(uap.get(index + 2));
      String character4 = StringUtil.asciiValueOf(uap.get(index + 3));
      String character5 = StringUtil.asciiValueOf(uap.get(index + 4));
      String character6 = StringUtil.asciiValueOf(uap.get(index + 5));
      String character7 = StringUtil.asciiValueOf(uap.get(index + 6));

      String procedure =
          character1 + character2 + character3 + character4 + character5 + character6 + character7;

      standardInstrumentArrival.setProcedure(procedure);
      return standardInstrumentArrival;
    }
    return null;
  }
}
