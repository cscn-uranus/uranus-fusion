package com.uranus.fusion.asterix.aircraft.nd;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;

/**
 * VelocityUncertaintyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class VelocityUncertaintyMapper {

  public static VelocityUncertainty readVelocityUncertainty(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 19;
    final int size = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      VelocityUncertainty velocityUncertainty = new VelocityUncertainty();

      velocityUncertainty.setCategory(IntegerUtil.valueOf(uap.get(index)));

      return velocityUncertainty;
    }
    return null;
  }
}
