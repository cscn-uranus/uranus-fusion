package com.uranus.transition.reader.eucat062.mode5;

import com.uranus.transition.reader.eucat062.EuCat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode1.ExtendedMode1Code;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode5.*;

import java.util.List;

/**
 * Mode5AndMode1Reader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class Mode5AndMode1Reader {

  public static Mode5AndExtendedMode1 read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.MODE5_AND_EXTENDED_MODE1_CODE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.MODE5_AND_EXTENDED_MODE1_CODE_FRN);

      Mode5AndExtendedMode1 mode5AndExtendedMode1 = new Mode5AndExtendedMode1();

      DataSpecParameter dataSpecParameter = new Mode5AndMode1DataSpecParameter();
      DataSpec dataSpec = new DataSpec(index,dataSpecParameter);
      dataSpec.readValue(message);

      Mode5Summary mode5Summary = Mode5SummaryReader.read(message, dataSpec);
      Mode5Identification mode5Identification = Mode5IdentificationReader.read(message, dataSpec);
      Mode5Position mode5Position = Mode5PositionReader.read(message, dataSpec);
      Mode5Altitude mode5Altitude = Mode5AltitudeReader.read(message, dataSpec);
      ExtendedMode1Code extendedMode1Code = ExtendedMode1CodeReader.read(message, dataSpec);
      TimeOffset timeOffset = TimeOffsetReader.read(message, dataSpec);
      XpulsePresenceStatus xpulsePresenceStatus = XpuLseReader.read(message, dataSpec);

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
