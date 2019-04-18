package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.measure.altitude.FlightLevel;
import com.uranus.fusion.asterix.uap.measure.altitude.FlightLevelEnum;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * MeasuredFlightLevelMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class MeasuredFlightLevelMapper {

  public static FlightLevel read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.MEASURED_FLIGHT_LEVEL_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.MEASURED_FLIGHT_LEVEL_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.MEASURED_FLIGHT_LEVEL_FRN);

      FlightLevel measuredFlightLevel = new FlightLevel(FlightLevelEnum.MEASURED);
      int mflValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double flightLevel = DecimalUtil.multiply(mflValue, 0.25);
      measuredFlightLevel.setFl(flightLevel);
      return measuredFlightLevel;
    }
    return null;
  }
}
