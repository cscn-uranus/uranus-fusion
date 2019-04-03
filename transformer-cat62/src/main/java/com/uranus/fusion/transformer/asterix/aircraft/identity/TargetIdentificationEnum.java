package com.uranus.fusion.transformer.asterix.aircraft.identity;

/**
 * TargetIdentificationEnum
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/18
 */
public enum TargetIdentificationEnum {
  // Callsign or registration downlinked from target
  CALLSIGN_REGISTRATION_DOWNLINKED,

  // Callsign not downlinked from target
  CALLSIGN_NOT_DOWNLINKED,

  // Registration not downlinked from target
  REGISTRATION_NOT_DOWNLINKED,

  // Invalid
  INVALID,

  // Target Identification is in aircraft derived data
  AIRCRAFT_DERIVED
}
