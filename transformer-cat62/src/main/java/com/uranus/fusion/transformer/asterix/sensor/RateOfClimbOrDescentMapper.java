package com.uranus.fusion.transformer.asterix.sensor;

import com.uranus.fusion.transformer.asterix.measure.RateOfClimbOrDescent;
import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * RateOfClimbOrDescentMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class RateOfClimbOrDescentMapper {

  public static RateOfClimbOrDescent read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 20;
    final int length = 2;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      RateOfClimbOrDescent rateOfClimbOrDescent = new RateOfClimbOrDescent();
      int rateValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      rateOfClimbOrDescent.setRate(DecimalUtil.multiply(rateValue, 6.25));
      return rateOfClimbOrDescent;
    }
    return null;
  }

}
