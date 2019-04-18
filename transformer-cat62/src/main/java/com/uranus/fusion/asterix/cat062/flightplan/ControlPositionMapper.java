package com.uranus.fusion.asterix.cat062.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.flightplan.ControlPosition;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * ControlPositionMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class ControlPositionMapper {

  public static ControlPosition read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 11;
    final int length = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      ControlPosition controlPosition = new ControlPosition();

      String centreCode = ByteUtil.toString(uap.get(index));
      String positionCode = ByteUtil.toString(uap.get(index + 1));

      controlPosition.setCentreCode(centreCode);
      controlPosition.setPositionCode(positionCode);

      return controlPosition;
    }
    return null;
  }
}
