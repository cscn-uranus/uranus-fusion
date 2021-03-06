package com.uranus.transition.reader.eucat062.measured;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeValidatedStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.modec.ModecCode;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class LastMeasuredModecCodeReader {

  public static ModecCode read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(MeasuredInformationConfig.LAST_MEASURED_MODEC_CODE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(MeasuredInformationConfig.LAST_MEASURED_MODEC_CODE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(MeasuredInformationConfig.LAST_MEASURED_MODEC_CODE_DRN);

      ModecCode modecCode = new ModecCode();

      String vBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      modecCode.setCodeValidatedStatusEnum(
          ByteUtil.ZERO_BIT.equals(vBit)
              ? CodeValidatedStatusEnum.VALIDATED
              : CodeValidatedStatusEnum.NOT_VALIDATED);

      String gBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      modecCode.setCodeGarbledStatusEnum(
          ByteUtil.ZERO_BIT.equals(gBit)
              ? CodeGarbledStatusEnum.DEFAULT
              : CodeGarbledStatusEnum.GARBLED);

      Byte heightValue1 =
          ByteUtil.signedValueOf(ByteUtil.toString(uap.get(index)).substring(2, 8));
      Byte heightValue2 = uap.get(index + 1);
      int heightValue = IntegerUtil.unsignedValueOf(heightValue1, heightValue2);
      double height = DecimalUtil.multiply(heightValue, 0.25);
      modecCode.setFl(height);

      return modecCode;
    }
    return null;
  }
}
