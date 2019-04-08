package com.uranus.fusion.common.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DataSpecTypeEnum;
import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.FpIndicator;
import java.util.List;

/**
 * Mode5AndExtendedMode1DataMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5AndExtendedMode1DataMapper {

  public static Mode5AndExtendedMode1Data read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 24;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      Mode5AndExtendedMode1Data mode5AndExtendedMode1Data = new Mode5AndExtendedMode1Data();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.MODE5_EXTENDED_MODE1_DATA);
      dataSpec.readValue(uap, index);

      Mode5Summary mode5Summary = Mode5SummaryMapper.read(uap, dataSpec);
      Mode5Identification mode5Identification = Mode5IdentificationMapper.read(uap, dataSpec);
      Mode5Position mode5Position = Mode5PositionMapper.read(uap, dataSpec);
      Mode5Altitude mode5Altitude = Mode5AltitudeMapper.read(uap, dataSpec);
      ExtendedMode1Code extendedMode1Code = ExtendedMode1CodeMapper.read(uap, dataSpec);
      TimeOffset timeOffset = TimeOffsetMapper.read(uap, dataSpec);
      XpulsePresenceStatus xpulsePresenceStatus = XpuLsePresenceStatusMapper.read(uap, dataSpec);

      mode5AndExtendedMode1Data.setDataSpec(dataSpec);
      mode5AndExtendedMode1Data.setMode5Summary(mode5Summary);
      mode5AndExtendedMode1Data.setMode5Identification(mode5Identification);
      mode5AndExtendedMode1Data.setMode5Position(mode5Position);
      mode5AndExtendedMode1Data.setMode5Altitude(mode5Altitude);
      mode5AndExtendedMode1Data.setExtendedMode1Code(extendedMode1Code);
      mode5AndExtendedMode1Data.setTimeOffset(timeOffset);
      mode5AndExtendedMode1Data.setXpulsePresenceStatus(xpulsePresenceStatus);

      fpIndicator.setSize(dataSpec.calculateTotalSize());

      return mode5AndExtendedMode1Data;
    }
    return null;
  }


}
