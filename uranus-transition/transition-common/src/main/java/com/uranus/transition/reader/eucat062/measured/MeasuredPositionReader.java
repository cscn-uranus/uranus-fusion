package com.uranus.transition.reader.eucat062.measured;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.position.MeasuredPosition;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class MeasuredPositionReader {

  public static MeasuredPosition read(List<Byte> uap, DataSpec dataSpec) {
    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(MeasuredInformationConfig.MEASURED_POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(MeasuredInformationConfig.MEASURED_POSITION_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(MeasuredInformationConfig.MEASURED_POSITION_DRN);

      MeasuredPosition measuredPosition = new MeasuredPosition();

      int rhoValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double rhoResolution = DecimalUtil.divide(1, 256);
      double rho = DecimalUtil.multiply(rhoValue, rhoResolution);
      measuredPosition.setRho(rho);

      int thetaValue = IntegerUtil.unsignedValueOf(uap.get(index + 2), uap.get(index + 3));
      double thetaResolution = DecimalUtil.divide(360, Math.pow(2, 16));
      double theta = DecimalUtil.multiply(thetaValue, thetaResolution);
      measuredPosition.setTheta(theta);

      return measuredPosition;
    }
    return null;
  }
}
