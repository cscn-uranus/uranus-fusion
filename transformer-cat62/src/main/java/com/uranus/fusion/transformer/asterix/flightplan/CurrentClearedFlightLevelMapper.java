package com.uranus.fusion.transformer.asterix.flightplan;

import com.uranus.fusion.transformer.asterix.measure.FlightLevel;
import com.uranus.fusion.transformer.asterix.measure.FlightLevelEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * CurrentClearedFlightLevelMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class CurrentClearedFlightLevelMapper {

  public static FlightLevel read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 10;
    final int length = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      FlightLevel currentClearedFlightLevel = new FlightLevel(FlightLevelEnum.CLEARED);

      int cflValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      currentClearedFlightLevel.setFl(DecimalUtil.multiply(cflValue, 0.25));
      return currentClearedFlightLevel;

    }
    return null;
  }
}
