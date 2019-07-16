package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.AsterixConfig;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FxIndicationEnum;

import java.util.Arrays;
import java.util.List;

/**
 * @author XiaoPeng
 * @date 2019/6/21
 */
public class CnCat003Config extends AsterixConfig {
  static final Integer CATEGORY_VALUE = 3;
  static final Integer MAX_FRN = 21;
  static final Integer DEFAULT_FP_INDICATOR_SIZE = 0;
  static final FpIndicationEnum DEFAULT_FP_INDICATION = FpIndicationEnum.ABSENCE;
  static final Integer FRN_START_NUMBER = 1;
  static final Integer FRN_OCTET_SIZE = 7;

  static final Integer MAX_FXN = 3;
  static final FxIndicationEnum DEFAULT_FX_INDICATION = FxIndicationEnum.END;
  static final Integer FXN_START_NUMBER = 1;
  static final Integer FXN_OCTET_INDEX = 7;
  static final String FX_PREFIX = "fx";

  static final List<Integer> SPARE_FRN = Arrays.asList(20, 21);

  static final Integer DATA_SOURCE_IDENTIFIER_FRN = 1;
  static final Integer DATA_SOURCE_IDENTIFIER_SIZE = 2;

  static final Integer TARGET_REPORT_INFO_FRN = 2;
  static final Integer TARGET_REPORT_INFO_EX_SIZE = 1;

  static final Integer FLIGHT_CALL_SIGN_FRN = 3;
  static final Integer FLIGHT_CALL_SIGN_EX_SIZE = 1;

  static final Integer TRACK_NUMBER_FRN = 4;
  static final Integer TRACK_NUMBER_SIZE = 2;

  static final Integer CARTESIAN_CALCULATED_TRACK_POSITION_FRN = 5;
  static final Integer CARTESIAN_CALCULATED_TRACK_POSITION_SIZE = 4;

  static final Integer MODEC_FLIGHT_LEVEL_FRN = 6;
  static final Integer MODEC_FLIGHT_LEVEL_SIZE = 2;

  static final Integer PLANED_FLIGHT_LEVEL_FRN = 7;
  static final Integer PLANED_FLIGHT_LEVEL_SIZE = 2;

  static final Integer CLEARED_FLIGHT_LEVEL_FRN = 8;
  static final Integer CLEARED_FLIGHT_LEVEL_SIZE = 2;

  static final Integer TRACK_STATUS_FRN = 9;
  static final Integer TRACK_STATUS_EX_SIZE = 1;

  static final Integer POLAR_CALCULATED_TRACK_VELOCITY_FRN = 10;
  static final Integer POLAR_CALCULATED_TRACK_VELOCITY_SIZE = 2;

  static final Integer TRACK_MODE_3A_CODE_FRN = 11;
  static final Integer TRACK_MODE_3A_CODE_SIZE = 2;

  static final Integer TRACK_ACCURACY_FRN = 12;
  static final Integer TRACK_ACCURACY_EX_SIZE = 1;

  static final Integer REPORTED_FLIGHT_LEVEL_FRN = 13;
  static final Integer REPORTED_FLIGHT_LEVEL_SIZE = 2;

  static final Integer TIME_OF_TRACK_FRN = 14;
  static final Integer TIME_OF_TRACK_SIZE = 3;

  static final Integer CALCULATED_RATE_OF_CLIMB_DESCENT_FRN = 15;
  static final Integer CALCULATED_RATE_OF_CLIMB_DESCENT_SIZE = 2;

  static final Integer TRACK_MODE2_CODE_FRN = 16;
  static final Integer TRACK_MODE2_CODE_SIZE = 2;

  static final Integer DESTINATION_AIRPORT_FRN = 17;
  static final Integer DESTINATION_AIRPORT_EX_SIZE = 1;

  static final Integer CONTROLLED_STATUS_FRN = 18;
  static final Integer CONTROLLED_STATUS_EX_SIZE = 1;

  static final Integer WAKE_TURBULENCE_CATEGORY_FRN = 19;
  static final Integer WAKE_TURBULENCE_CATEGORY_SIZE = 1;
}
