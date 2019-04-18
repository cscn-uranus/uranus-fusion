package com.uranus.fusion.asterix.uap.track;

import com.uranus.fusion.asterix.uap.datainfo.TargetTypeEnum;
import com.uranus.fusion.asterix.uap.emitter.InterrogationStatusEnum;
import com.uranus.fusion.asterix.uap.emitter.adsb.AdsBroadcastConsistentStatusEnum;
import com.uranus.fusion.asterix.uap.flightplan.FlightPlanCorrelatedStatusEnum;
import com.uranus.fusion.asterix.uap.flightplan.FplDataStatusEnum;
import com.uranus.fusion.asterix.uap.measure.altitude.CalculatedAltitudeSourceEnum;
import com.uranus.fusion.asterix.uap.measure.altitude.MostReliableAltitudeStatusEnum;
import com.uranus.fusion.asterix.uap.military.MilitaryEmergencyStatusEnum;
import com.uranus.fusion.asterix.uap.military.MilitaryIdentificationStatusEnum;
import com.uranus.fusion.asterix.uap.track.status.*;
import lombok.Data;

/**
 * TrackStatus
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/5
 */
@Data
public class TrackStatus {

  private SensorSourceStatusEnum sensorSourceStatusEnum;
  private SpiStatusEnum spiStatusEnum;
  private MostReliableAltitudeStatusEnum mostReliableAltitudeStatusEnum;
  private CalculatedAltitudeSourceEnum calculatedAltitudeSourceEnum;
  private TrackCertaintyStatusEnum trackCertaintyStatusEnum;

  private TargetTypeEnum targetTypeEnum;
  private FirstMessageStatusEnum firstMessageStatusEnum;
  private LastMessageStatusEnum lastMessageStatusEnum;
  private FlightPlanCorrelatedStatusEnum flightPlanCorrelatedStatusEnum;
  private AdsBroadcastConsistentStatusEnum adsBroadcastConsistentStatusEnum;
  private SlavePromotionStatusEnum slavePromotionStatusEnum;
  private KindOfServiceStatusEnum kindOfServiceStatusEnum;

  private AmalgamationStatusEnum amalgamationStatusEnum;
  private InterrogationStatusEnum mode4InterrogationStatus;
  private MilitaryEmergencyStatusEnum militaryEmergencyStatusEnum;
  private MilitaryIdentificationStatusEnum militaryIdentificationStatusEnum;
  private InterrogationStatusEnum mode5InterrogationStatus;

  private AgeStatusEnum coastingStatusEnum;
  private AgeStatusEnum ageStatusEnum;
  private AgeStatusEnum ssrStatusEnum;
  private AgeStatusEnum modeSStatusEnum;
  private AgeStatusEnum adsbStatusEnum;
  private SpecialUsedCodeStatusEnum specialUsedCodeStatusEnum;
  private DataConflictStatusEnum dataConflictStatusEnum;

  private SurveillanceDataStatusEnum surveillanceDataStatusEnum;
  private EmergencyStatusEnum emergencyStatusEnum;
  private PotentialFalseStatusEnum potentialFalseStatusEnum;
  private FplDataStatusEnum fplDataStatusEnum;

  private DataDuplicateStatusEnum duplicateMode3CodeStatus;
  private DataDuplicateStatusEnum duplicateFlightPlanStatus;
  private DataDuplicateStatusEnum duplicateManualFlightPlanStatus;
}
