package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.emitter.modesel.ModeSelMb;
import com.uranus.transition.common.asterix.uap.emitter.modesel.ModeSelMbData;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
 class ModeselReader {

  public static ModeSelMbData read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.MODESEL_MB_DATA_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.MODESEL_MB_DATA_DRN);

      ModeSelMbData modesMbData = new ModeSelMbData();
      int repeatIndicator = IntegerUtil.unsignedValueOf(uap.get(index));
      modesMbData.setRepeatIndicator(repeatIndicator);

      for (int i = 0; i < repeatIndicator; i++) {
        ModeSelMb modesMb = new ModeSelMb();

        String bdsReportValue =
            ByteUtil.toString(uap.get(index + 1))
                + ByteUtil.toString(uap.get(index + 2))
                + ByteUtil.toString(uap.get(index + 3))
                + ByteUtil.toString(uap.get(index + 4))
                + ByteUtil.toString(uap.get(index + 5))
                + ByteUtil.toString(uap.get(index + 6))
                + ByteUtil.toString(uap.get(index + 7));
        modesMb.setBdsReport(bdsReportValue);

        String bdsRegisterValue = ByteUtil.toString(uap.get(index + 8)).substring(0, 4);
        modesMb.setBdsRegister(bdsRegisterValue);

        String bdsCodeValue = ByteUtil.toString(uap.get(index + 8)).substring(4, 8);
        modesMb.setBdsCode(bdsCodeValue);
        modesMbData.add(modesMb);

        index += AircraftDerivedDataConfig.MODESEL_MB_DATA_REPEAT_SIZE;
      }
      dpIndicator.setSize(
          modesMbData.getRepeatIndicator() * AircraftDerivedDataConfig.MODESEL_MB_DATA_REPEAT_SIZE
              + 1);
      return modesMbData;
    }
    return null;
  }
}
