package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * AircraftDerivedDataReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/16
 */
class AircraftDerivedDataConfig {
   static final int MAX_DRN = 28;
   static final int MAX_DXN = 4;

   static final int DEFAULT_MAX_DRN = 0;
   static final int DEFAULT_MAX_DXN = 0;

   static final int DEFAULT_DP_INDICATOR_SIZE = 0;

   static final DpIndicationEnum DEFAULT_DP_INDICATION = DpIndicationEnum.ABSENCE;
   static final DxIndicationEnum DEFAULT_DX_INDICATION = DxIndicationEnum.END;
   static final int DRN_START_NUMBER = 1;
   static final int DXN_START_NUMBER = 1;
   static final int DRN_STEP_SIZE = 7;
   static final String DX_PREFIX = "dx";
   static final Integer DXN_OCTET_INDEX = 7;


  static final Integer TARGET_ADDRESS_DRN = 1;
  static final Integer TARGET_ADDRESS_SIZE = 3;

  static final Integer TARGET_IDENTIFICATION_DRN = 2;
  static final Integer TARGET_IDENTIFICATION_SIZE = 6;

  static final Integer MAGNETIC_HEADING_DRN = 3;
  static final Integer MAGNETIC_HEADING_SIZE = 2;

  static final Integer AIRSPEED_DRN = 4;
  static final Integer AIRSPEED_SIZE = 2;

  static final Integer TRUE_AIRSPEED_DRN = 5;
  static final Integer TRUE_AIRSPEED_SIZE = 2;

  static final Integer SELECTED_ALTITUDE_DRN = 6;
  static final Integer SELECTED_ALTITUDE_SIZE = 2;

  static final Integer FINAL_STATE_SELECTED_ALTITUDE_DRN = 7;
  static final Integer FINAL_STATE_SELECTED_ALTITUDE_SIZE = 2;

  static final Integer TRAJECTORY_INTENT_STATUS_DRN = 8;
  static final Integer TRAJECTORY_INTENT_STATUS_SIZE = 1;

  static final Integer TRAJECTORY_INTENT_DATA_DRN = 9;
  static final Integer TRAJECTORY_INTENT_DATA_REPEAT_SIZE = 15;

  static final Integer COMM_AND_STATUS_BY_MODESEL_DRN = 10;
  static final Integer COMM_AND_STATUS_BY_MODESEL_SIZE = 2;

  static final Integer STATUS_REPORTED_BY_ADSB_DRN = 11;
  static final Integer STATUS_REPORTED_BY_ADSB_SIZE = 2;

  static final Integer ACAS_RESOLUTION_ADVISORY_REPORT_DRN = 12;
  static final Integer ACAS_RESOLUTION_ADVISORY_REPORT_SIZE = 7;

  static final Integer BAROMETRIC_VERTICAL_RATE_DRN = 13;
  static final Integer BAROMETRIC_VERTICAL_RATE_SIZE = 2;

  static final Integer GEOMETRIC_VERTICAL_RATE_DRN = 14;
  static final Integer GEOMETRIC_VERTICAL_RATE_SIZE = 2;

  static final Integer ROLL_ANGLE_DRN = 15;
  static final Integer ROLL_ANGLE_SIZE = 2;

  static final Integer TRACK_ANGLE_RATE_DRN = 16;
  static final Integer TRACK_ANGLE_RATE_SIZE = 2;

  static final Integer TRACK_ANGLE_DRN = 17;
  static final Integer TRACK_ANGLE_SIZE = 2;

  static final Integer GROUND_SPEED_DRN = 18;
  static final Integer GROUND_SPEED_SIZE = 2;

  static final Integer VELOCITY_UNCERTAINTY_DRN = 19;
  static final Integer VELOCITY_UNCERTAINTY_SIZE = 1;

  static final Integer MET_DATA_DRN = 20;
  static final Integer MET_DATA_SIZE = 8;

  static final Integer EMITTER_CATEGORY_DRN = 21;
  static final Integer EMITTER_CATEGORY_SIZE = 1;

  static final Integer POSITION_DRN = 22;
  static final Integer POSITION_SIZE = 6;

  static final Integer GEOMETRIC_ALTITUDE_DRN = 23;
  static final Integer GEOMETRIC_ALTITUDE_SIZE = 2;

  static final Integer POSITION_UNCERTAINTY_DRN = 24;
  static final Integer POSITION_UNCERTAINTY_SIZE = 1;

  static final Integer MODESEL_MB_DATA_DRN = 25;
  static final Integer MODESEL_MB_DATA_REPEAT_SIZE = 8;

  static final Integer INDICATED_AIRSPEED_DRN = 26;
  static final Integer INDICATED_AIRSPEED_SIZE = 2;

  static final Integer MACH_NUMBER_DRN = 27;
  static final Integer MACH_NUMBER_SIZE = 2;

  static final Integer BAROMETRIC_PRESSURE_SETTING_DRN = 28;
  static final Integer BAROMETRIC_PRESSURE_SETTING_SIZE = 2;
}
