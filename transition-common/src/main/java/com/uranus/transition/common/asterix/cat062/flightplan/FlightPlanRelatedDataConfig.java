package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

class FlightPlanRelatedDataConfig {
    static final int MAX_DRN = 21;
    static final int MAX_DXN = 3;

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

   static final Integer FPPS_IDENTIFICATION_TAG_DRN = 1;
   static final Integer FPPS_IDENTIFICATION_TAG_SIZE = 2;

   static final Integer CALLSIGN_DRN = 2;
   static final Integer CALLSIGN_SIZE = 7;

   static final Integer IFPS_FLIGHT_ID_DRN = 3;
   static final Integer IFPS_FLIGHT_ID_SIZE = 4;

   static final Integer FLIGHT_CATEGORY_DRN = 4;
   static final Integer FLIGHT_CATEGORY_SIZE = 1;

   static final Integer TYPE_OF_AIRCRAFT_DRN = 5;
   static final Integer TYPE_OF_AIRCRAFT_SIZE = 4;

   static final Integer WAKE_TURBULENCE_CATEGORY_DRN = 6;
   static final Integer WAKE_TURBULENCE_CATEGORY_SIZE = 1;

   static final Integer DEPARTURE_AIRPORT_DRN = 7;
   static final Integer DEPARTURE_AIRPORT_SIZE = 4;

   static final Integer DESTINATION_AIRPORT_DRN = 8;
   static final Integer DESTINATION_AIRPORT_SIZE = 4;

   static final Integer RUNWAY_DESIGNATION_DRN = 9;
   static final Integer RUNWAY_DESIGNATION_SIZE = 3;

   static final Integer CURRENT_CLEARED_FLIGHT_LEVEL_DRN = 10;
   static final Integer CURRENT_CLEARED_FLIGHT_LEVEL_SIZE = 2;

   static final Integer CURRENT_CONTROL_POSITION_DRN = 11;
   static final Integer CURRENT_CONTROL_POSITION_SIZE = 2;

   static final Integer TIME_OF_DEPARTURE_OR_ARRIVAL_DRN = 12;
   static final Integer TIME_OF_DEPARTURE_OR_ARRIVAL_REPEAT_SIZE = 4;

   static final Integer AIRCRAFT_STAND_DRN = 13;
   static final Integer AIRCRAFT_STAND_SIZE = 6;

   static final Integer STAND_STATUS_DRN = 14;
   static final Integer STAND_STATUS_SIZE = 1;

   static final Integer STANDARD_INSTRUMENT_DEPARTURE_DRN = 15;
   static final Integer STANDARD_INSTRUMENT_DEPARTURE_SIZE = 7;

   static final Integer STANDARD_INSTRUMENT_ARRIVAL_DRN = 16;
   static final Integer STANDARD_INSTRUMENT_ARRIVAL_SIZE = 7;

   static final Integer PRE_EMERGENCY_MODE3A_DRN = 17;
   static final Integer PRE_EMERGENCY_MODE3A_SIZE = 7;

   static final Integer PRE_EMERGENCY_CALLSIGN_DRN = 18;
   static final Integer PRE_EMERGENCY_CALLSIGN_SIZE = 7;
}
