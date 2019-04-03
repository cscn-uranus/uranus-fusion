package com.uranus.fusion.transformer.asterix.message.accuracy;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * Wgs84PositionAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class Wgs84PositionAccuracyMapper {

  public static Wgs84PositionAccuracy read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 3;
    final int size = 4;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      Wgs84PositionAccuracy wgs84PositionAccuracy = new Wgs84PositionAccuracy();

      double resolution = DecimalUtil.divide(180, Math.pow(2, 25));

      double latitudeAccuracy =
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index), uap.get(index + 1)), resolution);
      wgs84PositionAccuracy.setAccuracyLatitude(latitudeAccuracy);

      double longitudeAccuracy =
          DecimalUtil.multiply(
              IntegerUtil.valueOf(uap.get(index + 2), uap.get(index + 3)), resolution);
      wgs84PositionAccuracy.setAccuracyLongitude(longitudeAccuracy);

      return wgs84PositionAccuracy;
    }
    return null;
  }
}
