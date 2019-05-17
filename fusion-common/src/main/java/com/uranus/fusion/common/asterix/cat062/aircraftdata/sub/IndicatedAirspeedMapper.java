package com.uranus.fusion.common.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.speed.Airspeed;
import com.uranus.fusion.common.asterix.uap.measure.speed.SpeedTypeEnum;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * SpeedMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class IndicatedAirspeedMapper {

  public static Airspeed read(List<Byte> message, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.INDICATED_AIRSPEED_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.INDICATED_AIRSPEED_DRN);

      dpIndicator.setSize(AircraftDerivedDataConfig.INDICATED_AIRSPEED_SIZE);
      Airspeed airspeed = new Airspeed(SpeedTypeEnum.KNOT);
      double speed =
          DecimalUtil.multiply(
              IntegerUtil.unsignedValueOf(message.get(index), message.get(index + 1)), 1);
      airspeed.setSpeed(speed);
      return airspeed;
    }
    return null;
  }
}
