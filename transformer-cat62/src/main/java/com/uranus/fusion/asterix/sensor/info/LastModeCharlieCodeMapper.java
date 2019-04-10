package com.uranus.fusion.asterix.sensor.info;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.aircraft.transponder.mode3.CodeGarbledStatusEnum;
import com.uranus.fusion.asterix.aircraft.transponder.mode3.CodeValidatedStatusEnum;
import com.uranus.fusion.asterix.util.ByteUtil;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;
import java.util.List;

/**
 * Measured3DHeightMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class LastModeCharlieCodeMapper {

  public static LastModeCharlieCode read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 4;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      LastModeCharlieCode lastModeCharlieCode = new LastModeCharlieCode();

      String vBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      lastModeCharlieCode.setCodeValidatedStatusEnum(
          zeroBit.equals(vBit) ? CodeValidatedStatusEnum.VALIDATED
              : CodeValidatedStatusEnum.NOT_VALIDATED);

      String gBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      lastModeCharlieCode.setCodeGarbledStatusEnum(
          zeroBit.equals(gBit) ? CodeGarbledStatusEnum.DEFAULT : CodeGarbledStatusEnum.GARBLED);

      Byte heightValue1 = ByteUtil.valueOf(ByteUtil.toString(uap.get(index)).substring(2, 8));
      Byte heightValue2 = uap.get(index + 1);
      int heightValue = IntegerUtil.valueOf(heightValue1, heightValue2);
      double height = DecimalUtil.multiply(heightValue, 0.25);
      lastModeCharlieCode.setHeight(height);

      return lastModeCharlieCode;
    }
    return null;
  }
}
