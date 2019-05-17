package com.uranus.fusion.common.asterix.cat062.accuracy.sub;

import com.uranus.fusion.common.asterix.cat062.accuracy.EstimatedAccuracyConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.accuracy.Wgs84PositionAccuracy;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * Wgs84PositionAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class Wgs84PositionAccuracyMapper {

  public static Wgs84PositionAccuracy read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(EstimatedAccuracyConfig.WGS84_POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(EstimatedAccuracyConfig.WGS84_POSITION_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(EstimatedAccuracyConfig.WGS84_POSITION_DRN);

      Wgs84PositionAccuracy wgs84PositionAccuracy = new Wgs84PositionAccuracy();

      double resolution = DecimalUtil.divide(180, Math.pow(2, 25));

      double latitudeAccuracy =
          DecimalUtil.multiply(
              IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1)), resolution);
      wgs84PositionAccuracy.setAccuracyLatitude(latitudeAccuracy);

      double longitudeAccuracy =
          DecimalUtil.multiply(
              IntegerUtil.unsignedValueOf(uap.get(index + 2), uap.get(index + 3)), resolution);
      wgs84PositionAccuracy.setAccuracyLongitude(longitudeAccuracy);

      return wgs84PositionAccuracy;
    }
    return null;
  }
}
