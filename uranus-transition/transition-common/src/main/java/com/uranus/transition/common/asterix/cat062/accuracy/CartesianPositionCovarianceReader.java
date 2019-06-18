package com.uranus.transition.common.asterix.cat062.accuracy;

import com.uranus.transition.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.accuracy.CartesianPositionCovariance;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * CartesianPositionCovarianceReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class CartesianPositionCovarianceReader {

  public static CartesianPositionCovariance read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(EstimatedAccuracyConfig.CARTESIAN_COVARIANCE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.CARTESIAN_COVARIANCE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.CARTESIAN_COVARIANCE_DRN);

      CartesianPositionCovariance cartesianPositionCovariance = new CartesianPositionCovariance();

      int covValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double covariance = DecimalUtil.multiply(covValue, 0.5);

      cartesianPositionCovariance.setCovariance(covariance);

      return cartesianPositionCovariance;
    }
    return null;
  }
}
