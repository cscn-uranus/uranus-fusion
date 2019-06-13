package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FxIndicationEnum;

import java.util.Arrays;
import java.util.List;

/** @author XiaoPeng */
public class Cat062Config {
  static final Integer MAX_FRN = 35;
  static final Integer DEFAULT_FP_INDICATOR_SIZE = 0;
  static final FpIndicationEnum DEFAULT_FP_INDICATION = FpIndicationEnum.ABSENCE;
  static final Integer FRN_START_NUMBER = 1;
  static final Integer FRN_OCTET_SIZE = 7;

  static final Integer MAX_FXN = 5;
  static final FxIndicationEnum DEFAULT_FX_INDICATION = FxIndicationEnum.END;
  static final Integer FXN_START_NUMBER = 1;
  static final Integer FXN_OCTET_INDEX = 7;
  static final String FX_PREFIX = "fx";

  static final List<Integer> SPARE_FRN = Arrays.asList(2, 29, 30, 31, 32, 33, 34, 35);

  static final Integer DATA_SOURCE_IDENTIFIER_FRN = 1;
  static final Integer DATA_SOURCE_IDENTIFIER_SIZE = 2;

  static final Integer SERVICE_IDENTIFICATION_FRN = 3;
  static final Integer SERVICE_IDENTIFICATION_SIZE = 1;

  static final Integer TIME_OF_TRACK_INFORMATION_FRN = 4;
  static final Integer TIME_OF_TRACK_INFORMATION_SIZE = 3;

  static final Integer WGS84_CALCULATED_TRACK_POSITION_FRN = 5;
  static final Integer WGS84_CALCULATED_TRACK_POSITION_SIZE = 8;

  static final Integer CARTESIAN_CALCULATED_TRACK_POSITION_FRN = 6;
  static final Integer CARTESIAN_CALCULATED_TRACK_POSITION_SIZE = 6;

  static final Integer CARTESIAN_CALCULATED_TRACK_VELOCITY_FRN = 7;
  static final Integer CARTESIAN_CALCULATED_TRACK_VELOCITY_SIZE = 4;

  static final Integer CARTESIAN_CALCULATED_ACCELERATION_FRN = 8;
  static final Integer CARTESIAN_CALCULATED_ACCELERATION_SIZE = 2;

  static final Integer TRACK_MODE_3A_CODE_FRN = 9;
  static final Integer TRACK_MODE_3A_CODE_SIZE = 2;

  static final Integer TARGET_IDENTIFICATION_FRN = 10;
  static final Integer TARGET_IDENTIFICATION_SIZE = 7;

  public static final Integer AIRCRAFT_DERIVED_DATA_FRN = 11;

  static final Integer TRACK_NUMBER_FRN = 12;
  static final Integer TRACK_NUMBER_SIZE = 2;

  static final Integer TRACK_STATUS_FRN = 13;
  static final Integer TRACK_STATUS_EX_SIZE = 1;

  public static final Integer SYSTEM_TRACK_UPDATE_AGES_FRN = 14;

  static final Integer MODE_OF_MOVEMENT_FRN = 15;
  static final Integer MODE_OF_MOVEMENT_SIZE = 1;

  public static final Integer TRACK_DATA_AGES_FRN = 16;

  static final Integer MEASURED_FLIGHT_LEVEL_FRN = 17;
  static final Integer MEASURED_FLIGHT_LEVEL_SIZE = 2;

  static final Integer CALCULATED_TRACK_GEOMETRIC_ALTITUDE_FRN = 18;
  static final Integer CALCULATED_TRACK_GEOMETRIC_ALTITUDE_SIZE = 2;

  static final Integer CALCULATED_TRACK_BAROMETRIC_ALTITUDE_FRN = 19;
  static final Integer CALCULATED_TRACK_BAROMETRIC_ALTITUDE_SIZE = 2;

  static final Integer CALCULATED_RATE_OF_CLIMB_DESCENT_FRN = 20;
  static final Integer CALCULATED_RATE_OF_CLIMB_DESCENT_SIZE = 2;

  public static final Integer FLIGHT_PLAN_RELATED_DATA_FRN = 21;

  static final Integer TARGET_SIZE_AND_ORIENTATION_FRN = 22;
  static final Integer TARGET_SIZE_AND_ORIENTATION_EX_SIZE = 1;

  static final Integer VEHICLE_FLEET_IDENTIFICATION_FRN = 23;
  static final Integer VEHICLE_FLEET_IDENTIFICATION_SIZE = 1;

  public static final Integer MODE5_AND_EXTENDED_MODE1_CODE_FRN = 24;

  static final Integer TRACK_MODE2_CODE_FRN = 25;
  static final Integer TRACK_MODE2_CODE_SIZE = 2;

  static final Integer COMPOSED_TRACK_NUMBER_FRN = 26;
  static final Integer COMPOSED_TRACK_NUMBER_EX_SIZE = 3;

  public static final Integer ESTIMATED_ACCURACIES_FRN = 27;

  public static final Integer MEASURED_INFORMATION_FRN = 28;
}
