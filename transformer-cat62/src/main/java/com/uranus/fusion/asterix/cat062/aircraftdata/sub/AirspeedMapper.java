package com.uranus.fusion.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.speed.Airspeed;
import com.uranus.fusion.asterix.uap.measure.speed.SpeedTypeEnum;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * SpeedMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class AirspeedMapper {

  public static Airspeed readAirspeed(List<Byte> uap, DataSpec dataSpec) {
    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.AIRSPEED_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.AIRSPEED_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.AIRSPEED_DRN);

      String airspeedTypeValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      String speedValue1 = ByteUtil.toString(uap.get(index)).substring(1, 8);
      String speedValue2 = ByteUtil.toString(uap.get(index + 1));

      int speedValue =
          IntegerUtil.valueOf(ByteUtil.valueOf(speedValue1), ByteUtil.valueOf(speedValue2));

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
