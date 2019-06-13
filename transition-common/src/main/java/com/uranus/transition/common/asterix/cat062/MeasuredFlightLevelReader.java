package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.measure.altitude.FlightLevel;
import com.uranus.transition.common.asterix.uap.measure.altitude.FlightLevelEnum;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * MeasuredFlightLevelReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class MeasuredFlightLevelReader {

  public static FlightLevel read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.MEASURED_FLIGHT_LEVEL_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.MEASURED_FLIGHT_LEVEL_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.MEASURED_FLIGHT_LEVEL_FRN);

      FlightLevel measuredFlightLevel = new FlightLevel(FlightLevelEnum.MEASURED);
      int mflValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double flightLevel = DecimalUtil.multiply(mflValue, 0.25);
      measuredFlightLevel.setFl(flightLevel);
      return measuredFlightLevel;
    }
    return null;
  }
}
