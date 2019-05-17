package com.uranus.fusion.common.asterix.cat062.accuracy.sub;

import com.uranus.fusion.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.accuracy.CartesianPositionCovariance;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * CartesianPositionCovarianceMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class CartesianPositionCovarianceMapper {

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
