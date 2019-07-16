package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.flightplan.ControlledStatus;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/7/4
 */
public class ControlledStatusReader {
  public static ControlledStatus read(List<Byte> message, FieldSpec fieldSpec) {
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.CONTROLLED_STATUS_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      int sizeCount = CnCat003Config.CONTROLLED_STATUS_EX_SIZE;

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.CONTROLLED_STATUS_FRN);
      ControlledStatus controlledStatus = new ControlledStatus();

      StringBuilder statusBuilder = new StringBuilder();

      while (true) {
        String statusBit = ByteUtil.toString(message.get(index)).substring(0, 7);
        statusBuilder.append(
            StringUtil.standardAsciiValueOf("0" + statusBit, ByteUtil.BITS_OF_BYTE));

        String fxBit = ByteUtil.toString(message.get(index)).substring(7, 8);
        if (ByteUtil.ZERO_BIT.equals(fxBit)) {
          controlledStatus.setStatus(statusBuilder.toString());
          fpIndicator.setSize(sizeCount);
          return controlledStatus;
        }
        index+=CnCat003Config.CONTROLLED_STATUS_EX_SIZE;
        sizeCount+=CnCat003Config.CONTROLLED_STATUS_EX_SIZE;
      }
    }
    return null;
  }
}
