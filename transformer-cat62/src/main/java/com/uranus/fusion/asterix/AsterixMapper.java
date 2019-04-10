package com.uranus.fusion.asterix;

import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FieldSpecTypeEnum;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AsterixMapper
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/10/15
 */
public class AsterixMapper {

  private static final Logger logger = LoggerFactory.getLogger(AsterixMapper.class);

  public static Integer readCategory(List<Byte> uap) {
    final int catIndex = 0;
    return IntegerUtil.valueOf(uap.get(catIndex));
  }

  public static Integer readLength(List<Byte> uap) {
    final int lenIndex = 1;
    return IntegerUtil.valueOf(uap.get(lenIndex), uap.get(lenIndex + 1));
  }

  public static FieldSpec readFieldSpecification(List<Byte> uapOctetList, int startIndex) {
    FieldSpec fieldSpec = new FieldSpec(FieldSpecTypeEnum.CAT062);
    fieldSpec.readValue(uapOctetList, startIndex);
    return fieldSpec;
  }
}
