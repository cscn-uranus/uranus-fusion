package com.uranus.transition.reader.eucat062.mode5;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode5.Mode5Altitude;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.AltitudeResolutionEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
 class Mode5AltitudeReader {

  public static Mode5Altitude read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.MODE5_ALTITUDE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.MODE5_ALTITUDE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.MODE5_ALTITUDE_DRN);

      Mode5Altitude mode5Altitude = new Mode5Altitude();

      String resBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      mode5Altitude.setAltitudeResolutionEnum(
          ByteUtil.ZERO_BIT.equals(resBit)
              ? AltitudeResolutionEnum.FEET_100
              : AltitudeResolutionEnum.FEET_25);

      String altitudeBits1 = ByteUtil.toString(uap.get(index)).substring(2, 8);
      int altitudeValue =
          IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(altitudeBits1), uap.get(index + 1));
      double altitude;
      switch (mode5Altitude.getAltitudeResolutionEnum()) {
        case FEET_25:
          altitude = DecimalUtil.multiply(altitudeValue, 25);
          mode5Altitude.setAltitude(altitude);
          break;
        case FEET_100:
          altitude = DecimalUtil.multiply(altitudeValue, 100);
          mode5Altitude.setAltitude(altitude);
          break;
        default:
          altitude = 0;
          mode5Altitude.setAltitude(altitude);
      }
      return mode5Altitude;
    }
    return null;
  }
}
