package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.RateOfClimbOrDescent;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/7/4
 */
public class CalculatedRateOfClimbOrDescentReader {
  public static RateOfClimbOrDescent read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(CnCat003Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(CnCat003Config.CALCULATED_RATE_OF_CLIMB_DESCENT_SIZE);

      int index =
          fieldSpec.calculateIndexByFrn(CnCat003Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);

      RateOfClimbOrDescent rateOfClimbOrDescent = new RateOfClimbOrDescent();
      int rateValue = IntegerUtil.signedValueOf(message.get(index), message.get(index + 1));
      rateOfClimbOrDescent.setRate(DecimalUtil.multiply(rateValue, 0.1));
      return rateOfClimbOrDescent;
    }
    return null;
  }
}
