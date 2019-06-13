package com.uranus.transition.common.asterix.cat062.mode5;

import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author XiaoPeng
 */
 class Mode5AndMode1Config {
   static final int MAX_DRN = 7;
   static final int MAX_DXN = 1;

   static final int DEFAULT_MAX_DRN = 0;
   static final int DEFAULT_MAX_DXN = 0;

   static final int DEFAULT_DP_INDICATOR_SIZE = 0;

   static final DpIndicationEnum DEFAULT_DP_INDICATION = DpIndicationEnum.ABSENCE;
   static final DxIndicationEnum DEFAULT_DX_INDICATION = DxIndicationEnum.END;
   static final int DRN_START_NUM = 1;
   static final int DXN_START_NUM = 1;
   static final int DRN_STEP_SIZE = 7;
   static final int DXN_OCTET_INDEX = 7;
   static final String DX_PREFIX = "dx";

   static final Integer MODE5_SUMMARY_DRN = 1;
   static final Integer MODE5_SUMMARY_SIZE = 1;

   static final Integer MODE5_IDENTIFICATION_DRN = 2;
   static final Integer MODE5_IDENTIFICATION_SIZE = 4;

   static final Integer MODE5_POSITION_DRN = 3;
   static final Integer MODE5_POSITION_SIZE = 6;

   static final Integer MODE5_ALTITUDE_DRN = 4;
   static final Integer MODE5_ALTITUDE_SIZE = 2;

   static final Integer EXTENDED_MODE1_CODE_DRN = 5;
   static final Integer EXTENDED_MODE1_CODE_SIZE = 2;

   static final Integer TIME_OFFSET_DRN = 6;
   static final Integer TIME_OFFSET_SIZE = 1;

   static final Integer X_PULSE_DRN = 7;
   static final Integer X_PULSE_SIZE = 1;
}
