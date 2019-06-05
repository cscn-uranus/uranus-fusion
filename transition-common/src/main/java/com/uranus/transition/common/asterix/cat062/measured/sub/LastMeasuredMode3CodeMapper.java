package com.uranus.transition.common.asterix.cat062.measured.sub;

import com.uranus.transition.common.asterix.cat062.measured.MeasuredInformationConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeSourceTypeEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeValidatedStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.LastMode3Code;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * LastMeasuredMode3CodeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class LastMeasuredMode3CodeMapper {

  public static LastMode3Code read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(MeasuredInformationConfig.LAST_MEASURED_MODE3_CODE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(MeasuredInformationConfig.LAST_MEASURED_MODE3_CODE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(MeasuredInformationConfig.LAST_MEASURED_MODE3_CODE_DRN);

      LastMode3Code lastMode3Code = new LastMode3Code();

      String vBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      lastMode3Code.setCodeValidatedStatusEnum(
          ByteUtil.ZERO_BIT.equals(vBit)
              ? CodeValidatedStatusEnum.VALIDATED
              : CodeValidatedStatusEnum.NOT_VALIDATED);

      String gBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      lastMode3Code.setCodeGarbledStatusEnum(
          ByteUtil.ZERO_BIT.equals(gBit)
              ? CodeGarbledStatusEnum.DEFAULT
              : CodeGarbledStatusEnum.GARBLED);

      String lBit = ByteUtil.toString(uap.get(index)).substring(2, 3);
      lastMode3Code.setCodeSourceTypeEnum(
          ByteUtil.ZERO_BIT.equals(lBit)
              ? CodeSourceTypeEnum.DERIVED
              : CodeSourceTypeEnum.SMOOTHED);

      String codeBits =
          ByteUtil.toString(uap.get(index)).substring(3, 7) + ByteUtil.toString(uap.get(index + 1));

      String code = StringUtil.valueOf(codeBits, 3);

      lastMode3Code.setCode(code);

      return lastMode3Code;
    }
    return null;
  }
}
