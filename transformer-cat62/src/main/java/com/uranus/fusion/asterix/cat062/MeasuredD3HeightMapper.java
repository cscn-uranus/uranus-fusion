package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.altitude.Measured3DHeight;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * MeasuredD3HeightMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class MeasuredD3HeightMapper {

  public static Measured3DHeight read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 3;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      Measured3DHeight measured3DHeight = new Measured3DHeight();

      int heightValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double height = DecimalUtil.multiply(heightValue, 25);
      measured3DHeight.setHeight(height);

      return measured3DHeight;
    }
    return null;
  }
}
