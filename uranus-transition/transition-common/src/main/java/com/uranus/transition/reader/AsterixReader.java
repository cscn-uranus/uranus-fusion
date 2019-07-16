package com.uranus.transition.reader;

import com.uranus.transition.common.asterix.AsterixConfig;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.IntegerUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
@Slf4j
public class AsterixReader {
  /**
   * @param message 符合 Asterix 规范的报文
   * @return CAT 字段的值
   */
  public static Integer readCategory(List<Byte> message) {
    return IntegerUtil.unsignedValueOf(message.get(AsterixConfig.ASTERIX_CATEGORY_INDEX));
  }

  /**
   * @param message 符合 Asterix 规范的报文
   * @return LEN 字段的值
   */
  public static Integer readLength(List<Byte> message) {
    return IntegerUtil.unsignedValueOf(
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX),
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX + AsterixConfig.ASTERIX_LENGTH_SIZE - 1));
  }

  /**
   * @param message 符合 Asterix 规范的报文
   * @param beginIndex FSPEC 的起始位置，首个 FSPEC 从索引位置 3 起始
   * @param fieldSpecParameter FSPEC 的配置参数，包括 FRN 和 FXN 的定义等
   * @return FieldSpec 的实例
   */
  public static FieldSpec readFspec(
      List<Byte> message, int beginIndex, FieldSpecParameter fieldSpecParameter) {

    FieldSpec fieldSpec = new FieldSpec(beginIndex, fieldSpecParameter);
    int sizeCount = 0;
    int currentIndex = beginIndex;

    for (int i = 0; i < fieldSpecParameter.maxFxn(); i++) {
      Byte fieldSpecificationOctet = message.get(currentIndex);
      for (int j = 0; j < fieldSpecParameter.frnStepSize(); j++) {
        // set f1-f7
        int frn = i * fieldSpecParameter.frnStepSize() + j + fieldSpecParameter.frnStartNumber();
        String fpIndicatorIndicationBit = ByteUtil.getBitByIndex(fieldSpecificationOctet, j);

        FpIndicator fpIndicator = fieldSpec.getFpIndicatorMap().get(frn);
        fpIndicator.setIndication(
          ByteUtil.ZERO_BIT.equals(fpIndicatorIndicationBit)
            ? FpIndicationEnum.ABSENCE
            : FpIndicationEnum.PRESENCE);
      }

      String fxn = fieldSpecParameter.fxPrefix() + (i + fieldSpecParameter.fxnStartNumber());
      String fxIndicatorIndicationBit =
        ByteUtil.getBitByIndex(fieldSpecificationOctet, fieldSpecParameter.fxnOctetIndex());

      FxIndicator fxIndicator = fieldSpec.getFxIndicatorMap().get(fxn);
      fxIndicator.setIndication(
        ByteUtil.ZERO_BIT.equals(fxIndicatorIndicationBit)
          ? FxIndicationEnum.END
          : FxIndicationEnum.EXTENSION);

      sizeCount++;
      currentIndex++;
      fieldSpec.setSize(sizeCount);

      if (fxIndicator.getIndication().equals(FxIndicationEnum.END)) {
        break;
      }
    }
    return fieldSpec;
  }



}
