package com.uranus.transition.common.asterix.uap.track.status;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.track.DataAge;
import lombok.Data;

/**
 * TrackDataAge
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
@Data
public class TrackDataAge {

  /**
   * Structure of Primary Subfield:
   *
   * <p>bit-40 (MFL) Subfield #1: Measured Flight Level age = 0 Absence of Subfield #1 = 1 Presence
   * of Subfield #1
   *
   * bit-39 (MD1) Subfield #2: Mode 1 age = 0 Absence of Subfield #2 = 1 Presence of
   * Subfield #2
   *
   * bit-38 (MD2) Subfield #3: Mode 2 age = 0 Absence of Subfield #3 = 1 Presence of
   * Subfield #3
   *
   * <p>bit-37 (MDA) Subfield #4: Mode 3/A age = 0 Absence of Subfield #4 = 1 Presence of Subfield
   * #4
   *
   * bit-36 (MD4) Subfield #5: Mode 4 age = 0 Absence of Subfield #5 = 1 Presence of Subfield #5
   *
   *
   * bit-35 (MD5) Subfield #6: Mode 5 age = 0 Absence of Subfield #6 = 1 Presence of Subfield #6
   *
   *
   * bit-34 (MHG) Subfield #7: Magnetic Heading age = 0 Absence of Subfield #7 = 1 Presence of
   * Subfield #7
   *
   * bit-33 FX Extension indicator = 0 no extension = 1 extension
   *
   * bit-32 (IAS) Subfield
   * #8: Indicated Airspeed/Mach Nb age = 0 Absence of Subfield #8 = 1 Presence of Subfield #8
   *
   *
   * bit-31 (TAS) Subfield #9: True Airspeed age = 0 Absence of Subfield #9 = 1 Presence of Subfield
   * #9 bit-30 (SAL) Subfield #10: Selected Altitude age = 0 Absence of Subfield #10 = 1 Presence of
   * Subfield #10
   *
   * bit-29 (FSS) Subfield #11: Final State Selected Altitude age = 0 Absence of
   * Subfield #11 = 1 Presence of Subfield #11
   *
   * bit-28 (TID) Subfield #12: Trajectory Intent Data age
   * = 0 Absence of Subfield #12 = 1 Presence of Subfield #12
   *
   * bit-27 (COM) Subfield #13:
   * Communications / ACAS Capability and Flight Status age = 0 Absence of Subfield #13 = 1 Presence
   * of Subfield #13
   *
   * bit-26 (SAB) Subfield #14: Status Reported by ADS-B age = 0 Absence of Subfield
   * #14 = 1 Presence of Subfield #14
   *
   * bit-25 FX Extension indicator = 0 no extension = 1 extension
   *
   *
   * bit-24 (ACS) Subfield #15: ACAS Resolution Advisory Report age = 0 Absence of Subfield #15 = 1
   * Presence of Subfield #15
   *
   * <p>bit-23 (BVR) Subfield #16: Barometric Vertical Rate age = 0 Absence of Subfield #16 = 1
   * Presence of Subfield #16
   *
   * bit-22 (GVR) Subfield #17: Geometric Vertical Rate age = 0 Absence of
   * Subfield #17 = 1 Presence of Subfield #17
   *
   * bit-21 (RAN) Subfield #18: Roll Angle age = 0 Absence
   * of Subfield #18 = 1 Presence of Subfield #18
   *
   * bit-20 (TAR) Subfield #19: Track Angle Rate age =
   * 0 Absence of Subfield #19 = 1 Presence of Subfield #19
   *
   * bit-19 (TAN) Subfield #20: Track Angle
   * age = 0 Absence of Subfield #20 = 1 Presence of Subfield #20
   *
   * bit-18 (GSP) Subfield #21: Ground
   * Speed age = 0 Absence of Subfield #21 = 1 Presence of Subfield #21
   *
   * bit-17 FX Extension
   * indicator = 0 no extension = 1 extension
   *
   * bit-16 (VUN) Subfield #22: Velocity Uncertainty age =
   * 0 Absence of Subfield #22 = 1 Presence of Subfield #22
   *
   * bit-15 (MET) Subfield #23:
   * Meteorological Data age = 0 Absence of Subfield #23 = 1 Presence of Subfield #23
   *
   * bit-14 (EMC)
   * Subfield #24: Emitter Category age = 0 Absence of Subfield #24 = 1 Presence of Subfield #24
   *
   *
   * bit-13 (POS) Subfield #25: Position Data age = 0 Absence of Subfield #25 = 1 Presence of
   * Subfield #25
   *
   * bit-12 (GAL) Subfield #26: Geometric Altitude Data age = 0 Absence of Subfield #26
   * = 1 Presence of Subfield #26
   *
   * bit-11 (PUN) Subfield #27: Position Uncertainty Data age = 0
   * Absence of Subfield #27 = 1 Presence of Subfield #27
   *
   * bit-10 (MB) Subfield #28: Mode S MB Data
   * age = 0 Absence of Subfield #28 = 1 Presence of Subfield #28
   *
   * <p>bit-9 FX Extension indicator = 0 no extension = 1 extension
   *
   * bit-8 (IAR) Subfield #29:
   * Indicated Airspeed Data age = 0 Absence of Subfield #29 = 1 Presence of Subfield #29
   *
   * bit-7
   * (MAC) Subfield #30: Mach Number Data age = 0 Absence of Subfield #30 = 1 Presence of Subfield
   * #30
   *
   * bit-6 (BPS) Subfield #31: Barometric Pressure Setting Data age = 0 Absence of Subfield #31
   * = 1 Presence of Subfield #31
   *
   * bit-5/2 spare bits set to zero
   *
   *
   * bit-1 FX Extension indicator = 0 no
   * extension = 1 extension
   */
  private DataSpec dataSpec;

  /**
   * Structure of Subfield # 1: Measured Flight Level Age
   *
   * <p>bits-8/1 (MFL) Age of the last valid and credible Mode C code or barometric altitude from
   * ADS-B used to update the track (I062/136) bit-1 (LSB) = 1/4 s Maximum value =63.75s
   */
  private DataAge measuredFlightLevelAge;

  /**
   * Structure of Subfield # 2: Mode 1 Age
   *
   * <p>bits-8/1 (MD1) Age of the last valid and credible Mode 1 code used to update the track
   * (I062/110) bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge mode1Age;

  /**
   * Structure of Subfield # 3: Mode 2 Age
   *
   * <p>bits-8/1 (MD2) Age of the last valid and credible Mode 2 code used to update the track
   * (I062/120) bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge mode2Age;

  /**
   * Structure of Subfield # 4: Mode 3/A Age
   *
   * <p>bits-8/1 (MDA) Age of the last valid and credible Mode 3/A code used to update the track
   * (I062/060) bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge mode3Age;

  /**
   * Structure of Subfield # 5: Mode 4 Age
   *
   * <p>bits-8/1 (MD4) Age of the last valid and credible Mode 4 code used to update the track bit-1
   * (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge mode4Age;

  /**
   * Structure of Subfield # 6: Mode 5 Age
   *
   * <p>bits-8/1 (MD5) Age of the last valid and credible Mode 5 code used to update the track
   * (I062/110) bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge mode5Age;

  /**
   * Structure of Subfield # 7 Magnetic Heading Age
   *
   * <p>bits-8/1 (MHG) Age of the DAP “Magnetic Heading” in item 062/380 (Subfield #3) bit-1 (LSB) =
   * 1/4 s Maximum value =63.75s
   */
  private DataAge magneticHeadingAge;

  /**
   * Structure of Subfield # 8 Indicated Airspeed / Mach Nb age
   *
   * <p>bits-8/1 (IAS) Age of the DAP “Indicated Airspeed / Mach Number” in item 062/380 (Subfield
   * #4) bit-1 (LSB) = 1/4 s Maximum value =63.75s
   */
  private DataAge airspeedAge;

  /**
   * Structure of Subfield # 9: True Airspeed Age
   *
   * <p>bits-8/1 (TAS) Age of the DAP “True Airspeed” in item 062/380 (Subfield #5) bit-1 (LSB) =
   * 1/4 s Maximum value = 63.75s
   */
  private DataAge trueAirspeedAge;

  /**
   * Structure of Subfield # 10 Selected Altitude Age
   *
   * <p>bits-8/1 (SAL) Age of the DAP “Selected Altitude” in item 062/380 (Subfield #6) bit-1 (LSB)
   * = 1/4 s Maximum value = 63.75s
   */
  private DataAge selectedAltitudeAge;

  /**
   * Structure of Subfield # 11: Final State Selected Altitude Age
   *
   * <p>bits-8/1 (FSS) Age of the DAP “Final State Selected Altitude” in item 062/380 (Subfield #7)
   * bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge finalSelectedAltitudeAge;

  /**
   * Structure of Subfield # 12: Trajectory Intent Age
   *
   * <p>bits-8/1 (TID) Age of the DAP “Trajectory Intent” in item 062/380 (Subfield #8) bit-1 (LSB)
   * = 1/4 s Maximum value = 63.75s
   */
  private DataAge trajectoryIntentAge;

  /**
   * Structure of Subfield # 13: Communication/ACAS Capability and Flight Status Age
   *
   * <p>bits-8/1 (COM) Age of the DAP “Communication/ACAS Capability and Flight Status” in item
   * 062/380 (Subfield #10) bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge commAndStatusByModeSelectiveAge;

  /**
   * Structure of Subfield # 14: Status Reported by ADS-B Age
   *
   * <p>bits-8/1 (SAB) Age of the DAP “Status Reported by ADS-B” in item 062/380 (Subfield #11)
   * bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge statusByAdsBroadcastAge;

  /**
   * Structure of Subfield # 15: ACAS Resolution Advisory Report Age
   *
   * <p>bits-8/1 (ACS) Age of the DAP “ACAS Resolution Advisory Report” in item 062/380 (Subfield
   * #12) bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge acasAdvisoryReportAge;

  /**
   * Structure of Subfield # 16: Barometric Vertical Rate Age
   *
   * <p>bits-8/1 (BVR) Age of the DAP “Barometric Vertical Rate” in item 062/380 (Subfield #13)
   * bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge barometricVerticalRateAge;

  /**
   * Structure of Subfield # 17: Geometrical Vertical Rate Age
   *
   * <p>bits-8/1 (GVR) Age of the DAP “Geometrical Vertical Rate” in item 062/380 (Subfield #14)
   * bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge geometricalVerticalRateAge;

  /**
   * Structure of Subfield # 18: Roll Angle Age
   *
   * <p>bits-8/1 (RAN) Age of the DAP “Roll Angle” in item 062/380 (Subfield #15) bit-1 (LSB) = 1/4
   * s Maximum value = 63.75s
   */
  private DataAge rollAngleAge;

  /**
   * Structure of Subfield # 19: Track Angle Rate Age
   *
   * <p>bits-8/1 (TAR) Age of the DAP “Track Angle Rate” in item 062/380 (Subfield #16) bit-1 (LSB)
   * = 1/4 s Maximum value = 63.75s
   */
  private DataAge trackAngleRateAge;

  /**
   * Structure of Subfield # 20: Track Angle Age
   *
   * <p>bits-8/1 (TAN) Age of the DAP “Track Angle” in item 062/380 (Subfield #17) bit-1 (LSB) = 1/4
   * s Maximum value = 63.75s
   */
  private DataAge trackAngleAge;

  /**
   * Structure of Subfield # 21: Ground Speed Age
   *
   * <p>bits-8/1 (GSP) Age of the DAP “Ground Speed” in item 062/380 (Subfield #18) bit-1 (LSB) =
   * 1/4 s Maximum value = 63.75s
   */
  private DataAge groundSpeedAge;

  /**
   * Structure of Subfield # 22: Velocity Uncertainty Age
   *
   * <p>bits-8/1 (VUN) Age of the DAP “Velocity Uncertainty” in item 062/380 (Subfield #19) bit-1
   * (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge velocityUncertaintyAge;

  /**
   * Structure Subfield # 23: Meteorological Data Age
   *
   * <p>bits-8/1 (MET) Age of the DAP “Meteorological Data” in item 062/380 (Subfield #20) bit-1
   * (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge meteorologicalDataAge;

  /**
   * Structure of Subfield # 24: Emitter Category Age
   *
   * <p>bits-8/1 (EMC) Age of the DAP “Emitter Category” in item 062/380 (Subfield #21) bit-1 (LSB)
   * = 1/4 s Maximum value = 63.75s
   */
  private DataAge emitterCategoryAge;

  /**
   * Structure of Subfield # 25: Position Age
   *
   * <p>bits-8/1 (POS) Age of the DAP “Position” in item 062/380 (Subfield #23) bit-1 (LSB) = 1/4 s
   * Maximum value = 63.75s
   */
  private DataAge positionAge;

  /**
   * Structure of Subfield # 26: Geometric Altitude Age
   *
   * <p>bits-8/1 (GAL) Age of the DAP “Geometric Altitude” in item 062/380 (Subfield #24) bit-1
   * (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge geometricAltitudeAge;

  /**
   * Structure of Subfield # 27: Position Uncertainty Age
   *
   * <p>bits-8/1 (PUN) Age of the DAP “Position Uncertainty” in item 062/380 (Subfield #25) bit-1
   * (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge positionUncertaintyAge;

  /**
   * Structure of Subfield # 28: Mode S MB Data Age
   *
   * <p>bits-8/1 (MB) Age of the DAP “Mode S MB Data” in item 062/380 (Subfield #22) bit-1 (LSB) =
   * 1/4 s Maximum value = 63.75s
   */
  private DataAge modeSelMbDataAge;

  /**
   * Structure of Subfield # 29: Indicated Airspeed Data Age
   *
   * <p>bits-8/1 (IAR) Age of the DAP “Indicated Airspeed” in item 062/380 (Subfield #26) bit-1
   * (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge indicatedAirspeedDataAge;

  /**
   * Structure of Subfield # 30: Mach Number Data Age
   *
   * <p>bits-8/1 (MAC) Age of the DAP “Mach Number” in item 062/380 (Subfield #27) bit-1 (LSB) = 1/4
   * s Maximum value = 63.75s
   */
  private DataAge machNumberDataAge;

  /**
   * Structure of Subfield # 31: Barometric Pressure Setting Data Age
   *
   * <p>bits-8/1 (BPS) Age of the DAP “Barometric Pressure Setting” in item 062/380 (Subfield #28)
   * bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private DataAge barometricPressureSettingDataAge;
}
