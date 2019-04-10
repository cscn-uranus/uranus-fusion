package com.uranus.fusion.asterix.aircraft.nd;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;

/**
 * MagneticHeadingMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class MagneticHeadingMapper {

  public static MagneticHeading read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 3;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      MagneticHeading magneticHeading = new MagneticHeading();

      int degreeValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double resolution = DecimalUtil.divide(360, Math.pow(2, 16));
      double degree = DecimalUtil.multiply(degreeValue, resolution);
      magneticHeading.setDegree(degree);

      return magneticHeading;
    }
    return null;
  }
}
