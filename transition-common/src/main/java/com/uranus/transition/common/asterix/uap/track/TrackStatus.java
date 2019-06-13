package com.uranus.transition.common.asterix.uap.track;

import com.uranus.transition.common.asterix.uap.datainfo.TargetTypeEnum;
import com.uranus.transition.common.asterix.uap.emitter.InterrogationStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.adsb.AdsBroadcastConsistentStatusEnum;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanCorrelatedStatusEnum;
import com.uranus.transition.common.asterix.uap.flightplan.FplDataStatusEnum;
import com.uranus.transition.common.asterix.uap.measure.altitude.CalculatedAltitudeSourceEnum;
import com.uranus.transition.common.asterix.uap.measure.altitude.MostReliableAltitudeStatusEnum;
import com.uranus.transition.common.asterix.uap.military.MilitaryEmergencyStatusEnum;
import com.uranus.transition.common.asterix.uap.military.MilitaryIdentificationStatusEnum;
import com.uranus.transition.common.asterix.uap.track.status.*;
import lombok.Data;

/**
 * TrackStatus
 *
 * <p>Data Item I062/080, Track Status
 *
 * Definition : Status of a track.
 *
 * Format : Variable length data
 * item comprising a first part of one Octet, followed by 1-Octet extents as necessary.
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/5
 */
@Data
public class TrackStatus {

  /** bit 8 (MON) = 0 Multisensor track = 1 Monosensor track */
  private SensorSourceStatusEnum sensorSourceStatusEnum;

  /**
   * bit 7 (SPI) = 0 default value = 1 SPI present in the last report received from a sensor capable
   * of decoding this data
   */
  private SpiStatusEnum spiStatusEnum;

  /**
   * bit 6 (MRH) Most Reliable Height = 0 Barometric altitude (Mode C) more reliable = 1 Geometric
   * altitude more reliable
   */
  private MostReliableAltitudeStatusEnum mostReliableAltitudeStatusEnum;

  /**
   * bits 5/3 (SRC) Source of calculated track altitude for I062/130 = 000 no source = 001 GNSS =
   * 010 3D radar = 011 triangulation = 100 fl from coverage = 101 speed look-up table = 110
   * default fl = 111 multilateration
   */
  private CalculatedAltitudeSourceEnum calculatedAltitudeSourceEnum;

  /** bit 2 (CNF) = = 0 Confirmed track = 1 Tentative track */
  private TrackCertaintyStatusEnum trackCertaintyStatusEnum;

  /** bit-8 (SIM) = 0 Actual track = 1 Simulated track */
  private TargetTypeEnum targetTypeEnum;

  /** bit-7 (TSE) = 0 default value = 1 last message transmitted to the user for the track */
  private FirstMessageStatusEnum firstMessageStatusEnum;

  /** bit-6 (TSB) = 0 default value = 1 first message transmitted to the user for the track */
  private LastMessageStatusEnum lastMessageStatusEnum;

  /** bit-5 (FPC) = 0 Not flight-plan correlated = 1 Flight plan correlated */
  private FlightPlanCorrelatedStatusEnum flightPlanCorrelatedStatusEnum;

  /**
   * bit-4 (AFF) = 0 default value = 1 ADS-B data inconsistent with other surveillance information
   */
  private AdsBroadcastConsistentStatusEnum adsBroadcastConsistentStatusEnum;

  /** bit-3 (STP) = 0 default value = 1 Slave Track Promotion */
  private SlavePromotionStatusEnum slavePromotionStatusEnum;

  /** bit-2 (KOS) = 0 Complementary service used = 1 Background service used */
  private KindOfServiceStatusEnum kindOfServiceStatusEnum;

  /**
   * bit 8 (AMA) = 0 track not resulting from amalgamation process = 1 track resulting from
   * amalgamation process
   */
  private AmalgamationStatusEnum amalgamationStatusEnum;

  /**
   * bits 7/6 (MD4) = 00 No Mode 4 interrogation = 01 Friendly target = 10 Unknown target = 11 No
   * reply
   */
  private InterrogationStatusEnum mode4InterrogationStatus;

  /**
   * bit 5 (ME) = 0 default value = 1 Military Emergency present in the last report received from a
   * sensor capable of decoding this data
   */
  private MilitaryEmergencyStatusEnum militaryEmergencyStatusEnum;

  /**
   * bit 4 (MI) = 0 default value = 1 Military Identification present in the last report received
   * from a sensor capable of decoding this data
   */
  private MilitaryIdentificationStatusEnum militaryIdentificationStatusEnum;

  /**
   * bits 3/2 (MD5) = 00 No Mode 5 interrogation = 01 Friendly target = 10 Unknown target = 11 No
   * reply
   */
  private InterrogationStatusEnum mode5InterrogationStatus;

  /**
   * bit-8 (CST) = 0 Default value = 1 Age of the last received track update is higher than system
   * dependent threshold (coasting)
   */
  private AgeStatusEnum coastingStatusEnum;

  /**
   * bit-7 (PSR) = 0 Default value = 1 Age of the last received PSR track update is higher than
   * system dependent threshold
   */
  private AgeStatusEnum psrStatusEnum;

  /**
   * bit-6 (SSR) = 0 Default value = 1 Age of the last received SSR track update is higher than
   * system dependent threshold
   */
  private AgeStatusEnum ssrStatusEnum;

  /**
   * bit-5 (MDS) = 0 Default value = 1 Age of the last received Mode S track update is higher than
   * system dependent threshold
   */
  private AgeStatusEnum modeselStatusEnum;

  /**
   * bit-4 (ADS) = 0 Default value = 1 Age of the last received ADS-B track update is higher than
   * system dependent threshold
   */
  private AgeStatusEnum adsbStatusEnum;

  /**
   * bit-3 (SUC) = 0 Default value = 1 Special Used Code (Mode A codes to be defined in the system
   * to mark a track with special interest)
   */
  private SpecialUsedCodeStatusEnum specialUsedCodeStatusEnum;

  /**
   * bit-2 (AAC) = 0 Default value = 1 Assigned Mode A Code Conflict (same discrete Mode A Code
   * assigned to another track)
   */
  private DataConflictStatusEnum dataConflictStatusEnum;

  /**
   * bits-8/7 (SDS) Surveillance Data Status = 00 Combined = 01 Co-operative only = 10
   * Non-Cooperative only = 11 Not defined
   */
  private SurveillanceDataStatusEnum surveillanceDataStatusEnum;

  /**
   * bits-6/4 (EMS) Emergency Status Indication = 0 No emergency = 1 General emergency = 2 Lifeguard
   * / medical = 3 Minimum fuel = 4 No communications = 5 Unlawful interference = 6 “Downed”
   * Aircraft = 7 Undefined
   */
  private EmergencyStatusEnum emergencyStatusEnum;

  /** bit-3 (PFT) = 0 No indication = 1 Potential False Track Indication */
  private PotentialFalseStatusEnum potentialFalseStatusEnum;

  /** bit-2 (FPLT) = 0 Default value = 1 Track created / updated with FPL data */
  private FplDataStatusEnum fplDataStatusEnum;

  /** bit-8 (DUPT) = 0 Default value = 1 Duplicate Mode 3/A Code */
  private DataDuplicateStatusEnum duplicateMode3CodeStatus;

  /** bit-7 (DUPF) = 0 Default value = 1 Duplicate Flight Plan */
  private DataDuplicateStatusEnum duplicateFlightPlanStatus;

  /** bit-6 (DUPM) = 0 Default value = 1 Duplicate Flight Plan due to manual correlation */
  private DataDuplicateStatusEnum duplicateManualFlightPlanStatus;

  /**
   *
   * SFC
   *
   * IDD
   *
   * IEC
   */
  ///TODO CAT062 新增的字段
}
