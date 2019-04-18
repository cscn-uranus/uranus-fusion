package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.speed.TrueAirspeed;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * SpeedMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class TrueAirspeedMapper {

  public static TrueAirspeed readTrueAirspeed(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.TRUE_AIRSPEED_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TRUE_AIRSPEED_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TRUE_AIRSPEED_DRN);

      TrueAirspeed trueAirspeed = new TrueAirspeed();
      int speedValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      trueAirspeed.setSpeed(DecimalUtil.multiply(speedValue, 1));

      return trueAirspeed;
    }
    return null;
  }
}
