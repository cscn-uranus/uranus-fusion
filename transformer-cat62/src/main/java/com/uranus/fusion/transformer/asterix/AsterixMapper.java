package com.uranus.fusion.transformer.asterix;

import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AsterixMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class AsterixMapper {

  private static final Logger logger = LoggerFactory.getLogger(AsterixMapper.class);

  public static Integer readCat(List<Byte> uap) {
    final int catIndex = 0;
    final int catValue = 62;
    int cat = IntegerUtil.valueOf(uap.get(catIndex));
    if (cat != catValue) {
      logger.error("CAT value is not 62");
    }
    return cat;
  }

  public static Integer readLen(List<Byte> uap) {
    final int lenIndex = 1;
    return IntegerUtil.valueOf(uap.get(lenIndex), uap.get(lenIndex + 1));
  }

  public static FieldSpec readFieldSpecification(List<Byte> uapOctetList, int startIndex) {
    FieldSpec fieldSpec = new FieldSpec();
    fieldSpec.readValue(uapOctetList, startIndex);
    return fieldSpec;
  }
}
