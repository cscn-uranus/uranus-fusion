package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.RateOfClimbOrDescent;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
class CalculatedRateOfClimbOrDescentReader {

  static RateOfClimbOrDescent read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(EuCat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_SIZE);

      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);

      RateOfClimbOrDescent rateOfClimbOrDescent = new RateOfClimbOrDescent();
      int rateValue = IntegerUtil.signedValueOf(message.get(index), message.get(index + 1));
      rateOfClimbOrDescent.setRate(DecimalUtil.multiply(rateValue, 6.25));
      return rateOfClimbOrDescent;
    }
    return null;
  }
}
