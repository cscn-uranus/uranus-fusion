package com.uranus.fusion.transformer.asterix.message.accuracy;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * CartesianPositionCovarianceMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class CartesianPositionCovarianceMapper {

  public static CartesianPositionCovariance read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 2;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      CartesianPositionCovariance cartesianPositionCovariance = new CartesianPositionCovariance();

      int covValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double covariance = DecimalUtil.multiply(covValue, 0.5);

      cartesianPositionCovariance.setCovariance(covariance);

      return cartesianPositionCovariance;
    }
    return null;
  }

}
