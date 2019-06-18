package com.uranus.transition.common.asterix;

/**
 * Asterix 常量配置
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2019/06/13
 */
public class AsterixConfig {
  public static final Integer CAT001_CATEGORY_VALUE = 1;
  public static final Integer CAT002_CATEGORY_VALUE = 2;
  public static final Integer CAT034_CATEGORY_VALUE = 34;
  public static final Integer CAT048_CATEGORY_VALUE = 48;
  public static final Integer CAT062_CATEGORY_VALUE = 62;

  /** 默认 CAT 字段在报文中的索引位置 */
  public static final Integer ASTERIX_CATEGORY_INDEX = 0;

  /** CAT 字段的长度 */
  public static final Integer ASTERIX_CATEGORY_SIZE = 1;

  /** LEN 字段的在报文中的索引位置 */
  public static final Integer ASTERIX_LENGTH_INDEX = ASTERIX_CATEGORY_INDEX + ASTERIX_CATEGORY_SIZE;

  /** LEN 字段的长度 */
  public static final Integer ASTERIX_LENGTH_SIZE = 2;

  public static final Integer ASTERIX_FIRST_FSPEC_INDEX =
      ASTERIX_LENGTH_INDEX + ASTERIX_LENGTH_SIZE;
}
