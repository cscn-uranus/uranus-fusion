package com.uranus.fusion.transformer.asterix.aircraft.transponder.modeselective;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * ModeSelMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class ModeSelMapper {

  public static ModeSelMbData readModeSMbData(List<Byte> uap, DataSpec dataSpec) {

    final int drn = 25;
    final int repeatStep = 8;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      ModeSelMbData modesMbData = new ModeSelMbData();
      int repeatIndicator = IntegerUtil.valueOf(uap.get(index));
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

        index += repeatStep;
      }
      dpIndicator.setSize(modesMbData.getRepeatIndicator() * repeatStep + 1);
      return modesMbData;
    }
    return null;
  }
}
