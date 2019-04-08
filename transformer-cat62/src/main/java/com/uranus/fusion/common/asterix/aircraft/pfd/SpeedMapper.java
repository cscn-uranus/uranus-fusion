package com.uranus.fusion.common.asterix.aircraft.pfd;

import com.uranus.fusion.common.asterix.measure.GroundSpeed;
import com.uranus.fusion.common.asterix.measure.IndicatedAirspeed;
import com.uranus.fusion.common.asterix.measure.SpeedUnitEnum;
import com.uranus.fusion.common.asterix.measure.TrueAirspeed;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * SpeedMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class SpeedMapper {

  public static IndicatedAirspeed readIndicatedAirspeed(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 4;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      String airspeedTypeValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      String speedValue1 = ByteUtil.toString(uap.get(index)).substring(1, 8);
      String speedValue2 = ByteUtil.toString(uap.get(index + 1));

      int speedValue =
          IntegerUtil.valueOf(ByteUtil.valueOf(speedValue1), ByteUtil.valueOf(speedValue2));

      if (zeroBit.equals(airspeedTypeValue)) {
        IndicatedAirspeed indicatedAirspeed = new IndicatedAirspeed(SpeedUnitEnum.KNOT);
        double resolution = DecimalUtil.divide(1, Math.pow(2, 14));
        indicatedAirspeed.setSpeed(DecimalUtil.multiply(speedValue, resolution));

        return indicatedAirspeed;
      } else {
        IndicatedAirspeed indicatedAirspeed = new IndicatedAirspeed(SpeedUnitEnum.MACH);
        double resolution = DecimalUtil.divide(1, 1000);
        indicatedAirspeed.setSpeed(DecimalUtil.multiply(speedValue, resolution));

        return indicatedAirspeed;
      }
    }
    return null;
  }

  public static TrueAirspeed readTrueAirspeed(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 5;
    final int length = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      TrueAirspeed trueAirspeed = new TrueAirspeed();
      int speedValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      trueAirspeed.setSpeed(DecimalUtil.multiply(speedValue, 1));

      return trueAirspeed;
    }
    return null;
  }

  public static GroundSpeed readGroundSpeed(List<Byte> uap, DataSpec dataSpec) {
    final int frn = 18;
    final int length = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(frn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(frn);

      int groundSpeedValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double resolution = DecimalUtil.divide(1, Math.pow(2, 14));

      GroundSpeed groundSpeed = new GroundSpeed();
      groundSpeed.setSpeed(DecimalUtil.multiply(groundSpeedValue, resolution));
      return groundSpeed;
    }
    return null;
  }

  public static IndicatedAirspeed readIndicatedAirSpeedOfKt(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 26;
    final int length = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      dpIndicator.setSize(length);
      IndicatedAirspeed indicatedAirspeed = new IndicatedAirspeed(SpeedUnitEnum.KNOT);
      double speed =
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index), uap.get(index + 1)), 1);
      indicatedAirspeed.setSpeed(speed);
      return indicatedAirspeed;
    }
    return null;
  }

  public static IndicatedAirspeed readIndicatedAirspeedOfMach(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 27;
    final int length = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      dpIndicator.setSize(length);
      IndicatedAirspeed indicatedAirspeed = new IndicatedAirspeed(SpeedUnitEnum.MACH);
      double speed =
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index), uap.get(index + 1)), 0.008);
      indicatedAirspeed.setSpeed(speed);
      return indicatedAirspeed;
    }
    return null;
  }
}
