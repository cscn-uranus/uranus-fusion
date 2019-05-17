package com.uranus.fusion.common.asterix.cat062.flightplan.sub;

import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.flightplan.WakeTurbulenceCategory;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.StringUtil;

import java.util.List;

/**
 * WakeTurbulenceCategoryMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class WakeTurbulenceCategoryMapper {

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
