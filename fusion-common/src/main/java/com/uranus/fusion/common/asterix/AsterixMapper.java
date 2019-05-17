package com.uranus.fusion.common.asterix;

import com.uranus.fusion.common.asterix.spec.FieldSpec;
import com.uranus.fusion.common.asterix.spec.FieldSpecParameter;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * AsterixMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class AsterixMapper {

  public static Integer readCategory(List<Byte> message) {
    return IntegerUtil.unsignedValueOf(message.get(AsterixConfig.ASTERIX_CATEGORY_INDEX));
  }

  public static Integer readLength(List<Byte> message) {
    return IntegerUtil.unsignedValueOf(
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX),
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX + AsterixConfig.ASTERIX_LENGTH_SIZE - 1));
  }

  public static FieldSpec readFieldSpec(
      List<Byte> message, int beginIndex, FieldSpecParameter fieldSpecParameter) {
    FieldSpec fieldSpec = new FieldSpec(beginIndex, fieldSpecParameter);

    fieldSpec.read(message);
    return fieldSpec;
  }
}
