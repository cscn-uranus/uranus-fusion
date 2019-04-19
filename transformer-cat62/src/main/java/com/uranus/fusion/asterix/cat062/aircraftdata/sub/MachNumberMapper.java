package com.uranus.fusion.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.speed.Airspeed;
import com.uranus.fusion.asterix.uap.measure.speed.SpeedTypeEnum;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

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
          DecimalUtil.multiply(IntegerUtil.valueOf(uap.get(index), uap.get(index + 1)), 0.008);
      airspeed.setSpeed(speed);
      return airspeed;
    }
    return null;
  }
}
