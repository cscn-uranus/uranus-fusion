package com.uranus.transition.common.asterix.cat062.measured;

import com.uranus.transition.common.asterix.cat062.measured.MeasuredInformationConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.altitude.Measured3dHeight;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
class Measured3dHeightReader {

  public static Measured3dHeight read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(MeasuredInformationConfig.MEASURED_3D_HEIGHT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(MeasuredInformationConfig.MEASURED_3D_HEIGHT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(MeasuredInformationConfig.MEASURED_3D_HEIGHT_DRN);

      Measured3dHeight measured3DHeight = new Measured3dHeight();

      int heightValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double height = DecimalUtil.multiply(heightValue, 25);
      measured3DHeight.setHeight(height);

      return measured3DHeight;
    }
    return null;
  }
}
