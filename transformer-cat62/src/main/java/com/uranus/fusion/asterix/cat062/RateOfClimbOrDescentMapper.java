package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.measure.altitude.RateOfClimbOrDescent;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * RateOfClimbOrDescentMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class RateOfClimbOrDescentMapper {

  public static RateOfClimbOrDescent read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.getFpIndicator(Cat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.CALCULATED_RATE_OF_CLIMB_DESCENT_FRN);

      RateOfClimbOrDescent rateOfClimbOrDescent = new RateOfClimbOrDescent();
      int rateValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      rateOfClimbOrDescent.setRate(DecimalUtil.multiply(rateValue, 6.25));
      return rateOfClimbOrDescent;
    }
    return null;
  }
}
