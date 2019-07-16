package com.uranus.transition.reader.eucat062.measured;

import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/** @author XiaoPeng */
class MeasuredInformationConfig {
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

   static final Integer SENSOR_IDENTIFICATION_DRN = 1;
   static final Integer SENSOR_IDENTIFICATION_SIZE = 2;

   static final Integer MEASURED_POSITION_DRN = 2;
   static final Integer MEASURED_POSITION_SIZE = 4;

   static final Integer MEASURED_3D_HEIGHT_DRN = 3;
   static final Integer MEASURED_3D_HEIGHT_SIZE = 2;

   static final Integer LAST_MEASURED_MODEC_CODE_DRN = 4;
   static final Integer LAST_MEASURED_MODEC_CODE_SIZE = 2;

   static final Integer LAST_MEASURED_MODE3_CODE_DRN = 5;
   static final Integer LAST_MEASURED_MODE3_CODE_SIZE = 2;

   static final Integer REPORT_TYPE_DRN = 6;
   static final Integer REPORT_TYPE_SIZE = 1;
}
