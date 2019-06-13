package com.uranus.transition.common.asterix.cat062.updateage;

import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * SystemTrackUpdateAgeConfig
 *
 * @author 肖鹏 tellxp@github.com date 2019/04/17
 */
 class SystemTrackUpdateAgeConfig {
   static final int MAX_DRN = 14;
   static final int MAX_DXN = 2;

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

   static final Integer TRACK_AGE_DRN = 1;
   static final Integer TRACK_AGE_SIZE = 1;

   static final Integer PSR_AGE_DRN = 2;
   static final Integer PSR_AGE_SIZE = 1;

   static final Integer SSR_AGE_DRN = 3;
   static final Integer SSR_AGE_SIZE = 1;

   static final Integer MODE_SEL_AGE_DRN = 4;
   static final Integer MODE_SEL_AGE_SIZE = 1;

   static final Integer ADSC_AGE_DRN = 5;
   static final Integer ADSC_AGE_SIZE = 2;

   static final Integer ES_AGE_DRN = 6;
   static final Integer ES_AGE_SIZE = 7;

   static final Integer VDL_AGE_DRN = 8;
   static final Integer VDL_AGE_SIZE = 1;

   static final Integer UAT_AGE_DRN = 9;
   static final Integer UAT_AGE_SIZE = 1;

   static final Integer LOOP_AGE_DRN = 10;
   static final Integer LOOP_AGE_SIZE = 1;

   static final Integer MULTILATERATION_AGE_DRN = 11;
   static final Integer MULTILATERATION_AGE_SIZE = 1;
}
