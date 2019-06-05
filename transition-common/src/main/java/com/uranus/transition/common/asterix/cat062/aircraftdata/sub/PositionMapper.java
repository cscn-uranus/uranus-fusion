package com.uranus.transition.common.asterix.cat062.aircraftdata.sub;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.position.Wgs84Position;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * PositionMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class PositionMapper {

  public static Wgs84Position read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.POSITION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.POSITION_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.POSITION_DRN);

      Wgs84Position wgs84Position = new Wgs84Position();

      double resolution = DecimalUtil.divide(180, Math.pow(2, 23));

      int latitudeValue =
          IntegerUtil.unsignedValueOf(
              message.get(index), message.get(index + 1), message.get(index + 2));
      double latitude = DecimalUtil.multiply(latitudeValue, resolution);
      wgs84Position.setLatitude(latitude);

      int longitudeValue =
          IntegerUtil.unsignedValueOf(
              message.get(index + 3), message.get(index + 4), message.get(index + 5));
      double longitude = DecimalUtil.multiply(longitudeValue, resolution);
      wgs84Position.setLongitude(longitude);

      return wgs84Position;
    }
    return null;
  }
}
