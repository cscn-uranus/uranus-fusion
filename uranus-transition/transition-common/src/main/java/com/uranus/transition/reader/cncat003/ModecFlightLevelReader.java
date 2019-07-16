package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FlightLevel;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2019/6/28
 */
public class ModecFlightLevelReader {

  public static FlightLevel read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.MODEC_FLIGHT_LEVEL_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(CnCat003Config.MODEC_FLIGHT_LEVEL_SIZE);

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.MODEC_FLIGHT_LEVEL_FRN);

      FlightLevel modecFlightLevel = new FlightLevel();

      Byte flValue1 = ByteUtil.signedValueOf(ByteUtil.toString(message.get(index)).substring(2,8));
      Byte flValue2 = ByteUtil.unsignedValueOf(ByteUtil.toString(message.get(index+1)));

      double flValue = IntegerUtil.signedValueOf(flValue1,flValue2).doubleValue();
      double fl = DecimalUtil.multiply(flValue,10);

      modecFlightLevel.setFl(fl);

      return modecFlightLevel;
    }
    return null;
  }
}
