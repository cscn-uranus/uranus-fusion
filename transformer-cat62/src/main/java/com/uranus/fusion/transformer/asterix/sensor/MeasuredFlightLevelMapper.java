package com.uranus.fusion.transformer.asterix.sensor;

import com.uranus.fusion.transformer.asterix.measure.FlightLevel;
import com.uranus.fusion.transformer.asterix.measure.FlightLevelEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * MeasuredFlightLevelMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class MeasuredFlightLevelMapper {

  public static FlightLevel read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 17;
    final int length = 2;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      FlightLevel measuredFlightLevel = new FlightLevel(FlightLevelEnum.MEASURED);
      int mflValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double flightLevel = DecimalUtil.multiply(mflValue, 0.25);
      measuredFlightLevel.setFl(flightLevel);
      return measuredFlightLevel;
    }
    return null;
  }
}
