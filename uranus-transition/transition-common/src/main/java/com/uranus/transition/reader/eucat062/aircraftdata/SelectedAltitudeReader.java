package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.datainfo.SourceInformationEnum;
import com.uranus.transition.common.asterix.uap.shared.datainfo.SourceTypeEnum;
import com.uranus.transition.common.asterix.uap.shared.measure.SelectedAltitude;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * SelectedAltitudeReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
class SelectedAltitudeReader {

  public static SelectedAltitude read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.SELECTED_ALTITUDE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.SELECTED_ALTITUDE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.SELECTED_ALTITUDE_DRN);

      SelectedAltitude selectedAltitude = new SelectedAltitude();
      String sourceStatusValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      selectedAltitude.setSourceStatus(
          ByteUtil.ZERO_BIT.equals(sourceStatusValue)
              ? SourceInformationEnum.NOT_PROVIDED
              : SourceInformationEnum.PROVIDED);

      String sourceTypeValue = ByteUtil.toString(uap.get(index)).substring(1, 3);
      switch (sourceTypeValue) {
        case "01":
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.AIRCRAFT);
          break;
        case "10":
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.FCU_MCP);
          break;
        case "11":
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.FMS);
          break;
        case "00":
        default:
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.UNKNOWN);
          break;
      }

      Byte altitudeValue1 =
          ByteUtil.signedValueOf(ByteUtil.toString(uap.get(index)).substring(3, 8));
      Byte altitudeValue2 = uap.get(index + 1);
      int altitudeValue = IntegerUtil.signedValueOf(altitudeValue1, altitudeValue2);
      double altitude = DecimalUtil.multiply(altitudeValue, 25);
      selectedAltitude.setAltitude(altitude);

      return selectedAltitude;
    }
    return null;
  }
}
