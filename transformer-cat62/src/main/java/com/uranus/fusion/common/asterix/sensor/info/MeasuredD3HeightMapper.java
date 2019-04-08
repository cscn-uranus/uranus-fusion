package com.uranus.fusion.common.asterix.sensor.info;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;
import java.util.List;

/**
 * MeasuredD3HeightMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class MeasuredD3HeightMapper {

  public static MeasuredD3Height read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 3;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      MeasuredD3Height measuredD3Height = new MeasuredD3Height();

      int heightValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double height = DecimalUtil.multiply(heightValue, 25);
      measuredD3Height.setHeight(height);

      return measuredD3Height;
    }
    return null;
  }

}
