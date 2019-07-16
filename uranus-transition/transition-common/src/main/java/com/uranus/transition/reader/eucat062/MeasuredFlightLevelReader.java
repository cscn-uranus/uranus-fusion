package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FlightLevel;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * MeasuredFlightLevelReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class MeasuredFlightLevelReader {

  static FlightLevel read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.MEASURED_FLIGHT_LEVEL_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(EuCat062Config.MEASURED_FLIGHT_LEVEL_SIZE);

      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.MEASURED_FLIGHT_LEVEL_FRN);

      FlightLevel measuredFlightLevel = new FlightLevel();
      int mflValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double flightLevel = DecimalUtil.multiply(mflValue, 0.25);
      measuredFlightLevel.setFl(flightLevel);
      return measuredFlightLevel;
    }
    return null;
  }
}
