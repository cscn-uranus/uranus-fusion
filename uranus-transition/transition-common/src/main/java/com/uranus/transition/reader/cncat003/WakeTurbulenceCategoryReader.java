package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.flightplan.ControlledStatus;
import com.uranus.transition.common.asterix.uap.shared.flightplan.WakeTurbulenceCategory;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/7/4
 */
public class WakeTurbulenceCategoryReader {
  public static WakeTurbulenceCategory read(List<Byte> message, FieldSpec fieldSpec) {
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.WAKE_TURBULENCE_CATEGORY_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      fpIndicator.setSize(CnCat003Config.WAKE_TURBULENCE_CATEGORY_SIZE);

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.WAKE_TURBULENCE_CATEGORY_FRN);
      WakeTurbulenceCategory wakeTurbulenceCategory = new WakeTurbulenceCategory();

      String category = StringUtil.standardAsciiValueOf(
        ByteUtil.toString(message.get(index)),ByteUtil.BITS_OF_BYTE
      );
      wakeTurbulenceCategory.setCategory(category);
      return wakeTurbulenceCategory;

    }
    return null;
  }
}
