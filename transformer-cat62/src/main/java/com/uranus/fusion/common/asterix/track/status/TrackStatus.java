package com.uranus.fusion.common.asterix.track.status;

import com.uranus.fusion.common.asterix.track.status.type.AdsBroadcastConsistentStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.AgeStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.AmalgamationStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.CalculatedAltitudeSourceEnum;
import com.uranus.fusion.common.asterix.track.status.type.DataConflictStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.DataDuplicateStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.EarlyTrackIndicationEnum;
import com.uranus.fusion.common.asterix.track.status.type.EmergencyStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.FinalTrackIndicationEnum;
import com.uranus.fusion.common.asterix.track.status.type.FlightPlanCorrelatedStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.FplDataStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.InterrogationStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.MilitaryEmergencyStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.MilitaryIdentificationStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.MostReliableAltitudeStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.PotentialFalseStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.SensorSourceStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.ServiceUsedEnum;
import com.uranus.fusion.common.asterix.track.status.type.SlavePromotionStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.SpecialUsedCodeStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.SpiStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.SurveillanceDataStatusEnum;
import com.uranus.fusion.common.asterix.track.status.type.TargetTypeEnum;
import com.uranus.fusion.common.asterix.track.status.type.TrackCertaintyStatusEnum;

/**
 * TrackStatus
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/5
 */
public class TrackStatus {

  private SensorSourceStatusEnum sensorSourceStatusEnum;
  private SpiStatusEnum spiStatusEnum;
  private MostReliableAltitudeStatusEnum mostReliableAltitudeStatusEnum;
  private CalculatedAltitudeSourceEnum calculatedAltitudeSourceEnum;
  private TrackCertaintyStatusEnum trackCertaintyStatusEnum;

  private TargetTypeEnum targetTypeEnum;
  private EarlyTrackIndicationEnum earlyTrackIndicationEnum;
  private FinalTrackIndicationEnum finalTrackIndicationEnum;
  private FlightPlanCorrelatedStatusEnum flightPlanCorrelatedStatusEnum;
  private AdsBroadcastConsistentStatusEnum adsBroadcastConsistentStatusEnum;
  private SlavePromotionStatusEnum slavePromotionStatusEnum;
  private ServiceUsedEnum serviceUsedEnum;

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

  public SensorSourceStatusEnum getSensorSourceStatusEnum() {
    return sensorSourceStatusEnum;
  }

  public void setSensorSourceStatusEnum(
      SensorSourceStatusEnum sensorSourceStatusEnum) {
    this.sensorSourceStatusEnum = sensorSourceStatusEnum;
  }

  public SpiStatusEnum getSpiStatusEnum() {
    return spiStatusEnum;
  }

  public void setSpiStatusEnum(SpiStatusEnum spiStatusEnum) {
    this.spiStatusEnum = spiStatusEnum;
  }

  public MostReliableAltitudeStatusEnum getMostReliableAltitudeStatusEnum() {
    return mostReliableAltitudeStatusEnum;
  }

  public void setMostReliableAltitudeStatusEnum(
      MostReliableAltitudeStatusEnum mostReliableAltitudeStatusEnum) {
    this.mostReliableAltitudeStatusEnum = mostReliableAltitudeStatusEnum;
  }

  public CalculatedAltitudeSourceEnum getCalculatedAltitudeSourceEnum() {
    return calculatedAltitudeSourceEnum;
  }

  public void setCalculatedAltitudeSourceEnum(
      CalculatedAltitudeSourceEnum calculatedAltitudeSourceEnum) {
    this.calculatedAltitudeSourceEnum = calculatedAltitudeSourceEnum;
  }

  public TrackCertaintyStatusEnum getTrackCertaintyStatusEnum() {
    return trackCertaintyStatusEnum;
  }

  public void setTrackCertaintyStatusEnum(
      TrackCertaintyStatusEnum trackCertaintyStatusEnum) {
    this.trackCertaintyStatusEnum = trackCertaintyStatusEnum;
  }

  public TargetTypeEnum getTargetTypeEnum() {
    return targetTypeEnum;
  }

  public void setTargetTypeEnum(TargetTypeEnum targetTypeEnum) {
    this.targetTypeEnum = targetTypeEnum;
  }

  public EarlyTrackIndicationEnum getEarlyTrackIndicationEnum() {
    return earlyTrackIndicationEnum;
  }

  public void setEarlyTrackIndicationEnum(
      EarlyTrackIndicationEnum earlyTrackIndicationEnum) {
    this.earlyTrackIndicationEnum = earlyTrackIndicationEnum;
  }

  public FinalTrackIndicationEnum getFinalTrackIndicationEnum() {
    return finalTrackIndicationEnum;
  }

  public void setFinalTrackIndicationEnum(
      FinalTrackIndicationEnum finalTrackIndicationEnum) {
    this.finalTrackIndicationEnum = finalTrackIndicationEnum;
  }

  public FlightPlanCorrelatedStatusEnum getFlightPlanCorrelatedStatusEnum() {
    return flightPlanCorrelatedStatusEnum;
  }

  public void setFlightPlanCorrelatedStatusEnum(
      FlightPlanCorrelatedStatusEnum flightPlanCorrelatedStatusEnum) {
    this.flightPlanCorrelatedStatusEnum = flightPlanCorrelatedStatusEnum;
  }

  public AdsBroadcastConsistentStatusEnum getAdsBroadcastConsistentStatusEnum() {
    return adsBroadcastConsistentStatusEnum;
  }

  public void setAdsBroadcastConsistentStatusEnum(
      AdsBroadcastConsistentStatusEnum adsBroadcastConsistentStatusEnum) {
    this.adsBroadcastConsistentStatusEnum = adsBroadcastConsistentStatusEnum;
  }

  public SlavePromotionStatusEnum getSlavePromotionStatusEnum() {
    return slavePromotionStatusEnum;
  }

  public void setSlavePromotionStatusEnum(
      SlavePromotionStatusEnum slavePromotionStatusEnum) {
    this.slavePromotionStatusEnum = slavePromotionStatusEnum;
  }

  public ServiceUsedEnum getServiceUsedEnum() {
    return serviceUsedEnum;
  }

  public void setServiceUsedEnum(
      ServiceUsedEnum serviceUsedEnum) {
    this.serviceUsedEnum = serviceUsedEnum;
  }

  public AmalgamationStatusEnum getAmalgamationStatusEnum() {
    return amalgamationStatusEnum;
  }

  public void setAmalgamationStatusEnum(
      AmalgamationStatusEnum amalgamationStatusEnum) {
    this.amalgamationStatusEnum = amalgamationStatusEnum;
  }

  public InterrogationStatusEnum getMode4InterrogationStatus() {
    return mode4InterrogationStatus;
  }

  public void setMode4InterrogationStatus(InterrogationStatusEnum mode4InterrogationStatus) {
    this.mode4InterrogationStatus = mode4InterrogationStatus;
  }

  public MilitaryEmergencyStatusEnum getMilitaryEmergencyStatusEnum() {
    return militaryEmergencyStatusEnum;
  }

  public void setMilitaryEmergencyStatusEnum(
      MilitaryEmergencyStatusEnum militaryEmergencyStatusEnum) {
    this.militaryEmergencyStatusEnum = militaryEmergencyStatusEnum;
  }

  public MilitaryIdentificationStatusEnum getMilitaryIdentificationStatusEnum() {
    return militaryIdentificationStatusEnum;
  }

  public void setMilitaryIdentificationStatusEnum(
      MilitaryIdentificationStatusEnum militaryIdentificationStatusEnum) {
    this.militaryIdentificationStatusEnum = militaryIdentificationStatusEnum;
  }

  public InterrogationStatusEnum getMode5InterrogationStatus() {
    return mode5InterrogationStatus;
  }

  public void setMode5InterrogationStatus(InterrogationStatusEnum mode5InterrogationStatus) {
    this.mode5InterrogationStatus = mode5InterrogationStatus;
  }

  public AgeStatusEnum getCoastingStatusEnum() {
    return coastingStatusEnum;
  }

  public void setCoastingStatusEnum(
      AgeStatusEnum coastingStatusEnum) {
    this.coastingStatusEnum = coastingStatusEnum;
  }

  public AgeStatusEnum getAgeStatusEnum() {
    return ageStatusEnum;
  }

  public void setAgeStatusEnum(AgeStatusEnum ageStatusEnum) {
    this.ageStatusEnum = ageStatusEnum;
  }

  public AgeStatusEnum getSsrStatusEnum() {
    return ssrStatusEnum;
  }

  public void setSsrStatusEnum(AgeStatusEnum ssrStatusEnum) {
    this.ssrStatusEnum = ssrStatusEnum;
  }

  public AgeStatusEnum getModeSStatusEnum() {
    return modeSStatusEnum;
  }

  public void setModeSStatusEnum(AgeStatusEnum modeSStatusEnum) {
    this.modeSStatusEnum = modeSStatusEnum;
  }

  public AgeStatusEnum getAdsbStatusEnum() {
    return adsbStatusEnum;
  }

  public void setAdsbStatusEnum(AgeStatusEnum adsbStatusEnum) {
    this.adsbStatusEnum = adsbStatusEnum;
  }

  public SpecialUsedCodeStatusEnum getSpecialUsedCodeStatusEnum() {
    return specialUsedCodeStatusEnum;
  }

  public void setSpecialUsedCodeStatusEnum(
      SpecialUsedCodeStatusEnum specialUsedCodeStatusEnum) {
    this.specialUsedCodeStatusEnum = specialUsedCodeStatusEnum;
  }

  public DataConflictStatusEnum getDataConflictStatusEnum() {
    return dataConflictStatusEnum;
  }

  public void setDataConflictStatusEnum(
      DataConflictStatusEnum dataConflictStatusEnum) {
    this.dataConflictStatusEnum = dataConflictStatusEnum;
  }

  public SurveillanceDataStatusEnum getSurveillanceDataStatusEnum() {
    return surveillanceDataStatusEnum;
  }

  public void setSurveillanceDataStatusEnum(
      SurveillanceDataStatusEnum surveillanceDataStatusEnum) {
    this.surveillanceDataStatusEnum = surveillanceDataStatusEnum;
  }

  public EmergencyStatusEnum getEmergencyStatusEnum() {
    return emergencyStatusEnum;
  }

  public void setEmergencyStatusEnum(
      EmergencyStatusEnum emergencyStatusEnum) {
    this.emergencyStatusEnum = emergencyStatusEnum;
  }

  public PotentialFalseStatusEnum getPotentialFalseStatusEnum() {
    return potentialFalseStatusEnum;
  }

  public void setPotentialFalseStatusEnum(
      PotentialFalseStatusEnum potentialFalseStatusEnum) {
    this.potentialFalseStatusEnum = potentialFalseStatusEnum;
  }

  public FplDataStatusEnum getFplDataStatusEnum() {
    return fplDataStatusEnum;
  }

  public void setFplDataStatusEnum(
      FplDataStatusEnum fplDataStatusEnum) {
    this.fplDataStatusEnum = fplDataStatusEnum;
  }

  public DataDuplicateStatusEnum getDuplicateMode3CodeStatus() {
    return duplicateMode3CodeStatus;
  }

  public void setDuplicateMode3CodeStatus(
      DataDuplicateStatusEnum duplicateMode3CodeStatus) {
    this.duplicateMode3CodeStatus = duplicateMode3CodeStatus;
  }

  public DataDuplicateStatusEnum getDuplicateFlightPlanStatus() {
    return duplicateFlightPlanStatus;
  }

  public void setDuplicateFlightPlanStatus(
      DataDuplicateStatusEnum duplicateFlightPlanStatus) {
    this.duplicateFlightPlanStatus = duplicateFlightPlanStatus;
  }

  public DataDuplicateStatusEnum getDuplicateManualFlightPlanStatus() {
    return duplicateManualFlightPlanStatus;
  }

  public void setDuplicateManualFlightPlanStatus(
      DataDuplicateStatusEnum duplicateManualFlightPlanStatus) {
    this.duplicateManualFlightPlanStatus = duplicateManualFlightPlanStatus;
  }
}
