package com.uranus.transition.reader.eucat062.mode5;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode5.Mode5Position;
import com.uranus.transition.common.asterix.uap.shared.measure.position.Wgs84Position;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
 class Mode5PositionReader {

  public static Mode5Position read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.MODE5_POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.MODE5_POSITION_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.MODE5_POSITION_DRN);

      Mode5Position mode5Position = new Mode5Position();
      Wgs84Position wgs84Position = new Wgs84Position();

      double resolution = DecimalUtil.divide(180, Math.pow(2, 23));

      int latitudeValue =
          IntegerUtil.unsignedValueOf(
              message.get(index), message.get(index + 1), message.get(index + 2));
      double latitude = DecimalUtil.multiply(latitudeValue, resolution);

      int longitudeValue =
          IntegerUtil.unsignedValueOf(
              message.get(index + 3), message.get(index + 4), message.get(index + 5));
      double longitude = DecimalUtil.multiply(longitudeValue, resolution);

      wgs84Position.setLatitude(latitude);
      wgs84Position.setLongitude(longitude);

      mode5Position.setPosition(wgs84Position);
      return mode5Position;
    }
    return null;
  }
}
