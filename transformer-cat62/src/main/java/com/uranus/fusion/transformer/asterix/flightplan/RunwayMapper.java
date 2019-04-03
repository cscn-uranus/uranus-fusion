package com.uranus.fusion.transformer.asterix.flightplan;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.StringUtil;

import java.util.List;

/**
 * RunwayMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class RunwayMapper {

  public static Runway read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 9;
    final int length = 3;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      Runway runway = new Runway();

      String icaoName = StringUtil.asciiValueOf(uap.get(index),uap.get(index+1),uap.get(index+2));
      runway.setIcaoName(icaoName);
      return runway;
    }
    return null;
  }
}
