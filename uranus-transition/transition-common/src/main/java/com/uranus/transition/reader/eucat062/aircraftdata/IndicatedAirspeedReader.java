package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.Airspeed;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.SpeedTypeEnum;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class IndicatedAirspeedReader {

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
