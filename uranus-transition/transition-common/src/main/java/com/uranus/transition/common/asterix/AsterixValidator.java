package com.uranus.transition.common.asterix;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/6/21
 */
@Slf4j
public class AsterixValidator {
  public static Boolean checkCategoryValue(int expected, int actual) {
    if (expected == actual) {
      return true;
    } else {
      log.warn("category 字段值不一致：" + "期望值是：" + expected + "，实际值是：" + actual);
      return false;
    }
  }

  public static Boolean checkLengthValue(int expected, int actual) {
    if (expected == actual) {
      return true;
    } else {
      log.warn("length 字段值不一致：" + "期望值是：" + expected + "，实际值是：" + actual);
      return false;
    }
  }

  public static Boolean checkFspec(FieldSpec fieldSpec, List<Integer> spareFrnList) {

    if (null == fieldSpec) {
      return false;
    }
    for (int frn : spareFrnList) {
      FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);
      if (FpIndicationEnum.PRESENCE == fpIndicator.getIndication()) {
        log.warn("非法的报文,报文中FRN=" + frn + "的数据项为预留项, FSPEC中该数据项应该为ABSENCE, 当前值为PRESENCE");
        return false;
      }
    }
    return true;
  }

  public static Boolean checkTotalSize(int expected, int actual) {
    if (expected == actual) {
      return true;
    } else {
      log.warn("总长度不一致：存在解析问题。" + "期望值是：" + expected + "，实际值是：" + actual);
      return false;
    }
  }

  public static Boolean isValidAsterixUap(
    AsterixUap asterixUap, int expectedCategoryValue, List<Integer> spareFrnList) {

    if (!AsterixValidator.checkCategoryValue(expectedCategoryValue, asterixUap.category())) {
      return false;
    }
    if (!AsterixValidator.checkLengthValue(asterixUap.length(), asterixUap.messageSize())) {
      return false;
    }

    int totalSize = AsterixConfig.ASTERIX_CATEGORY_SIZE + AsterixConfig.ASTERIX_LENGTH_SIZE;
    for (AsterixDataBlock asterixDataBlock : asterixUap.asterixDataBlocks()) {
      if (!AsterixValidator.checkFspec(asterixDataBlock.fieldSpec(), spareFrnList)) {
        return false;
      }
      totalSize += asterixDataBlock.fieldSpec().calculateCurrentDataBlockLength();
    }

    return AsterixValidator.checkTotalSize(asterixUap.length(), totalSize);
  }
}
