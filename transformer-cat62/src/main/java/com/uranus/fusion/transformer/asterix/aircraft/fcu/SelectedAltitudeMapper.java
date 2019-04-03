package com.uranus.fusion.transformer.asterix.aircraft.fcu;

import com.uranus.fusion.transformer.asterix.aircraft.type.SourceInformationEnum;
import com.uranus.fusion.transformer.asterix.aircraft.type.SourceTypeEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;

import java.util.List;

/**
 * SelectedAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class SelectedAltitudeMapper {

  public static SelectedAltitude readSelectedAltitude(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 6;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      SelectedAltitude selectedAltitude = new SelectedAltitude();
      String sourceStatusValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      selectedAltitude.setSourceStatus(
          zeroBit.equals(sourceStatusValue)
              ? SourceInformationEnum.NOT_PROVIDED
              : SourceInformationEnum.PROVIDED);

      String sourceTypeValue = ByteUtil.toString(uap.get(index)).substring(1, 3);
      switch (sourceTypeValue) {
        case "00":
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.UNKNOWN);
          break;
        case "01":
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.AIRCRAFT);
          break;
        case "10":
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.FCU_MCP);
          break;
        case "11":
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.FMS);
          break;
        default:
          selectedAltitude.setSourceTypeEnum(SourceTypeEnum.UNKNOWN);
          break;
      }

      Byte altitudeValue1 = ByteUtil.valueOf(ByteUtil.toString(uap.get(index)).substring(3, 8));
      Byte altitudeValue2 = uap.get(index + 1);
      double altitude =
          DecimalUtil.calculateByResolution(altitudeValue1, altitudeValue2, 25);
      selectedAltitude.setAltitude(altitude);

      return selectedAltitude;
    }
    return null;
  }
}
