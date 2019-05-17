package com.uranus.fusion.common.asterix;

public class AsterixConfig {
  public static final Integer CAT001_CATEGORY_VALUE = 1;
  public static final Integer CAT002_CATEGORY_VALUE = 2;
  public static final Integer CAT034_CATEGORY_VALUE = 34;
  public static final Integer CAT048_CATEGORY_VALUE = 48;
  public static final Integer CAT062_CATEGORY_VALUE = 62;

  public static final Integer ASTERIX_CATEGORY_INDEX = 0;
  public static final Integer ASTERIX_CATEGORY_SIZE = 1;

  public static final Integer ASTERIX_LENGTH_INDEX = ASTERIX_CATEGORY_INDEX + ASTERIX_CATEGORY_SIZE;
  public static final Integer ASTERIX_LENGTH_SIZE = 2;

  public static final Integer ASTERIX_FIRST_FSPEC_INDEX =
      ASTERIX_LENGTH_INDEX + ASTERIX_LENGTH_SIZE;
}
