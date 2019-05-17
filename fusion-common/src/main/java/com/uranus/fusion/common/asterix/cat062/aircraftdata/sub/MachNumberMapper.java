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
public class MachNumberMapper {

  public static Airspeed read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.MACH_NUMBER_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.MACH_NUMBER_DRN);

      dpIndicator.setSize(AircraftDerivedDataConfig.MACH_NUMBER_SIZE);
      Airspeed airspeed = new Airspeed(SpeedTypeEnum.MACH);
      double speed =
          DecimalUtil.multiply(
              IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1)), 0.008);
      airspeed.setSpeed(speed);
      return airspeed;
    }
    return null;
  }
}
