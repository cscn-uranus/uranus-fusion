package com.uranus.transition.reader.eucat062.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.flightplan.WakeTurbulenceCategory;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
 class WakeTurbulenceCategoryReader {

  public static WakeTurbulenceCategory read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.WAKE_TURBULENCE_CATEGORY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.WAKE_TURBULENCE_CATEGORY_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.WAKE_TURBULENCE_CATEGORY_DRN);

      WakeTurbulenceCategory wakeTurbulenceCategory = new WakeTurbulenceCategory();

      String category =
          StringUtil.standardAsciiValueOf(ByteUtil.toString(uap.get(index)), ByteUtil.BITS_OF_BYTE);

      wakeTurbulenceCategory.setCategory(category);
      return wakeTurbulenceCategory;
    }
    return null;
  }
}
