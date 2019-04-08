package com.uranus.fusion.common.asterix.aircraft.nd;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * PositionUncertaintyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class PositionUncertaintyMapper {

  public static PositionUncertainty readPositionUncertainty(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 24;
    final int size = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      PositionUncertainty positionUncertainty = new PositionUncertainty();

      String positionUncertaintyBits = ByteUtil.toString(uap.get(index)).substring(4, 8);
      positionUncertainty.setCategory(
          IntegerUtil.valueOf(ByteUtil.valueOf(positionUncertaintyBits)));

      return positionUncertainty;
    }
    return null;
  }
}
