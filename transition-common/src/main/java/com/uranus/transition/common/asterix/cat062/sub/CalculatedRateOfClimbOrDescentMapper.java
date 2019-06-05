package com.uranus.transition.common.asterix.cat062.sub;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.measure.altitude.RateOfClimbOrDescent;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedRateOfClimbOrDescentMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class CalculatedRateOfClimbOrDescentMapper {

  public static RateOfClimbOrDescent read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);

      RateOfClimbOrDescent rateOfClimbOrDescent = new RateOfClimbOrDescent();
      int rateValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      rateOfClimbOrDescent.setRate(DecimalUtil.multiply(rateValue, 6.25));
      return rateOfClimbOrDescent;
    }
    return null;
  }
}
