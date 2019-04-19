package com.uranus.fusion.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.aircraft.ModeActiveEnum;
import com.uranus.fusion.asterix.uap.measure.altitude.FinalStateSelectedAltitude;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.DecimalUtil;

import java.util.List;

/**
 * FinalStateSelectedAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class FinalStateSelectedAltitudeMapper {

  public static FinalStateSelectedAltitude readFinalStateSelectedAltitude(
      List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.FINAL_STATE_SELECTED_ALTITUDE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.FINAL_STATE_SELECTED_ALTITUDE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              AircraftDerivedDataConfig.FINAL_STATE_SELECTED_ALTITUDE_DRN);

      FinalStateSelectedAltitude finalStateSelectedAltitude = new FinalStateSelectedAltitude();

      String manageVerticalModeValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      finalStateSelectedAltitude.setManageVerticalMode(
          ByteUtil.ZERO_BIT.equals(manageVerticalModeValue)
              ? ModeActiveEnum.NOT_ACTIVE
              : ModeActiveEnum.ACTIVE);

      String altitudeHold = ByteUtil.toString(uap.get(index)).substring(1, 2);
      finalStateSelectedAltitude.setAltitudeHold(
          ByteUtil.ZERO_BIT.equals(altitudeHold)
              ? ModeActiveEnum.NOT_ACTIVE
              : ModeActiveEnum.ACTIVE);

      String approachMode = ByteUtil.toString(uap.get(index)).substring(2, 3);
      finalStateSelectedAltitude.setApproachMode(
          ByteUtil.ZERO_BIT.equals(approachMode)
              ? ModeActiveEnum.NOT_ACTIVE
              : ModeActiveEnum.ACTIVE);

      Byte altitudeValue1 = ByteUtil.valueOf(ByteUtil.toString(uap.get(index)).substring(3, 8));
      Byte altitudeValue2 = uap.get(index + 1);
      double altitude = DecimalUtil.calculateByResolution(altitudeValue1, altitudeValue2, 25);
      finalStateSelectedAltitude.setAltitude(altitude);

      return finalStateSelectedAltitude;
    }
    return null;
  }
}
