package com.uranus.fusion.common.asterix.aircraft.fcu;

import com.uranus.fusion.common.asterix.aircraft.type.ModeActiveEnum;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.DecimalUtil;

import java.util.List;

/**
 * FinalStateSelectedAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/10/30
 */
public class FinalStateSelectedAltitudeMapper {

  public static FinalStateSelectedAltitude readFinalStateSelectedAltitude(
      List<Byte> uap, DataSpec dataSpec) {

    final int drn = 7;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      FinalStateSelectedAltitude finalStateSelectedAltitude = new FinalStateSelectedAltitude();

      String manageVerticalModeValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      finalStateSelectedAltitude.setManageVerticalMode(
          zeroBit.equals(manageVerticalModeValue) ? ModeActiveEnum.NOT_ACTIVE
              : ModeActiveEnum.ACTIVE);

      String altitudeHold = ByteUtil.toString(uap.get(index)).substring(1, 2);
      finalStateSelectedAltitude.setAltitudeHold(
          zeroBit.equals(altitudeHold) ? ModeActiveEnum.NOT_ACTIVE : ModeActiveEnum.ACTIVE);

      String approachMode = ByteUtil.toString(uap.get(index)).substring(2, 3);
      finalStateSelectedAltitude.setApproachMode(
          zeroBit.equals(approachMode) ? ModeActiveEnum.NOT_ACTIVE : ModeActiveEnum.ACTIVE);

      Byte altitudeValue1 = ByteUtil.valueOf(ByteUtil.toString(uap.get(index)).substring(3, 8));
      Byte altitudeValue2 = uap.get(index + 1);
      double altitude =
          DecimalUtil.calculateByResolution(altitudeValue1, altitudeValue2, 25);
      finalStateSelectedAltitude.setAltitude(altitude);

      return finalStateSelectedAltitude;
    }
    return null;
  }
}
