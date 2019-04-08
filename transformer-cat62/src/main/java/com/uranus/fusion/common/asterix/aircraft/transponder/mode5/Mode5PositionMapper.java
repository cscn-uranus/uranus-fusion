package com.uranus.fusion.common.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.common.asterix.measure.Wgs84Position;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * Mode5PositionMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5PositionMapper {

  public static Mode5Position read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 3;
    final int size = 6;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      Mode5Position mode5Position = new Mode5Position();
      Wgs84Position wgs84Position = new Wgs84Position();

      double resolution = DecimalUtil.divide(180, Math.pow(2, 23));

      int latitudeValue = IntegerUtil
          .valueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2));
      double latitude = DecimalUtil.multiply(latitudeValue, resolution);

      int longitudeValue = IntegerUtil
          .valueOf(uap.get(index + 3), uap.get(index + 4), uap.get(index + 5));
      double longitude = DecimalUtil.multiply(longitudeValue, resolution);

      wgs84Position.setLatitude(latitude);
      wgs84Position.setLongitude(longitude);

      mode5Position.setPosition(wgs84Position);
      return mode5Position;
    }
    return null;
  }
}
