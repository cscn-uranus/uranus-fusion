package com.uranus.transition.common.asterix.cat062.dataage;

import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * SystemTrackUpdateAgeConfig
 *
 * @author 肖鹏 tellxp@github.com date 2019/04/17
 */
class TrackDataAgeConfig {
    static final int MAX_DRN = 35;
    static final int MAX_DXN = 5;

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

   static final Integer MEASURED_FLIGHT_LEVEL_AGE_DRN = 1;
   static final Integer MEASURED_FLIGHT_LEVEL_AGE_SIZE = 1;

   static final Integer MODE1_AGE_DRN = 2;
   static final Integer MODE1_AGE_SIZE = 1;

   static final Integer MODE2_AGE_DRN = 3;
   static final Integer MODE2_AGE_SIZE = 1;

   static final Integer MODE3_AGE_DRN = 4;
   static final Integer MODE3_AGE_SIZE = 1;

   static final Integer MODE4_AGE_DRN = 5;
   static final Integer MODE4_AGE_SIZE = 1;

   static final Integer MODE5_AGE_DRN = 6;
   static final Integer MODE5_AGE_SIZE = 1;

   static final Integer MAGNETIC_HEADING_AGE_DRN = 7;
   static final Integer MAGNETIC_HEADING_AGE_SIZE = 1;

   static final Integer AIRSPEED_AGE_DRN = 8;
   static final Integer AIRSPEED_AGE_SIZE = 1;

   static final Integer TRUE_AIRSPEED_AGE_DRN = 9;
   static final Integer TRUE_AIRSPEED_AGE_SIZE = 1;

   static final Integer SELECTED_ALTITUDE_AGE_DRN = 10;
   static final Integer SELECTED_ALTITUDE_AGE_SIZE = 1;

   static final Integer FINAL_STATE_SELECTED_ALTITUDE_AGE_DRN = 11;
   static final Integer FINAL_STATE_SELECTED_ALTITUDE_AGE_SIZE = 1;

   static final Integer TRAJECTORY_INTENT_AGE_DRN = 12;
   static final Integer TRAJECTORY_INTENT_AGE_SIZE = 1;

   static final Integer COMM_AND_FLIGHT_STATUS_AGE_DRN = 13;
   static final Integer COMM_AND_FLIGHT_STATUS_AGE_SIZE = 1;

   static final Integer STATUS_REPORTED_BY_ADSB_AGE_DRN = 14;
   static final Integer STATUS_REPORTED_BY_ADSB_AGE_SIZE = 1;

   static final Integer ACAS_RESOLUTION_ADVISORY_REPORT_AGE_DRN = 15;
   static final Integer ACAS_RESOLUTION_ADVISORY_REPORT_AGE_SIZE = 1;

   static final Integer BAROMETRIC_VERTICAL_RATE_AGE_DRN = 16;
   static final Integer BAROMETRIC_VERTICAL_RATE_AGE_SIZE = 1;

   static final Integer GEOMETRIC_VERTICAL_RATE_AGE_DRN = 17;
   static final Integer GEOMETRIC_VERTICAL_RATE_AGE_SIZE = 1;

   static final Integer ROLL_ANGLE_AGE_DRN = 18;
   static final Integer ROLL_ANGLE_AGE_SIZE = 1;

   static final Integer TRACK_ANGLE_RATE_AGE_DRN = 19;
   static final Integer TRACK_ANGLE_RATE_AGE_SIZE = 1;

   static final Integer TRACK_ANGLE_AGE_DRN = 20;
   static final Integer TRACK_ANGLE_AGE_SIZE = 1;

   static final Integer GROUND_SPEED_AGE_DRN = 21;
   static final Integer GROUND_SPEED_AGE_SIZE = 1;

   static final Integer VELOCITY_UNCERTAINTY_AGE_DRN = 22;
   static final Integer VELOCITY_UNCERTAINTY_AGE_SIZE = 1;

   static final Integer MET_DATA_AGE_DRN = 23;
   static final Integer MET_DATA_AGE_SIZE = 1;

   static final Integer EMITTER_CATEGORY_AGE_DRN = 24;
   static final Integer EMITTER_CATEGORY_AGE_SIZE = 1;

   static final Integer POSITION_AGE_DRN = 25;
   static final Integer POSITION_AGE_SIZE = 1;

   static final Integer GEOMETRIC_ALTITUDE_AGE_DRN = 26;
   static final Integer GEOMETRIC_ALTITUDE_AGE_SIZE = 1;

   static final Integer POSITION_UNCERTAINTY_AGE_DRN = 27;
   static final Integer POSITION_UNCERTAINTY_AGE_SIZE = 1;

   static final Integer MODE_SEL_MB_DATA_AGE_DRN = 28;
   static final Integer MODE_SEL_MB_DATA_AGE_SIZE = 1;

   static final Integer INDICATED_AIRSPEED_AGE_DRN = 29;
   static final Integer INDICATED_AIRSPEED_AGE_SIZE = 1;

   static final Integer MACH_NUMBER_AGE_DRN = 30;
   static final Integer MACH_NUMBER_AGE_SIZE = 1;

   static final Integer BAROMETRIC_PRESSURE_SETTING_AGE_DRN = 31;
   static final Integer BAROMETRIC_PRESSURE_SETTING_AGE_SIZE = 1;
}
