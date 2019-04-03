package com.uranus.fusion.transformer.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * Mode5AltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5AltitudeMapper {

  public static Mode5Altitude read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 4;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      Mode5Altitude mode5Altitude = new Mode5Altitude();

      String resBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      mode5Altitude.setAltitudeResolutionEnum(
          zeroBit.equals(resBit)
              ? AltitudeResolutionEnum.FEET_100
              : AltitudeResolutionEnum.FEET_25);

      String altitudeBits1 = ByteUtil.toString(uap.get(index)).substring(2, 8);
      int altitudeValue = IntegerUtil.valueOf(ByteUtil.valueOf(altitudeBits1), uap.get(index + 1));
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