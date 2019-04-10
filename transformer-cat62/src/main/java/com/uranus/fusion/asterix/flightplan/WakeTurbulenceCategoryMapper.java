package com.uranus.fusion.asterix.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.StringUtil;

import java.util.List;

/**
 * WakeTurbulenceCategoryMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class WakeTurbulenceCategoryMapper {

  public static WakeTurbulenceCategory readDepartureAirport(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 6;
    final int length = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      WakeTurbulenceCategory wakeTurbulenceCategory = new WakeTurbulenceCategory();

      String category = StringUtil.asciiValueOf(uap.get(index));

      wakeTurbulenceCategory.setCategory(category);
      return wakeTurbulenceCategory;
    }
    return null;
  }
}
