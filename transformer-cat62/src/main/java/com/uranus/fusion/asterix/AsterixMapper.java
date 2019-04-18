package com.uranus.fusion.asterix;

import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FieldSpecTypeEnum;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * AsterixMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class AsterixMapper {

  public static Integer readCategory(List<Byte> message) {
    return IntegerUtil.valueOf(message.get(AsterixConfig.ASTERIX_CATEGORY_INDEX));
  }

  public static Integer readLength(List<Byte> message) {
    return IntegerUtil.valueOf(
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX),
        message.get(AsterixConfig.ASTERIX_LENGTH_INDEX + AsterixConfig.ASTERIX_LENGTH_SIZE - 1));
  }

  public static FieldSpec readFieldSpec(List<Byte> message) {
    FieldSpec fieldSpec = new FieldSpec(FieldSpecTypeEnum.CAT062);

    fieldSpec.readValue(message, AsterixConfig.ASTERIX_FSPEC_INDEX);
    return fieldSpec;
  }
}
