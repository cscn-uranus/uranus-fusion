package com.uranus.transition.common.asterix.cat062.aircraftdata.sub;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.speed.Airspeed;
import com.uranus.transition.common.asterix.uap.measure.speed.SpeedTypeEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * SpeedMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class AirspeedMapper {

  public static Airspeed read(List<Byte> message, DataSpec dataSpec) {
    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.AIRSPEED_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.AIRSPEED_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.AIRSPEED_DRN);

      String airspeedTypeValue = ByteUtil.toString(message.get(index)).substring(0, 1);
      String speedValue1 = ByteUtil.toString(message.get(index)).substring(1, 8);
      String speedValue2 = ByteUtil.toString(message.get(index + 1));

      int speedValue =
          IntegerUtil.unsignedValueOf(
              ByteUtil.unsignedValueOf(speedValue1), ByteUtil.unsignedValueOf(speedValue2));

      if (ByteUtil.ZERO_BIT.equals(airspeedTypeValue)) {
        Airspeed airspeed = new Airspeed(SpeedTypeEnum.KNOT);
        double resolution = DecimalUtil.divide(1, Math.pow(2, 14));
        airspeed.setSpeed(DecimalUtil.multiply(speedValue, resolution));

        return airspeed;
      } else {
        Airspeed airspeed = new Airspeed(SpeedTypeEnum.MACH);
        double resolution = DecimalUtil.divide(1, 1000);
        airspeed.setSpeed(DecimalUtil.multiply(speedValue, resolution));

        return airspeed;
      }
    }
    return null;
  }
}
