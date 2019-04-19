package com.uranus.fusion.asterix.cat062.mode5.sub;

import com.uranus.fusion.asterix.cat062.mode5.Mode5AndMode1Config;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.emitter.mode5.Mode5Position;
import com.uranus.fusion.asterix.uap.measure.position.Wgs84Position;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * Mode5PositionMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class Mode5PositionMapper {

  public static Mode5Position read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.MODE5_POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.MODE5_POSITION_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.MODE5_POSITION_DRN);

      Mode5Position mode5Position = new Mode5Position();
      Wgs84Position wgs84Position = new Wgs84Position();

      double resolution = DecimalUtil.divide(180, Math.pow(2, 23));

      int latitudeValue =
          IntegerUtil.valueOf(uap.get(index), uap.get(index + 1), uap.get(index + 2));
      double latitude = DecimalUtil.multiply(latitudeValue, resolution);

      int longitudeValue =
          IntegerUtil.valueOf(uap.get(index + 3), uap.get(index + 4), uap.get(index + 5));
      double longitude = DecimalUtil.multiply(longitudeValue, resolution);

      wgs84Position.setLatitude(latitude);
      wgs84Position.setLongitude(longitude);

      mode5Position.setPosition(wgs84Position);
      return mode5Position;
    }
    return null;
  }
}
