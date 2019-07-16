package com.uranus.transition.common.asterix.uap.eucat062;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.shared.aircraft.MagneticHeading;
import com.uranus.transition.common.asterix.uap.shared.comm.AcasResolutionReport;
import com.uranus.transition.common.asterix.uap.shared.emitter.EmitterCategoryEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.adsb.StatusByAdsb;
import com.uranus.transition.common.asterix.uap.shared.emitter.modesel.CommAndStatusByModeSel;
import com.uranus.transition.common.asterix.uap.shared.emitter.modesel.ModeSelMbData;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetAddress;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetIdentification;
import com.uranus.transition.common.asterix.uap.shared.measure.SelectedAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.VelocityUncertainty;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.BarometricVerticalRate;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FinalStateSelectedAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.GeometricAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.GeometricVerticalRate;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.RollAngle;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.TrackAngle;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.TrackAngleRate;
import com.uranus.transition.common.asterix.uap.shared.measure.position.PositionUncertainty;
import com.uranus.transition.common.asterix.uap.shared.measure.position.Wgs84Position;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.Airspeed;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.GroundSpeed;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.TrueAirspeed;
import com.uranus.transition.common.asterix.uap.shared.meteorology.BarometricPressureSetting;
import com.uranus.transition.common.asterix.uap.shared.meteorology.MetData;
import com.uranus.transition.common.asterix.uap.shared.trajectory.TrajectoryIntentData;
import com.uranus.transition.common.asterix.uap.shared.trajectory.TrajectoryIntentStatus;
import lombok.Data;

/**
 * AircraftDerivedData
 *
 * <p>Data Item I062/380, Aircraft Derived Data
 *
 * <p>Definition : Data derived directly by the aircraft.
 *
 * <p>Format : Compound Data Item, comprising a primary subfield of up to four octets, followed by
 * the indicated subfields.
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
@Data
public class AircraftDerivedData {

  /**
   * Primary Subfield:
   *
   * <p>bit-32 (ADR) Subfield #1: Target Address = 0 Absence of Subfield #1 = 1 Presence of Subfield
   * #1
   *
   * <p>bit-31 (ID) Subfield #2: Target Identification = 0 Absence of Subfield #2 = 1 Presence of
   * Subfield #2
   *
   * <p>bit-30 (MHG) Subfield #3: Magnetic Heading = 0 Absence of Subfield #3 = 1 Presence of
   * Subfield #3
   *
   * <p>bit-29 (IAS) Subfield #4: Indicated Airspeed/ Mach Number = 0 Absence of Subfield #4 = 1
   * Presence of Subfield #4
   *
   * <p>bit-28 (TAS) Subfield #5: True Airspeed = 0 Absence of Subfield #5 = 1 Presence of Subfield
   * #5
   *
   * <p>bit-27 (SAL) Subfield #6: Selected Altitude = 0 Absence of Subfield #6 = 1 Presence of
   * Subfield #6
   *
   * <p>bit-26 (FSS) Subfield #7: Final State Selected Altitude = 0 Absence of Subfield #7 = 1
   * Presence of Subfield #7
   *
   * <p>bit-25 FX Extension indicator = 0 no extension = 1 extension
   *
   * <p>bit-24 (TIS) Subfield #8: Trajectory Intent Status = 0 Absence of Subfield #8 = 1 Presence
   * of Subfield #8
   *
   * <p>bit-23 (TID) Subfield #9: Trajectory Intent Data = 0 Absence of Subfield #9 = 1 Presence of
   * Subfield #9
   *
   * <p>bit-22 (COM) Subfield #10: Communications / ACAS Capability and Flight Status = 0 Absence of
   * Subfield #10 = 1 Presence of Subfield #10
   *
   * <p>bit-21 (SAB) Subfield #11: Status reported by ADS-B = 0 Absence of Subfield #11 = 1 Presence
   * of Subfield #11
   *
   * <p>bit-20 (ACS) Subfield #12: ACAS Resolution Advisory Report = 0 Absence of Subfield #12 = 1
   * Presence of Subfield #12
   *
   * <p>bit-19 (BVR) Subfield #13: Barometric Vertical Rate = 0 Absence of Subfield #13 = 1 Presence
   * of Subfield #13
   *
   * <p>bit-18 (GVR) Subfield #14: Geometric Vertical Rate = 0 Absence of Subfield #14 = 1 Presence
   * of Subfield #14
   *
   * <p>bit-17 FX Extension indicator = 0 no extension = 1 extension
   *
   * <p>bit-16 (RAN) Subfield #15: Roll Angle = 0 Absence of Subfield #15 = 1 Presence of Subfield
   * #15
   *
   * <p>bit-15 (TAR) Subfield #16: Track Angle Rate = 0 Absence of Subfield #16 = 1 Presence of
   * Subfield #16
   *
   * <p>bit-14 (TAN) Subfield #17: Track Angle = 0 Absence of Subfield #17 = 1 Presence of Subfield
   * #17
   *
   * <p>bit-13 (GSP) Subfield #18: Ground Speed = 0 Absence of Subfield #18 = 1 Presence of Subfield
   * #18
   *
   * <p>bit-12 (VUN) Subfield #19: Velocity Uncertainty = 0 Absence of Subfield #19 = 1 Presence of
   * Subfield #19
   *
   * <p>bit-11 (MET) Subfield #20: Meteorological Data = 0 Absence of Subfield #20 = 1 Presence of
   * Subfield #20
   *
   * <p>bit-10 (EMC) Subfield #21: Emitter Category = 0 Absence of Subfield #21 = 1 Presence of
   * Subfield #21
   *
   * <p>bit-9 FX Extension indicator = 0 no extension = 1 extension
   *
   * <p>bit-8 (POS) Subfield #22: Position Data = 0 Absence of Subfield #22 = 1 Presence of Subfield
   * #22
   *
   * <p>bit-7 (GAL) Subfield #23: Geometric Altitude Data = 0 Absence of Subfield #23 = 1 Presence
   * of Subfield #23
   *
   * <p>bit-6 (PUN) Subfield #24: Position Uncertainty Data = 0 Absence of Subfield #24 = 1 Presence
   * of Subfield #24
   *
   * <p>bit-5 (MB) Subfield #25: Mode S MB Data = 0 Absence of Subfield #25 = 1 Presence of Subfield
   * #25
   *
   * <p>bit-4 (IAR) Subfield #26: Indicated Airspeed = 0 Absence of Subfield #26 = 1 Presence of
   * Subfield #26
   *
   * <p>bit-3 (MAC) Subfield #27: Mach Number = 0 Absence of Subfield #27 = 1 Presence of Subfield
   * #27
   *
   * <p>bit-2 (BPS) Subfield #28: Barometric Pressure Setting. = 0 Absence of Subfield #28 = 1
   * Presence of Subfield #28
   *
   * <p>bit-1 FX Extension indicator = 0 no extension = 1 extension
   */
  private DataSpec dataSpec;

  /**
   * Structure of Subfield # 1:
   *
   * <p>Target Address
   */
  private TargetAddress targetAddress;

  /**
   * Structure of Subfield # 2:
   *
   * <p>Target Identification
   */
  private TargetIdentification targetIdentification;

  /**
   * Structure of Subfield # 3:
   *
   * <p>Magnetic Heading
   */
  private MagneticHeading magneticHeading;

  /**
   * Structure of Subfield # 4:
   *
   * <p>Indicated Airspeed / Mach No
   */
  private Airspeed airspeed;

  /**
   * Structure of Subfield # 5:
   *
   * <p>True Airspeed
   */
  private TrueAirspeed trueAirspeed;

  /**
   * Structure of Subfield # 6:
   *
   * <p>Selected Altitude
   *
   * <p>Definition : The short-term vertical intent as described by either the FMS selected
   * altitude, the Altitude Control Panel Selected Altitude (FCU/MCP), or the current aircraft
   * altitude according to the aircraft's mode of flight.
   */
  private SelectedAltitude selectedAltitude;

  /**
   * Structure of Subfield # 7:
   *
   * <p>Final State Selected Altitude
   *
   * <p>Definition : The vertical intent value that corresponds with the ATC cleared altitude, as
   * derived from the Altitude Control Panel (FCU/MCP).
   */
  private FinalStateSelectedAltitude finalStateSelectedAltitude;

  /**
   * Structure of Subfield #8:
   *
   * <p>Trajectory Intent Status
   */
  private TrajectoryIntentStatus trajectoryIntentStatus;

  /**
   * Structure of Subfield # 9:
   *
   * <p>Trajectory Intent Data Format: Repetitive Data Item starting with a one-octet Field
   * Repetition Indicator (REP) followed by at least one Trajectory Intent Point comprising fifteen
   * octets
   */
  private TrajectoryIntentData trajectoryIntentData;

  /**
   * Structure of Subfield # 10:
   *
   * <p>Communications/ACAS Capability and Flight Status reported by Mode-S
   */
  private CommAndStatusByModeSel communicationCapability;

  /**
   * Structure of Subfield # 11:
   *
   * <p>Status reported by ADS-B
   */
  private StatusByAdsb statusByAdsb;

  /**
   * Structure of Subfield # 12:
   *
   * <p>ACAS Resolution Advisory Report
   *
   * <p>Definition : Currently active Resolution Advisory (RA), if any, generated by the ACAS
   * associated with the transponder transmitting the report and threat identity data.
   *
   * <p>Format : Seven-octet fixed length Data Item.
   */
  private AcasResolutionReport acasResolutionAdvisory;

  /**
   * Structure of Subfield # 13:
   *
   * <p>Barometric Vertical Rate
   */
  private BarometricVerticalRate barometricVerticalRate;

  /**
   * Structure of Subfield # 14:
   *
   * <p>Geometric Vertical Rate
   */
  private GeometricVerticalRate geometricVerticalRate;

  /**
   * Structure of Subfield # 15:
   *
   * <p>Roll Angle
   */
  private RollAngle rollAngle;

  /**
   * Structure of Subfield # 16:
   *
   * <p>Track Angle Rate
   */
  private TrackAngleRate trackAngleRate;

  /**
   * Structure of Subfield # 17:
   *
   * <p>Track Angle
   *
   * <p>0-360无符号
   */
  private TrackAngle trackAngle;

  /**
   * Structure of Subfield # 18:
   *
   * <p>Ground Speed
   */
  private GroundSpeed groundSpeed;

  /**
   * Structure of Subfield # 19:
   *
   * <p>Velocity Uncertainty
   */
  private VelocityUncertainty velocityUncertainty;

  /**
   * Structure of Subfield # 20:
   *
   * <p>Met Data
   */
  private MetData metData;

  /**
   * Structure of Subfield # 21:
   *
   * <p>Emitter Category
   */
  private EmitterCategoryEnum emitterCategory;

  /**
   * Structure of Subfield # 22:
   *
   * <p>Position
   */
  private Wgs84Position position;

  /**
   * Structure of Subfield # 23:
   *
   * <p>Geometric Altitude
   */
  private GeometricAltitude geometricAltitude;

  /**
   * Structure of Subfield # 24:
   *
   * <p>Position Uncertainty
   */
  private PositionUncertainty positionUncertainty;

  /**
   * Structure of Subfield # 25:
   *
   * <p>MODE S MB DATA
   *
   * <p>Format : Repetitive starting with an one-octet Field Repetition Indicator (REP) followed by
   * at least one BDS report comprising one seven octet BDS register and one octet BDS code.
   */
  private ModeSelMbData modesMbData;

  /**
   * Structure of Subfield # 26:
   *
   * <p>Indicated Airspeed
   */
  private Airspeed indicatedAirspeed;

  /**
   * Structure of Subfield # 27
   *
   * <p>Mach Number
   */
  private Airspeed machNumber;

  /**
   * Structure of Subfield # 28:
   *
   * <p>Barometric Pressure Setting (derived from Mode S BDS 4,0)
   */
  private BarometricPressureSetting barometricPressureSetting;
}
