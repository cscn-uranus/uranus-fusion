package com.uranus.fusion.common.asterix.cat062.mode5;

import com.uranus.fusion.common.asterix.cat062.Cat062Config;
import com.uranus.fusion.common.asterix.cat062.mode5.sub.*;
import com.uranus.fusion.common.asterix.spec.*;
import com.uranus.fusion.common.asterix.uap.emitter.mode1.ExtendedMode1Code;
import com.uranus.fusion.common.asterix.uap.emitter.mode5.*;

import java.util.List;

/**
 * Mode5AndMode1Mapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class Mode5AndMode1Mapper {

  public static Mode5AndExtendedMode1 read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.MODE5_AND_EXTENDED_MODE1_CODE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.MODE5_AND_EXTENDED_MODE1_CODE_FRN);

      Mode5AndExtendedMode1 mode5AndExtendedMode1 = new Mode5AndExtendedMode1();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_MODE5_EXTENDED_MODE1_DATA);
      dataSpec.readValue(uap, index);

      Mode5Summary mode5Summary = Mode5SummaryMapper.read(uap, dataSpec);
      Mode5Identification mode5Identification = Mode5IdentificationMapper.read(uap, dataSpec);
      Mode5Position mode5Position = Mode5PositionMapper.read(uap, dataSpec);
      Mode5Altitude mode5Altitude = Mode5AltitudeMapper.read(uap, dataSpec);
      ExtendedMode1Code extendedMode1Code = ExtendedMode1CodeMapper.read(uap, dataSpec);
      TimeOffset timeOffset = TimeOffsetMapper.read(uap, dataSpec);
      XpulsePresenceStatus xpulsePresenceStatus = XpuLseMapper.read(uap, dataSpec);

      mode5AndExtendedMode1.setDataSpec(dataSpec);
      mode5AndExtendedMode1.setMode5Summary(mode5Summary);
      mode5AndExtendedMode1.setMode5Identification(mode5Identification);
      mode5AndExtendedMode1.setMode5Position(mode5Position);
      mode5AndExtendedMode1.setMode5Altitude(mode5Altitude);
      mode5AndExtendedMode1.setExtendedMode1Code(extendedMode1Code);
      mode5AndExtendedMode1.setTimeOffset(timeOffset);
      mode5AndExtendedMode1.setXpulsePresenceStatus(xpulsePresenceStatus);

      fpIndicator.setSize(dataSpec.calculateTotalSize());

      return mode5AndExtendedMode1;
    }
    return null;
  }
}
