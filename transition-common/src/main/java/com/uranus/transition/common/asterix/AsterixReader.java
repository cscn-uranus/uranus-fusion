package com.uranus.transition.common.asterix;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FieldSpecParameter;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * AsterixReader
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class AsterixReader {

  public static Integer readCategory(List<Byte> message) {
    return IntegerUtil.unsignedValueOf(message.get(AsterixConfig.ASTERIX_CATEGORY_INDEX));
  }

  public static Integer readLength(List<Byte> message) {
    return IntegerUtil.unsignedValueOf(
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX),
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX + AsterixConfig.ASTERIX_LENGTH_SIZE - 1));
  }

  public static FieldSpec read(
      List<Byte> message, int beginIndex, FieldSpecParameter fieldSpecParameter) {
    FieldSpec fieldSpec = new FieldSpec(beginIndex, fieldSpecParameter);

    fieldSpec.read(message);
    return fieldSpec;
  }
}
