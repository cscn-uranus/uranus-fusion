package com.uranus.fusion.common.asterix.sensor.info;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;
import java.util.List;

/**
 * MeasuredPositionMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class MeasuredPositionMapper {

  public static MeasuredPosition read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 2;
    final int size = 4;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      MeasuredPosition measuredPosition = new MeasuredPosition();

      int rhoValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double rhoResolution = DecimalUtil.divide(1, 256);
      double rho = DecimalUtil.multiply(rhoValue, rhoResolution);
      measuredPosition.setRho(rho);

      int thetaValue = IntegerUtil.valueOf(uap.get(index + 2), uap.get(index + 3));
      double thetaResolution = DecimalUtil.divide(360, Math.pow(2, 16));
      double theta = DecimalUtil.multiply(thetaValue, thetaResolution);
      measuredPosition.setTheta(theta);

      return measuredPosition;
    }
    return null;
  }

}
