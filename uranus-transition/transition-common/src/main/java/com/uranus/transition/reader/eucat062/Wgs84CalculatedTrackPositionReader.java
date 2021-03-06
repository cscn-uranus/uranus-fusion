package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.position.Wgs84Position;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
class Wgs84CalculatedTrackPositionReader {

  static Wgs84Position read(List<Byte> uap, FieldSpec fieldSpec) {

    // Calculated Track Position (WGS-84): frn=5, size=8
    final int frn = EuCat062Config.WGS84_CALCULATED_TRACK_POSITION_FRN;
    final int size = EuCat062Config.WGS84_CALCULATED_TRACK_POSITION_SIZE;

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      // 固定长度
      fpIndicator.setSize(size);

      int index = fieldSpec.calculateIndexByFrn(frn);

      // resolution
      double resolution = DecimalUtil.divide(180, Math.pow(2, 25));

      // latitude value
      int latitudeValue =
          IntegerUtil.signedValueOf(
              uap.get(index), uap.get(index + 1), uap.get(index + 2), uap.get(index + 3));
      double latitude = DecimalUtil.multiply(latitudeValue, resolution);

      // longitude value
      int longitudeValue =
          IntegerUtil.signedValueOf(
              uap.get(index + 4), uap.get(index + 5), uap.get(index + 6), uap.get(index + 7));
      double longitude = DecimalUtil.multiply(longitudeValue, resolution);

      Wgs84Position position = new Wgs84Position();
      position.setLatitude(latitude);
      position.setLongitude(longitude);
      return position;
    }
    return null;
  }
}
