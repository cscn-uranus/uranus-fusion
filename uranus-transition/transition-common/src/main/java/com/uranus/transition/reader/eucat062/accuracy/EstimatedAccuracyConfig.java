package com.uranus.transition.reader.eucat062.accuracy;

import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author XiaoPeng
 */
class EstimatedAccuracyConfig {
  static final int MAX_DRN = 14;
  static final int MAX_DXN = 2;

   static final int DEFAULT_DP_INDICATOR_SIZE = 0;

   static final DpIndicationEnum DEFAULT_DP_INDICATION = DpIndicationEnum.ABSENCE;
   static final DxIndicationEnum DEFAULT_DX_INDICATION = DxIndicationEnum.END;
   static final int DRN_START_NUM = 1;
   static final int DXN_START_NUM = 1;
   static final int DRN_STEP_SIZE = 7;
   static final String DX_PREFIX = "dx";
   static final Integer DXN_OCTET_INDEX = 7;

  static final Integer CARTESIAN_POSITION_DRN = 1;
  static final Integer CARTESIAN_POSITION_SIZE = 4;

  static final Integer CARTESIAN_COVARIANCE_DRN = 2;
  static final Integer CARTESIAN_COVARIANCE_SIZE = 2;

  static final Integer WGS84_POSITION_DRN = 3;
  static final Integer WGS84_POSITION_SIZE = 4;

  static final Integer GEOMETRIC_ALTITUDE_DRN = 4;
  static final Integer GEOMETRIC_ALTITUDE_SIZE = 1;

  static final Integer BAROMETRIC_ALTITUDE_DRN = 5;
  static final Integer BAROMETRIC_ALTITUDE_SIZE = 4;

  static final Integer CARTESIAN_VELOCITY_DRN = 6;
  static final Integer CARTESIAN_VELOCITY_SIZE = 2;

  static final Integer CARTESIAN_ACCELERATION_DRN = 7;
  static final Integer CARTESIAN_ACCELERATION_SIZE = 2;

  static final Integer VERTICAL_RATE_DRN = 7;
  static final Integer VERTICAL_RATE_SIZE = 2;
}
