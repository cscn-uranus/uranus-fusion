package com.uranus.fusion.common.asterix.cat062.measured.sub;

import com.uranus.fusion.common.asterix.cat062.measured.MeasuredInformationConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.altitude.Measured3DHeight;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * Measured3DHeightMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class Measured3DHeightMapper {

  public static Measured3DHeight read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(MeasuredInformationConfig.MEASURED_3D_HEIGHT_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(MeasuredInformationConfig.MEASURED_3D_HEIGHT_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(MeasuredInformationConfig.MEASURED_3D_HEIGHT_DRN);

      Measured3DHeight measured3DHeight = new Measured3DHeight();

      int heightValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double height = DecimalUtil.multiply(heightValue, 25);
      measured3DHeight.setHeight(height);

      return measured3DHeight;
    }
    return null;
  }
}
