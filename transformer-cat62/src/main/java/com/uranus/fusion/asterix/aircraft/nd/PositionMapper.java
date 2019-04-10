package com.uranus.fusion.asterix.aircraft.nd;

import com.uranus.fusion.asterix.measure.Wgs84Position;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;

/**
 * PositionMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class PositionMapper {

  public static Wgs84Position readPosition(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 22;
    final int length = 6;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      Wgs84Position wgs84Position = new Wgs84Position();

      double resolution = DecimalUtil.divide(180, Math.pow(2, 23));

      int latitudeValue =
          IntegerUtil.valueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2));
      double latitude = DecimalUtil.multiply(latitudeValue, resolution);
      wgs84Position.setLatitude(latitude);

      int longitudeValue =
          IntegerUtil.valueOf(uap.get(index + 3), uap.get(index + 4), uap.get(index + 5));
      double longitude = DecimalUtil.multiply(longitudeValue, resolution);
      wgs84Position.setLongitude(longitude);

      return wgs84Position;
    }
    return null;
  }
}
